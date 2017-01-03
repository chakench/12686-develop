package hbi.core.task.service.impl;

import com.github.pagehelper.PageHelper;
import hbi.core.task.dto.ItemLine;
import hbi.core.task.mapper.ItemLinesMapper;
import hbi.core.task.service.ItemLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2016/12/22.
 */
@Service
public class ItemLineServiceImpl implements ItemLineService{
    @Autowired
    private ItemLinesMapper itemLinesMapper;

    /**
     * 查询任务行设置行
     * @param itemHeaderId
     * @return
     */
    @Override
    public List<ItemLine> findLines(int itemHeaderId,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return itemLinesMapper.findLines(itemHeaderId);
    }

    /**
     * 插入任务行设置行
     * @param list
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ItemLine> addLines(List<ItemLine> list) {
        List<ItemLine> itemLines=new ArrayList<ItemLine>();
        for(ItemLine itemLine:list){
            itemLinesMapper.addLines(itemLine);
            itemLine.setObjectVersionNumber(Long.valueOf(1));
            itemLines.add(itemLine);
        }
        return itemLines;
    }

    /**
     * 删除设置行
     * @param itemList
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteLines(List<ItemLine> itemList) {
        for(ItemLine line:itemList){
            itemLinesMapper.deleteLines(line);
        }
    }

    /**
     * 更新
     * @param itemLineList
     * @return
     */
    @Override
    public int updateLines(List<ItemLine> itemLineList) {
        int n=0;
        for(ItemLine line:itemLineList){
            n=itemLinesMapper.updateLines(line);
            if(n==0)
                return n;
        }
        return n;
    }
}
