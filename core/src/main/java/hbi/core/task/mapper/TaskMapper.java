package hbi.core.task.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.task.dto.ItemHeader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenhe on 2016/12/21.
 */
@Repository("taskMapper")
public interface TaskMapper extends Mapper<ItemHeader>{
    //查询任务行设置头
    List<ItemHeader> findAllHeader(ItemHeader itemHeader);
    //删除任务行设置头
    void deleteHeaders(ItemHeader itemHeader);
    //插入任务行设置头
    int addHeader(ItemHeader itemHeader);
    //查找头ID
    Long selectItemHeaderId(ItemHeader itemHeader);
    //更新
    int updateHeader(ItemHeader itemHeader);
}
