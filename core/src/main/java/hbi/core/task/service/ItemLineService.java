package hbi.core.task.service;

import hbi.core.task.dto.ItemLine;

import java.util.List;

/**
 * Created by chenhe on 2016/12/22.
 */
public interface ItemLineService {
    //查询任务行设置行
    List<ItemLine> findLines(int itemHeaderId,int page,int pageSize);

    //插入任务行设置行
    List<ItemLine> addLines(List<ItemLine> list);          //*********

    //删除设置行
    void deleteLines(List<ItemLine> itemLine);

    //更新
    int updateLines(List<ItemLine> itemLineList);
}
