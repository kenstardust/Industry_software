package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CodeManagementMapper;
import com.ruoyi.system.domain.CodeManagement;
import com.ruoyi.system.service.ICodeManagementService;

/**
 * 编码管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@Service
public class CodeManagementServiceImpl implements ICodeManagementService 
{
    @Autowired
    private CodeManagementMapper codeManagementMapper;

    /**
     * 查询编码管理
     * 
     * @param id 编码管理主键
     * @return 编码管理
     */
    @Override
    public CodeManagement selectCodeManagementById(Long id)
    {
        return codeManagementMapper.selectCodeManagementById(id);
    }

    /**
     * 查询编码管理列表
     * 
     * @param codeManagement 编码管理
     * @return 编码管理
     */
    @Override
    public List<CodeManagement> selectCodeManagementList(CodeManagement codeManagement)
    {
        return codeManagementMapper.selectCodeManagementList(codeManagement);
    }

    /**
     * 新增编码管理
     * 
     * @param codeManagement 编码管理
     * @return 结果
     */
    @Override
    public int insertCodeManagement(CodeManagement codeManagement)
    {
        codeManagement.setCreateTime(DateUtils.getNowDate());
        return codeManagementMapper.insertCodeManagement(codeManagement);
    }

    /**
     * 修改编码管理
     * 
     * @param codeManagement 编码管理
     * @return 结果
     */
    @Override
    public int updateCodeManagement(CodeManagement codeManagement)
    {
        codeManagement.setUpdateTime(DateUtils.getNowDate());
        return codeManagementMapper.updateCodeManagement(codeManagement);
    }

    /**
     * 批量删除编码管理
     * 
     * @param ids 需要删除的编码管理主键
     * @return 结果
     */
    @Override
    public int deleteCodeManagementByIds(Long[] ids)
    {
        return codeManagementMapper.deleteCodeManagementByIds(ids);
    }

    /**
     * 删除编码管理信息
     * 
     * @param id 编码管理主键
     * @return 结果
     */
    @Override
    public int deleteCodeManagementById(Long id)
    {
        return codeManagementMapper.deleteCodeManagementById(id);
    }
}
