package cn.tsing.www.module.crm.dal.mysql.contract;


import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tsing.www.module.crm.dal.dataobject.contract.CrmContractProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 合同产品 Mapper
 *
 * @author HUIHUI
 */
@Mapper
public interface CrmContractProductMapper extends BaseMapperX<CrmContractProductDO> {

    default List<CrmContractProductDO> selectListByContractId(Long contractId) {
        return selectList(new LambdaQueryWrapperX<CrmContractProductDO>().eq(CrmContractProductDO::getContractId, contractId));
    }

}
