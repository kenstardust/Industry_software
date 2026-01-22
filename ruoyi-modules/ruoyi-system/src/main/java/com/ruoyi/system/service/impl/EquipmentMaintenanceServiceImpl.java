package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquipmentMaintenanceMapper;
import com.ruoyi.system.domain.EquipmentMaintenance;
import com.ruoyi.system.service.IEquipmentMaintenanceService;

/**
 * 设备预维护管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@Service
public class EquipmentMaintenanceServiceImpl implements IEquipmentMaintenanceService 
{
    @Autowired
    private EquipmentMaintenanceMapper equipmentMaintenanceMapper;

    /**
     * 查询设备预维护管理
     * 
     * @param id 设备预维护管理主键
     * @return 设备预维护管理
     */
    @Override
    public EquipmentMaintenance selectEquipmentMaintenanceById(Long id)
    {
        return equipmentMaintenanceMapper.selectEquipmentMaintenanceById(id);
    }

    /**
     * 查询设备预维护管理列表
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 设备预维护管理
     */
    @Override
    public List<EquipmentMaintenance> selectEquipmentMaintenanceList(EquipmentMaintenance equipmentMaintenance)
    {
        return equipmentMaintenanceMapper.selectEquipmentMaintenanceList(equipmentMaintenance);
    }

    /**
     * 新增设备预维护管理
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 结果
     */
    @Override
    public int insertEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance)
    {
        equipmentMaintenance.setCreateTime(DateUtils.getNowDate());
        return equipmentMaintenanceMapper.insertEquipmentMaintenance(equipmentMaintenance);
    }

    /**
     * 修改设备预维护管理
     * 
     * @param equipmentMaintenance 设备预维护管理
     * @return 结果
     */
    @Override
    public int updateEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance)
    {
        equipmentMaintenance.setUpdateTime(DateUtils.getNowDate());
        return equipmentMaintenanceMapper.updateEquipmentMaintenance(equipmentMaintenance);
    }

    /**
     * 批量删除设备预维护管理
     * 
     * @param ids 需要删除的设备预维护管理主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintenanceByIds(Long[] ids)
    {
        return equipmentMaintenanceMapper.deleteEquipmentMaintenanceByIds(ids);
    }

    /**
     * 删除设备预维护管理信息
     * 
     * @param id 设备预维护管理主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintenanceById(Long id)
    {
        return equipmentMaintenanceMapper.deleteEquipmentMaintenanceById(id);
    }
}
