package cn.tsing.www.module.trade.dal.mysql.config;

import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.module.trade.dal.dataobject.config.TradeConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易中心配置 Mapper
 *
 * @author owen
 */
@Mapper
public interface TradeConfigMapper extends BaseMapperX<TradeConfigDO> {

}
