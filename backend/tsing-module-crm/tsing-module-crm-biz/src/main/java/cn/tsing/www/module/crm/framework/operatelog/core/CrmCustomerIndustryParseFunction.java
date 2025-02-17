package cn.tsing.www.module.crm.framework.operatelog.core;

import cn.hutool.core.util.StrUtil;
import cn.tsing.www.framework.dict.core.DictFrameworkUtils;
import com.mzt.logapi.service.IParseFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static cn.tsing.www.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_INDUSTRY;

/**
 * 行业的 {@link IParseFunction} 实现类
 *
 * @author HUIHUI
 */
@Component
@Slf4j
public class CrmCustomerIndustryParseFunction implements IParseFunction {

    public static final String NAME = "getCustomerIndustry";

    @Override
    public boolean executeBefore() {
        return true; // 先转换值后对比
    }

    @Override
    public String functionName() {
        return NAME;
    }

    @Override
    public String apply(Object value) {
        if (StrUtil.isEmptyIfStr(value)) {
            return "";
        }
        return DictFrameworkUtils.getDictDataLabel(CRM_CUSTOMER_INDUSTRY, value.toString());
    }

}
