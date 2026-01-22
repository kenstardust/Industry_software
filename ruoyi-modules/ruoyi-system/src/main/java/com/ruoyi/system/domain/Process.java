package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 工序基础信息对象 process
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public class Process extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 工序编码（唯一） */
    @Excel(name = "工序编码", readConverterExp = "唯=一")
    private String processCode;

    /** 工序名称 */
    @Excel(name = "工序名称")
    private String processName;

    /** 工序类型： */
    @Excel(name = "工序类型：")
    private Long processType;

    /** 工序描述 */
    @Excel(name = "工序描述")
    private String processDesc;

    /** 标准工时（分钟） */
    @Excel(name = "标准工时", readConverterExp = "分=钟")
    private BigDecimal standardDuration;

    /** 是否启用：1-启用，0-禁用 */
    @Excel(name = "是否启用：1-启用，0-禁用")
    private Long isActive;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProcessCode(String processCode) 
    {
        this.processCode = processCode;
    }

    public String getProcessCode() 
    {
        return processCode;
    }

    public void setProcessName(String processName) 
    {
        this.processName = processName;
    }

    public String getProcessName() 
    {
        return processName;
    }

    public void setProcessType(Long processType) 
    {
        this.processType = processType;
    }

    public Long getProcessType() 
    {
        return processType;
    }

    public void setProcessDesc(String processDesc) 
    {
        this.processDesc = processDesc;
    }

    public String getProcessDesc() 
    {
        return processDesc;
    }

    public void setStandardDuration(BigDecimal standardDuration) 
    {
        this.standardDuration = standardDuration;
    }

    public BigDecimal getStandardDuration() 
    {
        return standardDuration;
    }

    public void setIsActive(Long isActive) 
    {
        this.isActive = isActive;
    }

    public Long getIsActive() 
    {
        return isActive;
    }

    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }

    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }

    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("processCode", getProcessCode())
            .append("processName", getProcessName())
            .append("processType", getProcessType())
            .append("processDesc", getProcessDesc())
            .append("standardDuration", getStandardDuration())
            .append("isActive", getIsActive())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
