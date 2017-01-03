package hbi.core.trx.service.impl;

import hbi.core.trx.dto.TrxDetail;
import hbi.core.trx.mapper.TrxDetailMapper;
import hbi.core.trx.service.ITrxDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2016/12/27.
 */
@Service("iTrxDetailService")
public class TrxDetailServiceImpl implements ITrxDetailService{
    @Resource(name = "trxDetailMapper")
    private TrxDetailMapper trxDetailMapper;
    private Long s = null;

    /**
     * 查询事物层次结构
     * @param trxDetail
     * @return
     */
    @Override
    public List<TrxDetail> findTrxDetails(TrxDetail trxDetail) {

        return trxDetailMapper.findTrxDetails(trxDetail);
    }

    /**
     * 新增 更新事物层次
     * @param trxDetail
     * @return
     */
    @Override
    public TrxDetail addTrxDetail(TrxDetail trxDetail) {
        int isExist =trxDetailMapper.isExist(trxDetail);
        System.out.println("is="+isExist);
        if(isExist!=0){  //存在
            return null;
        }else {
            if (trxDetail.getTrxDetailId() == 0) {
                System.out.print("新增");
                trxDetailMapper.addTrxDetail(trxDetail);
                trxDetail.setObjectVersionNumber(Long.valueOf(1));
                return trxDetail;
            }else {
                System.out.print("更新");
                trxDetailMapper.updateTrxDetail(trxDetail);
                trxDetail.setObjectVersionNumber(trxDetail.getObjectVersionNumber());
                return trxDetail;
            }
        }
    }

    /**
     * 拷贝树形层次结构
     * @param trxDetail
     * @return
     */
    @Override
    public TrxDetail copyTrxDetail(TrxDetail trxDetail,Long trxId) {
        Long id =trxDetail.getTrxId();   //要复制的主表ID
        TrxDetail root=trxDetailMapper.findOneTrxDetail(id);  //根节点
        Long parentId =root.getTrxDetailId();   //设置父亲节点
        root.setTrxId(trxId);
        trxDetailMapper.addTrxDetail(root);   //加入根节点
        Long masterId = root.getTrxDetailId();  // 返回主键

        cycle(id,parentId,trxId,masterId);   //递归
        return null;
    }
    //递归调用
    public void cycle(Long trxIdBefore,Long parentId,Long trxId,Long masterId){
        TrxDetail trxDetail =new TrxDetail();
        trxDetail.setTrxId(trxIdBefore);
        trxDetail.setParentDetailId(parentId);
        System.out.println("trxIdBefore==="+trxIdBefore);
        System.out.println("parentId==="+parentId);
        System.out.println("trxId==="+trxId);
        System.out.println("masterId==="+masterId);
        List<TrxDetail> list=trxDetailMapper.findTrxDetails(trxDetail);
        if(list.size()==0){
            return ;
        }else{
            for(TrxDetail detail:list){
                detail.setTrxId(trxId);
                detail.setParentDetailId(masterId);
                Long idBefore =detail.getTrxDetailId();
                trxDetailMapper.addTrxDetail(detail);
                cycle(trxIdBefore,idBefore,trxId,detail.getTrxDetailId());
            }
        }
    }

    /**
     * 删除树形层次结构
     * @param trxDetail
     */
    @Override
    public void deleteTrxDetail(TrxDetail trxDetail) {
        if(trxDetail.getParentDetailId()!=null){  //不是根节点，就删除
            trxDetailMapper.deleteTrxDetail(trxDetail);
            trxDetail.setParentDetailId(trxDetail.getTrxDetailId());
            List<TrxDetail> list =trxDetailMapper.findTrxDetails(trxDetail);
            if(list.size()==0){
                return ;
            }else {
                for(TrxDetail trx:list){
                    deleteTrxDetail(trx);
                }
            }
        }
    }
}
