package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 设备管理对象 equipment_management
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public class EquipmentManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 设备唯一编码（二维码对应的编码） */
    @Excel(name = "设备唯一编码", readConverterExp = "二=维码对应的编码")
    private String equipmentCode;

    /** 设备名称（机床/检测设备/AGV/服务器） */
    @Excel(name = "设备名称", readConverterExp = "机=床/检测设备/AGV/服务器")
    private String equipmentName;

    /** 设备类型：1-机床 2-检测设备 3-AGV 4-服务器 */
    @Excel(name = "设备类型：1-机床 2-检测设备 3-AGV 4-服务器")
    private Long equipmentType;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String model;

    /** 设备品牌 */
    @Excel(name = "设备品牌")
    private String brand;

    /** 安装位置（车间/工位） */
    @Excel(name = "安装位置", readConverterExp = "车=间/工位")
    private String installLocation;

    /** 设备责任人 */
    @Excel(name = "设备责任人")
    private String responsiblePerson;

    /** 设备状态：1-正常 2-待维护 3-故障 4-停用 5-报废 */
    @Excel(name = "设备状态：1-正常 2-待维护 3-故障 4-停用 5-报废")
    private Long status;

    /** 维护类型（日常保养/定期检修/精度校准等） */
    @Excel(name = "维护类型", readConverterExp = "日=常保养/定期检修/精度校准等")
    private String maintenanceType;

    /** 维护周期类型：1-按天 2-按周 3-按月 4-按季度 5-按年 */
    @Excel(name = "维护周期类型：1-按天 2-按周 3-按月 4-按季度 5-按年")
    private Long cycleType;

    /** 维护周期值（如按月维护则值为1） */
    @Excel(name = "维护周期值", readConverterExp = "如=按月维护则值为1")
    private Long cycleValue;

    /** 下次预维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次预维护日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    /** 最近一次维护执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次维护执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastMaintenanceDate;

    /** 最近一次维护人员 */
    @Excel(name = "最近一次维护人员")
    private String lastMaintenancePerson;

    /** 最近一次维护结果 */
    @Excel(name = "最近一次维护结果")
    private String lastMaintenanceResult;

    /** 二维码存储地址/内容 */
    @Excel(name = "二维码存储地址/内容")
    private String qrCodeUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setEquipmentCode(String equipmentCode) 
    {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() 
    {
        return equipmentCode;
    }

    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }

    public void setEquipmentType(Long equipmentType) 
    {
        this.equipmentType = equipmentType;
    }

    public Long getEquipmentType() 
    {
        return equipmentType;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setInstallLocation(String installLocation) 
    {
        this.installLocation = installLocation;
    }

    public String getInstallLocation() 
    {
        return installLocation;
    }

    public void setResponsiblePerson(String responsiblePerson) 
    {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() 
    {
        return responsiblePerson;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setMaintenanceType(String maintenanceType) 
    {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceType() 
    {
        return maintenanceType;
    }

    public void setCycleType(Long cycleType) 
    {
        this.cycleType = cycleType;
    }

    public Long getCycleType() 
    {
        return cycleType;
    }

    public void setCycleValue(Long cycleValue) 
    {
        this.cycleValue = cycleValue;
    }

    public Long getCycleValue() 
    {
        return cycleValue;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) 
    {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public Date getNextMaintenanceDate() 
    {
        return nextMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) 
    {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getLastMaintenanceDate() 
    {
        return lastMaintenanceDate;
    }

    public void setLastMaintenancePerson(String lastMaintenancePerson) 
    {
        this.lastMaintenancePerson = lastMaintenancePerson;
    }

    public String getLastMaintenancePerson() 
    {
        return lastMaintenancePerson;
    }

    public void setLastMaintenanceResult(String lastMaintenanceResult) 
    {
        this.lastMaintenanceResult = lastMaintenanceResult;
    }

    public String getLastMaintenanceResult() 
    {
        return lastMaintenanceResult;
    }

    public void setQrCodeUrl(String qrCodeUrl) 
    {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getQrCodeUrl() 
    {
        return qrCodeUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentCode", getEquipmentCode())
            .append("equipmentName", getEquipmentName())
            .append("equipmentType", getEquipmentType())
            .append("model", getModel())
            .append("brand", getBrand())
            .append("installLocation", getInstallLocation())
            .append("responsiblePerson", getResponsiblePerson())
            .append("status", getStatus())
            .append("maintenanceType", getMaintenanceType())
            .append("cycleType", getCycleType())
            .append("cycleValue", getCycleValue())
            .append("nextMaintenanceDate", getNextMaintenanceDate())
            .append("lastMaintenanceDate", getLastMaintenanceDate())
            .append("lastMaintenancePerson", getLastMaintenancePerson())
            .append("lastMaintenanceResult", getLastMaintenanceResult())
            .append("qrCodeUrl", getQrCodeUrl())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
