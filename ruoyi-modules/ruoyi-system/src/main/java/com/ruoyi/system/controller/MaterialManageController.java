package com.ruoyi.system.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.MaterialManage;
import com.ruoyi.system.service.IMaterialManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 原料管理整合-单全维度管理Controller
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@RestController
@RequestMapping("/manage")
public class MaterialManageController extends BaseController
{
    @Autowired
    private IMaterialManageService materialManageService;

    /**
     * 查询原料管理整合-单全维度管理列表
     */
    @RequiresPermissions("system:manage:list")
    @GetMapping("/list")
    public TableDataInfo list(MaterialManage materialManage)
    {
        startPage();
        List<MaterialManage> list = materialManageService.selectMaterialManageList(materialManage);
        return getDataTable(list);
    }

    /**
     * 导出原料管理整合-单全维度管理列表
     */
    @RequiresPermissions("system:manage:export")
    @Log(title = "原料管理整合-单全维度管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaterialManage materialManage)
    {
        List<MaterialManage> list = materialManageService.selectMaterialManageList(materialManage);
        ExcelUtil<MaterialManage> util = new ExcelUtil<MaterialManage>(MaterialManage.class);
        util.exportExcel(response, list, "原料管理整合-单全维度管理数据");
    }

    /**
     * 获取原料管理整合-单全维度管理详细信息
     */
    @RequiresPermissions("system:manage:query")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId)
    {
        return success(materialManageService.selectMaterialManageByMaterialId(materialId));
    }

    /**
     * 新增原料管理整合-单全维度管理
     */
    @RequiresPermissions("system:manage:add")
    @Log(title = "原料管理整合-单全维度管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaterialManage materialManage)
    {
        return toAjax(materialManageService.insertMaterialManage(materialManage));
    }

    /**
     * 修改原料管理整合-单全维度管理
     */
    @RequiresPermissions("system:manage:edit")
    @Log(title = "原料管理整合-单全维度管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaterialManage materialManage)
    {
        return toAjax(materialManageService.updateMaterialManage(materialManage));
    }

    /**
     * 删除原料管理整合-单全维度管理
     */
    @RequiresPermissions("system:manage:remove")
    @Log(title = "原料管理整合-单全维度管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialIds}")
    public AjaxResult remove(@PathVariable Long[] materialIds)
    {
        return toAjax(materialManageService.deleteMaterialManageByMaterialIds(materialIds));
    }
}
