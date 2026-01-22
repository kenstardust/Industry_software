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
import com.ruoyi.system.domain.CodeManagement;
import com.ruoyi.system.service.ICodeManagementService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 编码管理Controller
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@RestController
@RequestMapping("/codeManagement")
public class CodeManagementController extends BaseController
{
    @Autowired
    private ICodeManagementService codeManagementService;

    /**
     * 查询编码管理列表
     */
    @RequiresPermissions("system:management:list")
    @GetMapping("/list")
    public TableDataInfo list(CodeManagement codeManagement)
    {
        startPage();
        List<CodeManagement> list = codeManagementService.selectCodeManagementList(codeManagement);
        return getDataTable(list);
    }

    /**
     * 导出编码管理列表
     */
    @RequiresPermissions("system:management:export")
    @Log(title = "编码管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CodeManagement codeManagement)
    {
        List<CodeManagement> list = codeManagementService.selectCodeManagementList(codeManagement);
        ExcelUtil<CodeManagement> util = new ExcelUtil<CodeManagement>(CodeManagement.class);
        util.exportExcel(response, list, "编码管理数据");
    }

    /**
     * 获取编码管理详细信息
     */
    @RequiresPermissions("system:management:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(codeManagementService.selectCodeManagementById(id));
    }

    /**
     * 新增编码管理
     */
    @RequiresPermissions("system:management:add")
    @Log(title = "编码管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CodeManagement codeManagement)
    {
        return toAjax(codeManagementService.insertCodeManagement(codeManagement));
    }

    /**
     * 修改编码管理
     */
    @RequiresPermissions("system:management:edit")
    @Log(title = "编码管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CodeManagement codeManagement)
    {
        return toAjax(codeManagementService.updateCodeManagement(codeManagement));
    }

    /**
     * 删除编码管理
     */
    @RequiresPermissions("system:management:remove")
    @Log(title = "编码管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(codeManagementService.deleteCodeManagementByIds(ids));
    }
}
