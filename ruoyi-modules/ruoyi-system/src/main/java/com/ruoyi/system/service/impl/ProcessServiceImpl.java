package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProcessMapper;
import com.ruoyi.system.domain.Process;
import com.ruoyi.system.service.IProcessService;

/**
 * 工序基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@Service
public class ProcessServiceImpl implements IProcessService 
{
    @Autowired
    private ProcessMapper processMapper;

    /**
     * 查询工序基础信息
     * 
     * @param id 工序基础信息主键
     * @return 工序基础信息
     */
    @Override
    public Process selectProcessById(Long id)
    {
        return processMapper.selectProcessById(id);
    }

    /**
     * 查询工序基础信息列表
     * 
     * @param process 工序基础信息
     * @return 工序基础信息
     */
    @Override
    public List<Process> selectProcessList(Process process)
    {
        return processMapper.selectProcessList(process);
    }

    /**
     * 新增工序基础信息
     * 
     * @param process 工序基础信息
     * @return 结果
     */
    @Override
    public int insertProcess(Process process)
    {
        return processMapper.insertProcess(process);
    }

    /**
     * 修改工序基础信息
     * 
     * @param process 工序基础信息
     * @return 结果
     */
    @Override
    public int updateProcess(Process process)
    {
        return processMapper.updateProcess(process);
    }

    /**
     * 批量删除工序基础信息
     * 
     * @param ids 需要删除的工序基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProcessByIds(Long[] ids)
    {
        return processMapper.deleteProcessByIds(ids);
    }

    /**
     * 删除工序基础信息信息
     * 
     * @param id 工序基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProcessById(Long id)
    {
        return processMapper.deleteProcessById(id);
    }
}
