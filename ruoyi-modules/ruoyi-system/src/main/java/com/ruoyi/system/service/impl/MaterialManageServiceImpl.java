package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MaterialManageMapper;
import com.ruoyi.system.domain.MaterialManage;
import com.ruoyi.system.service.IMaterialManageService;

/**
 * 原料管理整合-单全维度管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@Service
public class MaterialManageServiceImpl implements IMaterialManageService 
{
    @Autowired
    private MaterialManageMapper materialManageMapper;

    /**
     * 查询原料管理整合-单全维度管理
     * 
     * @param materialId 原料管理整合-单全维度管理主键
     * @return 原料管理整合-单全维度管理
     */
    @Override
    public MaterialManage selectMaterialManageByMaterialId(Long materialId)
    {
        return materialManageMapper.selectMaterialManageByMaterialId(materialId);
    }

    /**
     * 查询原料管理整合-单全维度管理列表
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 原料管理整合-单全维度管理
     */
    @Override
    public List<MaterialManage> selectMaterialManageList(MaterialManage materialManage)
    {
        return materialManageMapper.selectMaterialManageList(materialManage);
    }

    /**
     * 新增原料管理整合-单全维度管理
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 结果
     */
    @Override
    public int insertMaterialManage(MaterialManage materialManage)
    {
        materialManage.setCreateTime(DateUtils.getNowDate());
        return materialManageMapper.insertMaterialManage(materialManage);
    }

    /**
     * 修改原料管理整合-单全维度管理
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 结果
     */
    @Override
    public int updateMaterialManage(MaterialManage materialManage)
    {
        materialManage.setUpdateTime(DateUtils.getNowDate());
        return materialManageMapper.updateMaterialManage(materialManage);
    }

    /**
     * 批量删除原料管理整合-单全维度管理
     * 
     * @param materialIds 需要删除的原料管理整合-单全维度管理主键
     * @return 结果
     */
    @Override
    public int deleteMaterialManageByMaterialIds(Long[] materialIds)
    {
        return materialManageMapper.deleteMaterialManageByMaterialIds(materialIds);
    }

    /**
     * 删除原料管理整合-单全维度管理信息
     * 
     * @param materialId 原料管理整合-单全维度管理主键
     * @return 结果
     */
    @Override
    public int deleteMaterialManageByMaterialId(Long materialId)
    {
        return materialManageMapper.deleteMaterialManageByMaterialId(materialId);
    }
}
