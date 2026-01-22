package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 原料管理整合-单全维度管理对象 material_manage
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public class MaterialManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 原料唯一编号(如MAT001，主键) */
    private Long materialId;

    /** 原料全称 */
    @Excel(name = "原料全称")
    private String materialName;

    /** 原料类别(主料/辅料/耗材/化工/包装等) */
    @Excel(name = "原料类别(主料/辅料/耗材/化工/包装等)")
    private String materialType;

    /** 规格/型号/纯度/等级(如25kg/袋、99.9%纯) */
    @Excel(name = "规格/型号/纯度/等级(如25kg/袋、99.9%纯)")
    private String specModel;

    /** 计量单位(kg/瓶/米/箱/卷等) */
    @Excel(name = "计量单位(kg/瓶/米/箱/卷等)")
    private String unit;

    /** 原料品牌 */
    @Excel(name = "原料品牌")
    private String brand;

    /** 当前实时库存数量 */
    @Excel(name = "当前实时库存数量")
    private BigDecimal stockQuantity;

    /** 安全库存下限(低于预警) */
    @Excel(name = "安全库存下限(低于预警)")
    private BigDecimal safeStock;

    /** 库存上限(高于防积压) */
    @Excel(name = "库存上限(高于防积压)")
    private BigDecimal maxStock;

    /** 库位/货架编号(如A1-02、冷藏库-5号) */
    @Excel(name = "库位/货架编号(如A1-02、冷藏库-5号)")
    private String stockLocation;

    /** 最新批次号(溯源核心) */
    @Excel(name = "最新批次号(溯源核心)")
    private String batchNo;

    /** 供应商全称 */
    @Excel(name = "供应商全称")
    private String supplierName;

    /** 供应商联系电话 */
    @Excel(name = "供应商联系电话")
    private String supplierPhone;

    /** 最新采购单价(含税) */
    @Excel(name = "最新采购单价(含税)")
    private BigDecimal purchasePrice;

    /** 税率(%)，默认13% */
    @Excel(name = "税率(%)，默认13%")
    private BigDecimal taxRate;

    /** 累计采购金额(成本统计) */
    @Excel(name = "累计采购金额(成本统计)")
    private BigDecimal totalPurchase;

    /** 原料生产日期(效期管理) */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "原料生产日期(效期管理)", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionDate;

    /** 过期/质保日期(临期预警) */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "过期/质保日期(临期预警)", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireDate;

    /** 质量状态(合格/待检/不合格/返工) */
    @Excel(name = "质量状态(合格/待检/不合格/返工)")
    private String qualityStatus;

    /** 检验结果/不合格原因 */
    @Excel(name = "检验结果/不合格原因")
    private String inspectResult;

    /** 特殊储存要求(冷藏0-4℃/避光/密封等) */
    @Excel(name = "特殊储存要求(冷藏0-4℃/避光/密封等)")
    private String storageRequire;

    /** 使用状态(在用/停用/淘汰/待采购) */
    @Excel(name = "使用状态(在用/停用/淘汰/待采购)")
    private String useStatus;

    /** 最近入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastInTime;

    /** 最近出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastOutTime;

    /** 记录创建人(账号/姓名) */
    @Excel(name = "记录创建人(账号/姓名)")
    private String creator;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }

    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }

    public void setSpecModel(String specModel) 
    {
        this.specModel = specModel;
    }

    public String getSpecModel() 
    {
        return specModel;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setStockQuantity(BigDecimal stockQuantity) 
    {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getStockQuantity() 
    {
        return stockQuantity;
    }

    public void setSafeStock(BigDecimal safeStock) 
    {
        this.safeStock = safeStock;
    }

    public BigDecimal getSafeStock() 
    {
        return safeStock;
    }

    public void setMaxStock(BigDecimal maxStock) 
    {
        this.maxStock = maxStock;
    }

    public BigDecimal getMaxStock() 
    {
        return maxStock;
    }

    public void setStockLocation(String stockLocation) 
    {
        this.stockLocation = stockLocation;
    }

    public String getStockLocation() 
    {
        return stockLocation;
    }

    public void setBatchNo(String batchNo) 
    {
        this.batchNo = batchNo;
    }

    public String getBatchNo() 
    {
        return batchNo;
    }

    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }

    public void setSupplierPhone(String supplierPhone) 
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone() 
    {
        return supplierPhone;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchasePrice() 
    {
        return purchasePrice;
    }

    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) 
    {
        this.totalPurchase = totalPurchase;
    }

    public BigDecimal getTotalPurchase() 
    {
        return totalPurchase;
    }

    public void setProductionDate(Date productionDate) 
    {
        this.productionDate = productionDate;
    }

    public Date getProductionDate() 
    {
        return productionDate;
    }

    public void setExpireDate(Date expireDate) 
    {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() 
    {
        return expireDate;
    }

    public void setQualityStatus(String qualityStatus) 
    {
        this.qualityStatus = qualityStatus;
    }

    public String getQualityStatus() 
    {
        return qualityStatus;
    }

    public void setInspectResult(String inspectResult) 
    {
        this.inspectResult = inspectResult;
    }

    public String getInspectResult() 
    {
        return inspectResult;
    }

    public void setStorageRequire(String storageRequire) 
    {
        this.storageRequire = storageRequire;
    }

    public String getStorageRequire() 
    {
        return storageRequire;
    }

    public void setUseStatus(String useStatus) 
    {
        this.useStatus = useStatus;
    }

    public String getUseStatus() 
    {
        return useStatus;
    }

    public void setLastInTime(Date lastInTime) 
    {
        this.lastInTime = lastInTime;
    }

    public Date getLastInTime() 
    {
        return lastInTime;
    }

    public void setLastOutTime(Date lastOutTime) 
    {
        this.lastOutTime = lastOutTime;
    }

    public Date getLastOutTime() 
    {
        return lastOutTime;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("specModel", getSpecModel())
            .append("unit", getUnit())
            .append("brand", getBrand())
            .append("stockQuantity", getStockQuantity())
            .append("safeStock", getSafeStock())
            .append("maxStock", getMaxStock())
            .append("stockLocation", getStockLocation())
            .append("batchNo", getBatchNo())
            .append("supplierName", getSupplierName())
            .append("supplierPhone", getSupplierPhone())
            .append("purchasePrice", getPurchasePrice())
            .append("taxRate", getTaxRate())
            .append("totalPurchase", getTotalPurchase())
            .append("productionDate", getProductionDate())
            .append("expireDate", getExpireDate())
            .append("qualityStatus", getQualityStatus())
            .append("inspectResult", getInspectResult())
            .append("storageRequire", getStorageRequire())
            .append("useStatus", getUseStatus())
            .append("lastInTime", getLastInTime())
            .append("lastOutTime", getLastOutTime())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
