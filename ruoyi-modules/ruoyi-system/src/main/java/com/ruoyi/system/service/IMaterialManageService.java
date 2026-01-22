package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MaterialManage;

/**
 * 原料管理整合-单全维度管理Service接口
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public interface IMaterialManageService 
{
    /**
     * 查询原料管理整合-单全维度管理
     * 
     * @param materialId 原料管理整合-单全维度管理主键
     * @return 原料管理整合-单全维度管理
     */
    public MaterialManage selectMaterialManageByMaterialId(Long materialId);

    /**
     * 查询原料管理整合-单全维度管理列表
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 原料管理整合-单全维度管理集合
     */
    public List<MaterialManage> selectMaterialManageList(MaterialManage materialManage);

    /**
     * 新增原料管理整合-单全维度管理
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 结果
     */
    public int insertMaterialManage(MaterialManage materialManage);

    /**
     * 修改原料管理整合-单全维度管理
     * 
     * @param materialManage 原料管理整合-单全维度管理
     * @return 结果
     */
    public int updateMaterialManage(MaterialManage materialManage);

    /**
     * 批量删除原料管理整合-单全维度管理
     * 
     * @param materialIds 需要删除的原料管理整合-单全维度管理主键集合
     * @return 结果
     */
    public int deleteMaterialManageByMaterialIds(Long[] materialIds);

    /**
     * 删除原料管理整合-单全维度管理信息
     * 
     * @param materialId 原料管理整合-单全维度管理主键
     * @return 结果
     */
    public int deleteMaterialManageByMaterialId(Long materialId);
}
