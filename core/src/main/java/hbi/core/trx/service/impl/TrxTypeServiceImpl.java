package hbi.core.trx.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.trx.dto.TrxDetail;
import hbi.core.trx.dto.TrxType;
import hbi.core.trx.mapper.TrxDetailMapper;
import hbi.core.trx.mapper.TrxTypeMapper;
import hbi.core.trx.service.ITrxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by chenhe on 2016/12/26.
 */
@Service("trxTypeService")
public class TrxTypeServiceImpl extends BaseServiceImpl<TrxType> implements ITrxTypeService{
    @Resource(name = "trxTypeMapper")
    private TrxTypeMapper trxTypeMapper;
    @Resource(name = "trxDetailMapper")
    private TrxDetailMapper trxDetailMapper;
    /**
     * 查询所有的事物
     * @param trxType
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<TrxType> findAll(TrxType trxType, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return trxTypeMapper.findAll(trxType);
    }

    /**
     * 删除事物
     * @param list
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int deleteTrxType(List<TrxType> list) {
        int n=0;
        for(TrxType type:list){
            n =trxTypeMapper.deleteTrxType(type);
            if(n==0)
                return n;
            TrxDetail trxDetail =new TrxDetail();
            trxDetail.setTrxId(type.getTrxTypeId());
            trxDetailMapper.deleteTrxDetail(trxDetail);  //删除子表
        }
        return n;
    }

    /**
     * 新增事物
     * @param list
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<TrxType> addTrxType(List<TrxType> list) {
        List<TrxType> trxTypes =new ArrayList();
        int isExist=0;
        for(TrxType type:list){
            isExist =trxTypeMapper.isExist(type);
            System.out.print("is=="+isExist);
            if(isExist==0){   //不存在
                trxTypeMapper.addTrxType(type);  //新增
                type.setObjectVersionNumber(Long.valueOf(1));
                trxTypes.add(type);

                //首次新增本事务的层次结构
                TrxDetail trxDetail =new TrxDetail(type.getTrxTypeId(),type.getTrxType(),type.getTrxTypeName(),"ROOT_CATE",null,"Y");
                trxDetailMapper.addTrxDetail(trxDetail);
            }
        }
        return trxTypes;
    }

    /**
     * 更新
     * @param types
     * @return
     */
    @Override
    public List<TrxType> updateTrxType(List<TrxType> types) {
        List<TrxType> trxTypes =new ArrayList();
        for(TrxType type:types){
            TrxType type1= type.clone();  //克隆
            type1.setTrxTypeId(null);
            int num =trxTypeMapper.countOfActive(type1);
            int count =0;
            if(type.getStatusCode().equals("ACTIVE")){
                count = trxTypeMapper.countOfActive(type);
            }
            if((count==0&& type.getStatusCode().equals("DRAFT")&&num==1) || (count==1&& type.getStatusCode().equals("ACTIVE")&&num==1) || num==0) {
                trxTypeMapper.updateTrxType(type);
                type.setObjectVersionNumber(type.getObjectVersionNumber() + 1);
                trxTypes.add(type);
            }
        }
        return trxTypes;
    }

    /**
     * 新增版本 拷贝数据
     * @param trxType
     * @return
     */
    @Override
    public TrxType addVersion(TrxType trxType) {

         trxTypeMapper.addVersion(trxType);
         return trxType;
    }


}
