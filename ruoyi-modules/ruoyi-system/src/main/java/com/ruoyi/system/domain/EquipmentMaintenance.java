package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 设备预维护管理对象 equipment_maintenance
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public class EquipmentMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联设备ID */
    @Excel(name = "关联设备ID")
    private Long equipmentId;

    /** 维护类型：ROUTINE(日常)、PERIODIC(定期)、PREVENTIVE(预防性) */
    @Excel(name = "维护类型：ROUTINE(日常)、PERIODIC(定期)、PREVENTIVE(预防性)")
    private String maintenanceType;

    /** 计划维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划维护日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenancePlanDate;

    /** 实际维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际维护日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceActualDate;

    /** 维护内容（如：润滑、校准、零件更换） */
    @Excel(name = "维护内容", readConverterExp = "如=：润滑、校准、零件更换")
    private String maintenanceContent;

    /** 维护人员 */
    @Excel(name = "维护人员")
    private String maintenancePerson;

    /** 维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败) */
    @Excel(name = "维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)")
    private String maintenanceResult;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updateUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public void setMaintenanceType(String maintenanceType) 
    {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceType() 
    {
        return maintenanceType;
    }

    public void setMaintenancePlanDate(Date maintenancePlanDate) 
    {
        this.maintenancePlanDate = maintenancePlanDate;
    }

    public Date getMaintenancePlanDate() 
    {
        return maintenancePlanDate;
    }

    public void setMaintenanceActualDate(Date maintenanceActualDate) 
    {
        this.maintenanceActualDate = maintenanceActualDate;
    }

    public Date getMaintenanceActualDate() 
    {
        return maintenanceActualDate;
    }

    public void setMaintenanceContent(String maintenanceContent) 
    {
        this.maintenanceContent = maintenanceContent;
    }

    public String getMaintenanceContent() 
    {
        return maintenanceContent;
    }

    public void setMaintenancePerson(String maintenancePerson) 
    {
        this.maintenancePerson = maintenancePerson;
    }

    public String getMaintenancePerson() 
    {
        return maintenancePerson;
    }

    public void setMaintenanceResult(String maintenanceResult) 
    {
        this.maintenanceResult = maintenanceResult;
    }

    public String getMaintenanceResult() 
    {
        return maintenanceResult;
    }

    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentId", getEquipmentId())
            .append("maintenanceType", getMaintenanceType())
            .append("maintenancePlanDate", getMaintenancePlanDate())
            .append("maintenanceActualDate", getMaintenanceActualDate())
            .append("maintenanceContent", getMaintenanceContent())
            .append("maintenancePerson", getMaintenancePerson())
            .append("maintenanceResult", getMaintenanceResult())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
