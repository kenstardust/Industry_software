package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.Process;
import com.ruoyi.system.service.IProcessService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 工序基础信息Controller
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@RestController
@RequestMapping("/process")
public class ProcessController extends BaseController
{
    @Autowired
    private IProcessService processService;

    /**
     * 查询工序基础信息列表
     */
    @RequiresPermissions("system:process:list")
    @GetMapping("/list")
    public TableDataInfo list(Process process)
    {
        startPage();
        List<Process> list = processService.selectProcessList(process);
        return getDataTable(list);
    }

    /**
     * 导出工序基础信息列表
     */
    @RequiresPermissions("system:process:export")
    @Log(title = "工序基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Process process)
    {
        List<Process> list = processService.selectProcessList(process);
        ExcelUtil<Process> util = new ExcelUtil<Process>(Process.class);
        util.exportExcel(response, list, "工序基础信息数据");
    }

    /**
     * 获取工序基础信息详细信息
     */
    @RequiresPermissions("system:process:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processService.selectProcessById(id));
    }

    /**
     * 新增工序基础信息
     */
    @RequiresPermissions("system:process:add")
    @Log(title = "工序基础信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Process process)
    {
        return toAjax(processService.insertProcess(process));
    }

    /**
     * 修改工序基础信息
     */
    @RequiresPermissions("system:process:edit")
    @Log(title = "工序基础信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Process process)
    {
        return toAjax(processService.updateProcess(process));
    }

    /**
     * 删除工序基础信息
     */
    @RequiresPermissions("system:process:remove")
    @Log(title = "工序基础信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processService.deleteProcessByIds(ids));
    }
}
