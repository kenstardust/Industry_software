package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Process;

/**
 * 工序基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
public interface ProcessMapper 
{
    /**
     * 查询工序基础信息
     * 
     * @param id 工序基础信息主键
     * @return 工序基础信息
     */
    public Process selectProcessById(Long id);

    /**
     * 查询工序基础信息列表
     * 
     * @param process 工序基础信息
     * @return 工序基础信息集合
     */
    public List<Process> selectProcessList(Process process);

    /**
     * 新增工序基础信息
     * 
     * @param process 工序基础信息
     * @return 结果
     */
    public int insertProcess(Process process);

    /**
     * 修改工序基础信息
     * 
     * @param process 工序基础信息
     * @return 结果
     */
    public int updateProcess(Process process);

    /**
     * 删除工序基础信息
     * 
     * @param id 工序基础信息主键
     * @return 结果
     */
    public int deleteProcessById(Long id);

    /**
     * 批量删除工序基础信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProcessByIds(Long[] ids);
}
