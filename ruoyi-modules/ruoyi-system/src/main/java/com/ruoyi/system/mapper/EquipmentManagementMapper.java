package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EquipmentManagement;

/**
 * 设备管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public interface EquipmentManagementMapper 
{
    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    public EquipmentManagement selectEquipmentManagementById(Long id);

    /**
     * 查询设备管理列表
     * 
     * @param equipmentManagement 设备管理
     * @return 设备管理集合
     */
    public List<EquipmentManagement> selectEquipmentManagementList(EquipmentManagement equipmentManagement);

    /**
     * 新增设备管理
     * 
     * @param equipmentManagement 设备管理
     * @return 结果
     */
    public int insertEquipmentManagement(EquipmentManagement equipmentManagement);

    /**
     * 修改设备管理
     * 
     * @param equipmentManagement 设备管理
     * @return 结果
     */
    public int updateEquipmentManagement(EquipmentManagement equipmentManagement);

    /**
     * 删除设备管理
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    public int deleteEquipmentManagementById(Long id);

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentManagementByIds(Long[] ids);
}
