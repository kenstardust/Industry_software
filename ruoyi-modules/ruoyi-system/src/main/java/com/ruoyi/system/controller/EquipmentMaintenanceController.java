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
import com.ruoyi.system.domain.EquipmentMaintenance;
import com.ruoyi.system.service.IEquipmentMaintenanceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 设备预维护管理Controller
 * 
 * @author ruoyi
 * @date 2026-01-22
 */
@RestController
@RequestMapping("/maintenance")
public class EquipmentMaintenanceController extends BaseController
{
    @Autowired
    private IEquipmentMaintenanceService equipmentMaintenanceService;

    /**
     * 查询设备预维护管理列表
     */
    @RequiresPermissions("system:maintenance:list")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentMaintenance equipmentMaintenance)
    {
        startPage();
        List<EquipmentMaintenance> list = equipmentMaintenanceService.selectEquipmentMaintenanceList(equipmentMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出设备预维护管理列表
     */
    @RequiresPermissions("system:maintenance:export")
    @Log(title = "设备预维护管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentMaintenance equipmentMaintenance)
    {
        List<EquipmentMaintenance> list = equipmentMaintenanceService.selectEquipmentMaintenanceList(equipmentMaintenance);
        ExcelUtil<EquipmentMaintenance> util = new ExcelUtil<EquipmentMaintenance>(EquipmentMaintenance.class);
        util.exportExcel(response, list, "设备预维护管理数据");
    }

    /**
     * 获取设备预维护管理详细信息
     */
    @RequiresPermissions("system:maintenance:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentMaintenanceService.selectEquipmentMaintenanceById(id));
    }

    /**
     * 新增设备预维护管理
     */
    @RequiresPermissions("system:maintenance:add")
    @Log(title = "设备预维护管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentMaintenance equipmentMaintenance)
    {
        return toAjax(equipmentMaintenanceService.insertEquipmentMaintenance(equipmentMaintenance));
    }

    /**
     * 修改设备预维护管理
     */
    @RequiresPermissions("system:maintenance:edit")
    @Log(title = "设备预维护管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentMaintenance equipmentMaintenance)
    {
        return toAjax(equipmentMaintenanceService.updateEquipmentMaintenance(equipmentMaintenance));
    }

    /**
     * 删除设备预维护管理
     */
    @RequiresPermissions("system:maintenance:remove")
    @Log(title = "设备预维护管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentMaintenanceService.deleteEquipmentMaintenanceByIds(ids));
    }
}
