package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EquipmentMaintenance;

/**
 * 设备预维护管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public interface EquipmentMaintenanceMapper 
{
    /**
     * 查询设备预维护管理
     * 
     * @param id 设备预维护管理主键
     * @return 设备预维护管理
     */
    public EquipmentMaintenance selectEquipmentMaintenanceById(Long id);

    /**
     * 查询设备预维护管理列表
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 设备预维护管理集合
     */
    public List<EquipmentMaintenance> selectEquipmentMaintenanceList(EquipmentMaintenance equipmentMaintenance);

    /**
     * 新增设备预维护管理
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 结果
     */
    public int insertEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance);

    /**
     * 修改设备预维护管理
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 结果
     */
    public int updateEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance);

    /**
     * 删除设备预维护管理
     * 
     * @param id 设备预维护管理主键
     * @return 结果
     */
    public int deleteEquipmentMaintenanceById(Long id);

    /**
     * 批量删除设备预维护管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentMaintenanceByIds(Long[] ids);
}
