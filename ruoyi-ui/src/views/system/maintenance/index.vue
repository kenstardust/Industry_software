<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联设备ID" prop="equipmentId">
        <el-input
          v-model="queryParams.equipmentId"
          placeholder="请输入关联设备ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划维护日期" prop="maintenancePlanDate">
        <el-date-picker clearable
          v-model="queryParams.maintenancePlanDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择计划维护日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际维护日期" prop="maintenanceActualDate">
        <el-date-picker clearable
          v-model="queryParams.maintenanceActualDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实际维护日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="维护人员" prop="maintenancePerson">
        <el-input
          v-model="queryParams.maintenancePerson"
          placeholder="请输入维护人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)" prop="maintenanceResult">
        <el-input
          v-model="queryParams.maintenanceResult"
          placeholder="请输入维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人" prop="createUser">
        <el-input
          v-model="queryParams.createUser"
          placeholder="请输入创建人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更新人" prop="updateUser">
        <el-input
          v-model="queryParams.updateUser"
          placeholder="请输入更新人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:maintenance:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:maintenance:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:maintenance:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:maintenance:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="maintenanceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="关联设备ID" align="center" prop="equipmentId" />
      <el-table-column label="维护类型：ROUTINE(日常)、PERIODIC(定期)、PREVENTIVE(预防性)" align="center" prop="maintenanceType" />
      <el-table-column label="计划维护日期" align="center" prop="maintenancePlanDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.maintenancePlanDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际维护日期" align="center" prop="maintenanceActualDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.maintenanceActualDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="维护内容" align="center" prop="maintenanceContent" />
      <el-table-column label="维护人员" align="center" prop="maintenancePerson" />
      <el-table-column label="维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)" align="center" prop="maintenanceResult" />
      <el-table-column label="维护备注" align="center" prop="remark" />
      <el-table-column label="创建人" align="center" prop="createUser" />
      <el-table-column label="更新人" align="center" prop="updateUser" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:maintenance:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:maintenance:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改设备预维护管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联设备ID" prop="equipmentId">
          <el-input v-model="form.equipmentId" placeholder="请输入关联设备ID" />
        </el-form-item>
        <el-form-item label="计划维护日期" prop="maintenancePlanDate">
          <el-date-picker clearable
            v-model="form.maintenancePlanDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择计划维护日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际维护日期" prop="maintenanceActualDate">
          <el-date-picker clearable
            v-model="form.maintenanceActualDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际维护日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="维护内容">
          <editor v-model="form.maintenanceContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="维护人员" prop="maintenancePerson">
          <el-input v-model="form.maintenancePerson" placeholder="请输入维护人员" />
        </el-form-item>
        <el-form-item label="维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)" prop="maintenanceResult">
          <el-input v-model="form.maintenanceResult" placeholder="请输入维护结果：COMPLETED(完成)、PENDING(待完成)、FAILED(失败)" />
        </el-form-item>
        <el-form-item label="维护备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建人" prop="createUser">
          <el-input v-model="form.createUser" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="更新人" prop="updateUser">
          <el-input v-model="form.updateUser" placeholder="请输入更新人" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMaintenance, getMaintenance, delMaintenance, addMaintenance, updateMaintenance } from "@/api/system/maintenance"

export default {
  name: "Maintenance",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 设备预维护管理表格数据
      maintenanceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentId: null,
        maintenanceType: null,
        maintenancePlanDate: null,
        maintenanceActualDate: null,
        maintenanceContent: null,
        maintenancePerson: null,
        maintenanceResult: null,
        createUser: null,
        updateUser: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        equipmentId: [
          { required: true, message: "关联设备ID不能为空", trigger: "blur" }
        ],
        maintenanceType: [
          { required: true, message: "维护类型：ROUTINE(日常)、PERIODIC(定期)、PREVENTIVE(预防性)不能为空", trigger: "change" }
        ],
        maintenancePlanDate: [
          { required: true, message: "计划维护日期不能为空", trigger: "blur" }
        ],
        maintenanceContent: [
          { required: true, message: "维护内容不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        createUser: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ],
        updateUser: [
          { required: true, message: "更新人不能为空", trigger: "blur" }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询设备预维护管理列表 */
    getList() {
      this.loading = true
      listMaintenance(this.queryParams).then(response => {
        this.maintenanceList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        equipmentId: null,
        maintenanceType: null,
        maintenancePlanDate: null,
        maintenanceActualDate: null,
        maintenanceContent: null,
        maintenancePerson: null,
        maintenanceResult: null,
        remark: null,
        createTime: null,
        createUser: null,
        updateTime: null,
        updateUser: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加设备预维护管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getMaintenance(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改设备预维护管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMaintenance(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addMaintenance(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除设备预维护管理编号为"' + ids + '"的数据项？').then(function() {
        return delMaintenance(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/maintenance/export', {
        ...this.queryParams
      }, `maintenance_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
