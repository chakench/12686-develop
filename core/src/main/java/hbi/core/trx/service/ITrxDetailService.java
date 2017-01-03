package hbi.core.trx.service;

import hbi.core.trx.dto.TrxDetail;

import java.util.List;

/**
 * Created by chenhe on 2016/12/27.
 */
public interface ITrxDetailService {

    //查询事物层次结构
    List<TrxDetail> findTrxDetails(TrxDetail trxDetail);

    //新增 更新事物层次
    TrxDetail addTrxDetail(TrxDetail trxDetail);

    //拷贝树形层次结构
    TrxDetail copyTrxDetail(TrxDetail trxDetail,Long trxId);

    //删除树形层次结构
    void deleteTrxDetail(TrxDetail trxDetail);
}
