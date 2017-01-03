package hbi.core.task.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.task.dto.ItemHeader;
import hbi.core.task.dto.ItemLine;
import hbi.core.task.mapper.ItemLinesMapper;
import hbi.core.task.mapper.TaskMapper;
import hbi.core.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenhe on 2016/12/21.
 */
@Service
public class TaskServiceImpl implements ITaskService {
    @Resource(name = "taskMapper")
    private TaskMapper taskMapper;
    @Resource(name = "itemLinesMapper")
    private ItemLinesMapper itemLinesMapper;
    /**
     * 查询任务行设置头
     * @param itemHeader
     * @return
     */
    @Override
    public List<ItemHeader> findAllHeader(ItemHeader itemHeader,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return taskMapper.findAllHeader(itemHeader);
    }

    /**
     * 删除任务行设置头
     * @param itemHeader
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteHeaders(List<ItemHeader> itemHeader) {
        for(ItemHeader header:itemHeader){
            taskMapper.deleteHeaders(header);
            ItemLine line=new ItemLine();
            line.setItemHeaderId(header.getItemHeaderId());
            itemLinesMapper.deleteLines(line);
        }
    }

    /**
     * 插入任务行设置头
     * @param list
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addHeader(List<ItemHeader> list) {
        for(ItemHeader itemHeader:list){
            taskMapper.addHeader(itemHeader);
        }
    }

    /**
     * 更新
     * @param list
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateHeader(List<ItemHeader> list){
        int n=0;
        for(ItemHeader itemHeader:list){
            n=taskMapper.updateHeader(itemHeader);
            if(n==0)
                return n;
        }
        return n;
    }
    /**
     * 查找头ID
     * @param itemHeader
     * @return
     */
    @Override
    public Long selectItemHeaderId(ItemHeader itemHeader) {
        return taskMapper.selectItemHeaderId(itemHeader);
    }
}
