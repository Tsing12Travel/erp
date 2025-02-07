package cn.iocoder.yudao.module.erp.controller.admin.product;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

// ERP 产品 DO
@TableName("erp_product")
@KeySequence("erp_product_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpProductDO extends BaseDO {
    // 产品编号
    @TableId
    private Long id;
    // 产品名称
    private String name;
    // 产品条码
    private String barCode;
    // 产品分类编号。关联 {@link ErpProductCategoryDO#getId()}
    private Long categoryId;
    // 单位编号。关联 {@link ErpProductUnitDO#getId()}
    private Long unitId;
    // 产品状态。枚举 {@link cn.iocoder.yudao.framework.common.enums.CommonStatusEnum}
    private Integer status;
    // 产品规格
    private String standard;
    // 产品备注
    private String remark;
    // 保质天数
    private Integer expireDay;
    // 重量(kg)
    private BigDecimal weight;
    // 采购价格(元)
    private BigDecimal purchasePrice;
    // 销售价格(元)
    private BigDecimal salePrice;
    // 最低价格(元)
    private BigDecimal minPrice;
}
