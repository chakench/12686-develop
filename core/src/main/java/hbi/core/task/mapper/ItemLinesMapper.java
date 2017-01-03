package hbi.core.task.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.task.dto.ItemLine;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by chenhe on 2016/12/22.
 */
@Repository("itemLinesMapper")
public interface ItemLinesMapper extends Mapper<ItemLine> {
    //查询任务行设置行
    List<ItemLine> findLines(int itemHeaderId);
    //插入任务行设置行
    int addLines(ItemLine itemLine);
    //删除设置行
    int deleteLines(ItemLine itemLine);
    //更新
    int updateLines(ItemLine itemLine);
}
