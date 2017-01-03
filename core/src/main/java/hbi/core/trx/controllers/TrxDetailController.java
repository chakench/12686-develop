package hbi.core.trx.controllers;

import com.hand.hap.system.dto.ResponseData;
import hbi.core.trx.dto.TrxDetail;
import hbi.core.trx.service.ITrxDetailService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2016/12/27.
 */
@RestController
public class TrxDetailController {
    @Resource(name = "iTrxDetailService")
    private ITrxDetailService iTrxDetailService;

    /**
     * 查询事物层次结构
     * @param trxDetail
     * @return
     */
    @RequestMapping(value = "/trx/detail/findTrxDetails")
    private ResponseData findTrxDetails(TrxDetail trxDetail){
        List<TrxDetail> list =iTrxDetailService.findTrxDetails(trxDetail);
        return new ResponseData(list);
    }

    /**
     * 增加
     * @param trxDetail
     * @return
     */
    @RequestMapping(value = "/trx/detail/addTrxDetail")
    private ResponseData addTrxDetail(@RequestBody TrxDetail trxDetail){
        System.out.print("addTrxDetail*******"+trxDetail);
        TrxDetail detail=iTrxDetailService.addTrxDetail(trxDetail);
        if(detail==null){
            return new ResponseData(false);
        }else{
            List data =new ArrayList();
            data.add(detail);
            return new ResponseData(data);
        }
    }

    /**
     * 删除树结构
     * @param trxDetail
     * @return
     */
    @RequestMapping(value = "/trx/detail/deleteTrxDetail")
    private ResponseData deleteTrxDetail(@RequestBody TrxDetail trxDetail){
        System.out.print("deleteTrxDetail*******"+trxDetail);
        iTrxDetailService.deleteTrxDetail(trxDetail);
        return new ResponseData();
    }
}
