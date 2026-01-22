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
import com.ruoyi.system.domain.EquipmentManagement;
import com.ruoyi.system.service.IEquipmentManagementService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 设备管理Controller
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@RestController
@RequestMapping("/management")
public class EquipmentManagementController extends BaseController
{
    @Autowired
    private IEquipmentManagementService equipmentManagementService;

    /**
     * 查询设备管理列表
     */
    @RequiresPermissions("system:management:list")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentManagement equipmentManagement)
    {
        startPage();
        List<EquipmentManagement> list = equipmentManagementService.selectEquipmentManagementList(equipmentManagement);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @RequiresPermissions("system:management:export")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentManagement equipmentManagement)
    {
        List<EquipmentManagement> list = equipmentManagementService.selectEquipmentManagementList(equipmentManagement);
        ExcelUtil<EquipmentManagement> util = new ExcelUtil<EquipmentManagement>(EquipmentManagement.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @RequiresPermissions("system:management:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentManagementService.selectEquipmentManagementById(id));
    }

    /**
     * 新增设备管理
     */
    @RequiresPermissions("system:management:add")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentManagement equipmentManagement)
    {
        return toAjax(equipmentManagementService.insertEquipmentManagement(equipmentManagement));
    }

    /**
     * 修改设备管理
     */
    @RequiresPermissions("system:management:edit")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentManagement equipmentManagement)
    {
        return toAjax(equipmentManagementService.updateEquipmentManagement(equipmentManagement));
    }

    /**
     * 删除设备管理
     */
    @RequiresPermissions("system:management:remove")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentManagementService.deleteEquipmentManagementByIds(ids));
    }
}
