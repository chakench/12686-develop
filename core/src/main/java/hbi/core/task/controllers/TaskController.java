package hbi.core.task.controllers;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.task.dto.ItemHeader;
import hbi.core.task.service.ITaskService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2016/12/21.
 */

@RestController
public class TaskController{
    @Autowired()
    private ITaskService taskService;

    /**
     * 查询任务行设置头
     * @param itemHeader
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findAllHeader")
    private ResponseData findAllHeader(ItemHeader itemHeader, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int pageSize){
        List<ItemHeader> list =taskService.findAllHeader(itemHeader,page,pageSize);

        return new ResponseData(list);
    }

    /**
     * 删除任务行设置头
     * @param list
     * @return
     */
    @RequestMapping(value = "/deleteHeaders")
    private ResponseData deleteHeaders(@RequestBody List<ItemHeader> list){
        taskService.deleteHeaders(list);
        return new ResponseData();
    }

    /**
     * 新增任务行设置头
     * @param list
     * @return
     */
    @RequestMapping(value = "/addHeaders")
    private ResponseData addHeader(@RequestBody  List<ItemHeader> list){
        Long itemHeaderId=null;
        boolean f =false;
        for(ItemHeader item:list){//初次判断是否重复
            System.out.print("item---"+item);
            itemHeaderId=taskService.selectItemHeaderId(item);
            if(itemHeaderId==null){   //数据库不存在
                taskService.addHeader(list);  //插入
                System.out.print("item111----"+item);
                itemHeaderId=taskService.selectItemHeaderId(item);
            }else{
                f=true;
            }
        }
        List idList=new ArrayList();
        idList.add(itemHeaderId);
        idList.add(f);
        return new ResponseData(idList);
    }

    /**
     * 更新设置头
     * @param list
     * @return
     */
    @RequestMapping(value = "/updateHeader")
    private ResponseData updateHeader(@RequestBody List<ItemHeader> list){
        Long itemHeaderId=null;
        int n=0;
        boolean f =false;
        for(ItemHeader item:list){
            itemHeaderId=taskService.selectItemHeaderId(item);  //不存在
            if(itemHeaderId==null){
                n=taskService.updateHeader(list);
                f=true;
            }
            System.out.print("123=="+list);
        }
        List fList=new ArrayList();
        fList.add(n);
        fList.add(f);
        return new ResponseData(fList);
    }
}
