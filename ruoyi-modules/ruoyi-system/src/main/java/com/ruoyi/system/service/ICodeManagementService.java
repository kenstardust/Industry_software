package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CodeManagement;

/**
 * 编码管理Service接口
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public interface ICodeManagementService 
{
    /**
     * 查询编码管理
     * 
     * @param id 编码管理主键
     * @return 编码管理
     */
    public CodeManagement selectCodeManagementById(Long id);

    /**
     * 查询编码管理列表
     * 
     * @param codeManagement 编码管理
     * @return 编码管理集合
     */
    public List<CodeManagement> selectCodeManagementList(CodeManagement codeManagement);

    /**
     * 新增编码管理
     * 
     * @param codeManagement 编码管理
     * @return 结果
     */
    public int insertCodeManagement(CodeManagement codeManagement);

    /**
     * 修改编码管理
     * 
     * @param codeManagement 编码管理
     * @return 结果
     */
    public int updateCodeManagement(CodeManagement codeManagement);

    /**
     * 批量删除编码管理
     * 
     * @param ids 需要删除的编码管理主键集合
     * @return 结果
     */
    public int deleteCodeManagementByIds(Long[] ids);

    /**
     * 删除编码管理信息
     * 
     * @param id 编码管理主键
     * @return 结果
     */
    public int deleteCodeManagementById(Long id);
}
