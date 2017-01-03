package hbi.core.trx.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.trx.dto.TrxType;

import java.util.List;

/**
 * Created by chenhe on 2016/12/26.
 */
public interface ITrxTypeService extends IBaseService<TrxType>,ProxySelf<ITrxTypeService>{
    //查询所有的事物
    List<TrxType> findAll(TrxType trxType,int page,int pageSize);
    //删除事物
    int deleteTrxType(List<TrxType> list);
    //新增事物
    List<TrxType> addTrxType(List<TrxType> list);

    //更新
    List<TrxType> updateTrxType(List<TrxType> list);

    //新增版本 拷贝数据
    TrxType addVersion(TrxType trxType);
}
