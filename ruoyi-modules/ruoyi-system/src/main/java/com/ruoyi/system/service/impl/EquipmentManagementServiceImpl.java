package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquipmentManagementMapper;
import com.ruoyi.system.domain.EquipmentManagement;
import com.ruoyi.system.service.IEquipmentManagementService;

/**
 * 设备管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@Service
public class EquipmentManagementServiceImpl implements IEquipmentManagementService 
{
    @Autowired
    private EquipmentManagementMapper equipmentManagementMapper;

    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public EquipmentManagement selectEquipmentManagementById(Long id)
    {
        return equipmentManagementMapper.selectEquipmentManagementById(id);
    }

    /**
     * 查询设备管理列表
     * 
     * @param equipmentManagement 设备管理
     * @return 设备管理
     */
    @Override
    public List<EquipmentManagement> selectEquipmentManagementList(EquipmentManagement equipmentManagement)
    {
        return equipmentManagementMapper.selectEquipmentManagementList(equipmentManagement);
    }

    /**
     * 新增设备管理
     * 
     * @param equipmentManagement 设备管理
     * @return 结果
     */
    @Override
    public int insertEquipmentManagement(EquipmentManagement equipmentManagement)
    {
        equipmentManagement.setCreateTime(DateUtils.getNowDate());
        return equipmentManagementMapper.insertEquipmentManagement(equipmentManagement);
    }

    /**
     * 修改设备管理
     * 
     * @param equipmentManagement 设备管理
     * @return 结果
     */
    @Override
    public int updateEquipmentManagement(EquipmentManagement equipmentManagement)
    {
        equipmentManagement.setUpdateTime(DateUtils.getNowDate());
        return equipmentManagementMapper.updateEquipmentManagement(equipmentManagement);
    }

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManagementByIds(Long[] ids)
    {
        return equipmentManagementMapper.deleteEquipmentManagementByIds(ids);
    }

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentManagementById(Long id)
    {
        return equipmentManagementMapper.deleteEquipmentManagementById(id);
    }
}
