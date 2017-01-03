package hbi.core.task.controllers;

import com.hand.hap.system.dto.ResponseData;
import hbi.core.task.dto.ItemLine;
import hbi.core.task.service.ItemLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenhe on 2016/12/22.
 */
@RestController
public class ItemLineController {
    @Autowired
    private ItemLineService itemLineService;

    /**
     * 查询任务行设置行
     * @param itemHeaderId
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findHeaderLine")
    private ResponseData findHeaderLine(int itemHeaderId, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int pageSize){
        System.out.print("***************"+itemHeaderId);
        List<ItemLine> list =itemLineService.findLines(itemHeaderId,page,pageSize);
        for (ItemLine item:list){
            System.out.print("dddd"+item);
        }
        return new ResponseData(list);
    }

    /**
     * 新增设置行
     * @param list
     * @return
     */
    @RequestMapping(value = "/addLines")
    private ResponseData addLines(@RequestBody List<ItemLine> list){
        System.out.print("*******"+list);
        List<ItemLine> itemLines=itemLineService.addLines(list);
        return  new ResponseData(itemLines);
    }

    /**
     * 删除设置行
     * @return
     */
    @RequestMapping(value = "/deleteLines")
    private ResponseData deleteLines(@RequestBody List<ItemLine> list){
        itemLineService.deleteLines(list);
        return new ResponseData();
    }

    /**
     * 更新
     * @param list
     * @return
     */
    @RequestMapping(value = "/updateLines")
    private ResponseData updateLines(@RequestBody List<ItemLine> list){
        int n=itemLineService.updateLines(list);
        if(n>0){
            return new ResponseData(true);
        }else {
            return new ResponseData(false);
        }
    }
}
