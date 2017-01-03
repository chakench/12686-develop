package hbi.core.task.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.service.IBaseService;
import hbi.core.task.dto.ItemHeader;
import hbi.core.task.dto.ItemLine;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhe on 2016/12/21.
 */
public interface ITaskService {

    //查询任务行设置头
    List<ItemHeader> findAllHeader(ItemHeader itemHeader,int page,int pageSize);

    //删除任务行设置头
    void deleteHeaders(List<ItemHeader> itemHeader);

    //插入任务行设置头
    void addHeader(List<ItemHeader> list);

    //查找头ID
    Long selectItemHeaderId(ItemHeader itemHeader);
    //更新设置头
    int updateHeader(List<ItemHeader> list);
}
