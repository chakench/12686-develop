package hbi.core.trx.mapper;

import hbi.core.trx.dto.TrxDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenhe on 2016/12/27.
 */
@Repository("trxDetailMapper")
public interface TrxDetailMapper {
    //查询事物层次结构
    List<TrxDetail> findTrxDetails(TrxDetail trxDetail);
    //新增事物层次
    int addTrxDetail(TrxDetail trxDetail);
    //删除
    int deleteTrxDetail(TrxDetail trxDetail);
    //判断标识或名字是否存在
    int isExist(TrxDetail trxDetail);
    //更新
    void updateTrxDetail(TrxDetail trxDetail);
    //查询根节点
    TrxDetail findOneTrxDetail(Long trxId);
}
