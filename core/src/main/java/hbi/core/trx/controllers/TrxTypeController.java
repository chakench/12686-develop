package hbi.core.trx.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.trx.dto.TrxDetail;
import hbi.core.trx.dto.TrxType;
import hbi.core.trx.service.ITrxDetailService;
import hbi.core.trx.service.ITrxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2016/12/26.
 */
@RestController
public class TrxTypeController{
    @Resource(name = "trxTypeService")
    private ITrxTypeService trxTypeService;
    @Resource(name ="iTrxDetailService")
    private ITrxDetailService iTrxDetailService;

    /**
     * 查询
     * @param trxType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/trx/findAll")
    private ResponseData findAll(TrxType trxType, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10")int pageSize){
        List<TrxType> list =trxTypeService.findAll(trxType,page,pageSize);
        return new ResponseData(list);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    @RequestMapping(value = "/trx/deleteTrxType")
    private ResponseData deleteTrxType(@RequestBody List<TrxType> list){
        int n =trxTypeService.deleteTrxType(list);
        if(n>0){
            return new ResponseData(true);
        }else{
            return new ResponseData(false);
        }
    }

    /**
     * 新增
     * @param list
     * @return
     */
    @RequestMapping(value = "/trx/addTrxType")
    private ResponseData addTrxType(@RequestBody List<TrxType> list){
        for(TrxType type:list){
            System.out.print("addTrxType="+type);
        }
        List<TrxType> trxTypes=trxTypeService.addTrxType(list);
        if(trxTypes.size()!=0){
            return new ResponseData(trxTypes);
        }else{
            List message=new ArrayList();
            message.add(1);  //代表名字或类型重复
            return new ResponseData(message);
        }
    }

    /**
     * 更新
     * @param list
     * @return
     */
    @RequestMapping(value = "/trx/updateTrxType")
    private ResponseData updateTrxType(@RequestBody List<TrxType> list){
        for(TrxType type:list){
            System.out.print("updateTrxType="+type);
        }
        List<TrxType> trxTypes=trxTypeService.updateTrxType(list);

        System.out.print("size="+trxTypes.size());
        if(trxTypes.size()!=0){
            return new ResponseData(trxTypes);
        }else{
            List message=new ArrayList();
            message.add(2);  //代表已经存在一个有效状态
            return new ResponseData(message);
        }
    }

    /**
     * 新增版本 拷贝数据
     * @param trxType
     * @return
     */
    @RequestMapping(value = "/trx/addVersion")
    private ResponseData addVersion(TrxType trxType){
        System.out.print("id00--------"+trxType.getTrxTypeId());
        Long n1=trxType.getTrxTypeId();
        TrxType type=trxTypeService.addVersion(trxType);
        Long n=type.getTrxTypeId();
        System.out.print("11--------"+type.getTrxTypeId());
        TrxDetail detail=new TrxDetail();
        detail.setTrxId(n1);
        iTrxDetailService.copyTrxDetail(detail,n);
        if(n>0){
            return new ResponseData(true);
        }else{
            return new ResponseData(false);
        }
    }
}
