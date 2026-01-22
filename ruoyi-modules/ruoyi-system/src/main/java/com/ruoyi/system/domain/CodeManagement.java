package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 编码管理对象 code_management
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public class CodeManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 唯一编码（二维码内容） */
    @Excel(name = "唯一编码", readConverterExp = "二=维码内容")
    private String uniqueCode;

    /** 编码类型：1-设备 2-文档 3-人员 */
    @Excel(name = "编码类型：1-设备 2-文档 3-人员")
    private Long codeType;

    /** 关联业务主键ID（如设备ID/人员ID/文档ID） */
    @Excel(name = "关联业务主键ID", readConverterExp = "如=设备ID/人员ID/文档ID")
    private Long businessId;

    /** 关联业务名称（如设备名称/人员姓名/文档名称） */
    @Excel(name = "关联业务名称", readConverterExp = "如=设备名称/人员姓名/文档名称")
    private String businessName;

    /** 二维码生成后的存储地址（如服务器路径/OSS链接） */
    @Excel(name = "二维码生成后的存储地址", readConverterExp = "如=服务器路径/OSS链接")
    private String qrCodeUrl;

    /** 编码生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编码生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date generateTime;

    /** 编码创建人 */
    @Excel(name = "编码创建人")
    private String creator;

    /** 编码状态：1-有效 2-作废 3-过期 */
    @Excel(name = "编码状态：1-有效 2-作废 3-过期")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUniqueCode(String uniqueCode) 
    {
        this.uniqueCode = uniqueCode;
    }

    public String getUniqueCode() 
    {
        return uniqueCode;
    }

    public void setCodeType(Long codeType) 
    {
        this.codeType = codeType;
    }

    public Long getCodeType() 
    {
        return codeType;
    }

    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }

    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }

    public void setQrCodeUrl(String qrCodeUrl) 
    {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getQrCodeUrl() 
    {
        return qrCodeUrl;
    }

    public void setGenerateTime(Date generateTime) 
    {
        this.generateTime = generateTime;
    }

    public Date getGenerateTime() 
    {
        return generateTime;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uniqueCode", getUniqueCode())
            .append("codeType", getCodeType())
            .append("businessId", getBusinessId())
            .append("businessName", getBusinessName())
            .append("qrCodeUrl", getQrCodeUrl())
            .append("generateTime", getGenerateTime())
            .append("creator", getCreator())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
