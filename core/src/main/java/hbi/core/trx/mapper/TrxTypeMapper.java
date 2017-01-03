package hbi.core.trx.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.trx.dto.TrxType;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenhe on 2016/12/26.
 */
@Repository("trxTypeMapper")
public interface TrxTypeMapper extends Mapper<TrxType>{
    //查询所有事物
    List<TrxType> findAll(TrxType trxType);
    //删除
    int deleteTrxType(TrxType trxType);
    //新增
    int addTrxType(TrxType trxType);
    //判断标识，名字与版本号是否存在
    int isExist(TrxType trxType);
    //更新
    int updateTrxType(TrxType trxType);
    //统计不同版本的同种事务类型的有效状态数
    int countOfActive(TrxType trxType);
    //新增版本 拷贝数据
    int addVersion(TrxType trxType);
}
