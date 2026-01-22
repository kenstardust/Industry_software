<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备唯一编码" prop="equipmentCode">
        <el-input
          v-model="queryParams.equipmentCode"
          placeholder="请输入设备唯一编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="equipmentName">
        <el-input
          v-model="queryParams.equipmentName"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备型号" prop="model">
        <el-input
          v-model="queryParams.model"
          placeholder="请输入设备型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备品牌" prop="brand">
        <el-input
          v-model="queryParams.brand"
          placeholder="请输入设备品牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="安装位置" prop="installLocation">
        <el-input
          v-model="queryParams.installLocation"
          placeholder="请输入安装位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备责任人" prop="responsiblePerson">
        <el-input
          v-model="queryParams.responsiblePerson"
          placeholder="请输入设备责任人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维护周期值" prop="cycleValue">
        <el-input
          v-model="queryParams.cycleValue"
          placeholder="请输入维护周期值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下次预维护日期" prop="nextMaintenanceDate">
        <el-date-picker clearable
          v-model="queryParams.nextMaintenanceDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下次预维护日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最近一次维护执行时间" prop="lastMaintenanceDate">
        <el-date-picker clearable
          v-model="queryParams.lastMaintenanceDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最近一次维护执行时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最近一次维护人员" prop="lastMaintenancePerson">
        <el-input
          v-model="queryParams.lastMaintenancePerson"
          placeholder="请输入最近一次维护人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二维码存储地址/内容" prop="qrCodeUrl">
        <el-input
          v-model="queryParams.qrCodeUrl"
          placeholder="请输入二维码存储地址/内容"
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
          v-hasPermi="['system:management:add']"
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
          v-hasPermi="['system:management:edit']"
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
          v-hasPermi="['system:management:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:management:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="设备唯一编码" align="center" prop="equipmentCode" />
      <el-table-column label="设备名称" align="center" prop="equipmentName" />
      <el-table-column label="设备类型：1-机床 2-检测设备 3-AGV 4-服务器" align="center" prop="equipmentType" />
      <el-table-column label="设备型号" align="center" prop="model" />
      <el-table-column label="设备品牌" align="center" prop="brand" />
      <el-table-column label="安装位置" align="center" prop="installLocation" />
      <el-table-column label="设备责任人" align="center" prop="responsiblePerson" />
      <el-table-column label="设备状态：1-正常 2-待维护 3-故障 4-停用 5-报废" align="center" prop="status" />
      <el-table-column label="维护类型" align="center" prop="maintenanceType" />
      <el-table-column label="维护周期类型：1-按天 2-按周 3-按月 4-按季度 5-按年" align="center" prop="cycleType" />
      <el-table-column label="维护周期值" align="center" prop="cycleValue" />
      <el-table-column label="下次预维护日期" align="center" prop="nextMaintenanceDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.nextMaintenanceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最近一次维护执行时间" align="center" prop="lastMaintenanceDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastMaintenanceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最近一次维护人员" align="center" prop="lastMaintenancePerson" />
      <el-table-column label="最近一次维护结果" align="center" prop="lastMaintenanceResult" />
      <el-table-column label="二维码存储地址/内容" align="center" prop="qrCodeUrl" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:management:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:management:remove']"
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

    <!-- 添加或修改设备管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备唯一编码" prop="equipmentCode">
          <el-input v-model="form.equipmentCode" placeholder="请输入设备唯一编码" />
        </el-form-item>
        <el-form-item label="设备名称" prop="equipmentName">
          <el-input v-model="form.equipmentName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="设备型号" prop="model">
          <el-input v-model="form.model" placeholder="请输入设备型号" />
        </el-form-item>
        <el-form-item label="设备品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入设备品牌" />
        </el-form-item>
        <el-form-item label="安装位置" prop="installLocation">
          <el-input v-model="form.installLocation" placeholder="请输入安装位置" />
        </el-form-item>
        <el-form-item label="设备责任人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入设备责任人" />
        </el-form-item>
        <el-form-item label="维护周期值" prop="cycleValue">
          <el-input v-model="form.cycleValue" placeholder="请输入维护周期值" />
        </el-form-item>
        <el-form-item label="下次预维护日期" prop="nextMaintenanceDate">
          <el-date-picker clearable
            v-model="form.nextMaintenanceDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下次预维护日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最近一次维护执行时间" prop="lastMaintenanceDate">
          <el-date-picker clearable
            v-model="form.lastMaintenanceDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最近一次维护执行时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最近一次维护人员" prop="lastMaintenancePerson">
          <el-input v-model="form.lastMaintenancePerson" placeholder="请输入最近一次维护人员" />
        </el-form-item>
        <el-form-item label="最近一次维护结果" prop="lastMaintenanceResult">
          <el-input v-model="form.lastMaintenanceResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="二维码存储地址/内容" prop="qrCodeUrl">
          <el-input v-model="form.qrCodeUrl" placeholder="请输入二维码存储地址/内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listManagement, getManagement, delManagement, addManagement, updateManagement } from "@/api/system/management"

export default {
  name: "Management",
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
      // 设备管理表格数据
      managementList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentCode: null,
        equipmentName: null,
        equipmentType: null,
        model: null,
        brand: null,
        installLocation: null,
        responsiblePerson: null,
        status: null,
        maintenanceType: null,
        cycleType: null,
        cycleValue: null,
        nextMaintenanceDate: null,
        lastMaintenanceDate: null,
        lastMaintenancePerson: null,
        lastMaintenanceResult: null,
        qrCodeUrl: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        equipmentCode: [
          { required: true, message: "设备唯一编码不能为空", trigger: "blur" }
        ],
        equipmentName: [
          { required: true, message: "设备名称不能为空", trigger: "blur" }
        ],
        equipmentType: [
          { required: true, message: "设备类型：1-机床 2-检测设备 3-AGV 4-服务器不能为空", trigger: "change" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询设备管理列表 */
    getList() {
      this.loading = true
      listManagement(this.queryParams).then(response => {
        this.managementList = response.rows
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
        equipmentCode: null,
        equipmentName: null,
        equipmentType: null,
        model: null,
        brand: null,
        installLocation: null,
        responsiblePerson: null,
        status: null,
        maintenanceType: null,
        cycleType: null,
        cycleValue: null,
        nextMaintenanceDate: null,
        lastMaintenanceDate: null,
        lastMaintenancePerson: null,
        lastMaintenanceResult: null,
        qrCodeUrl: null,
        remark: null,
        createTime: null,
        updateTime: null
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
      this.title = "添加设备管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getManagement(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改设备管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateManagement(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addManagement(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除设备管理编号为"' + ids + '"的数据项？').then(function() {
        return delManagement(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/management/export', {
        ...this.queryParams
      }, `management_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
