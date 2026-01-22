<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="原料全称" prop="materialName">
        <el-input
          v-model="queryParams.materialName"
          placeholder="请输入原料全称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格" prop="specModel">
        <el-input
          v-model="queryParams.specModel"
          placeholder="请输入规格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计量单位" prop="unit">
        <el-input
          v-model="queryParams.unit"
          placeholder="请输入计量单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原料品牌" prop="brand">
        <el-input
          v-model="queryParams.brand"
          placeholder="请输入原料品牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前实时库存数量" prop="stockQuantity">
        <el-input
          v-model="queryParams.stockQuantity"
          placeholder="请输入当前实时库存数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="安全库存下限(低于预警)" prop="safeStock">
        <el-input
          v-model="queryParams.safeStock"
          placeholder="请输入安全库存下限(低于预警)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存上限(高于防积压)" prop="maxStock">
        <el-input
          v-model="queryParams.maxStock"
          placeholder="请输入库存上限(高于防积压)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库位" prop="stockLocation">
        <el-input
          v-model="queryParams.stockLocation"
          placeholder="请输入库位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最新批次号" prop="batchNo">
        <el-input
          v-model="queryParams.batchNo"
          placeholder="请输入最新批次号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商全称" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供应商全称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商联系电话" prop="supplierPhone">
        <el-input
          v-model="queryParams.supplierPhone"
          placeholder="请输入供应商联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最新采购单价" prop="purchasePrice">
        <el-input
          v-model="queryParams.purchasePrice"
          placeholder="请输入最新采购单价(含税)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="税率(%)" prop="taxRate">
        <el-input
          v-model="queryParams.taxRate"
          placeholder="请输入税率(%)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计采购金额" prop="totalPurchase">
        <el-input
          v-model="queryParams.totalPurchase"
          placeholder="请输入累计采购金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原料生产日期" prop="productionDate">
        <el-date-picker clearable
          v-model="queryParams.productionDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择原料生产日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="过期" prop="expireDate">
        <el-date-picker clearable
          v-model="queryParams.expireDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择过期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="检验结果/不合格原因" prop="inspectResult">
        <el-input
          v-model="queryParams.inspectResult"
          placeholder="请输入检验结果/不合格原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特殊储存要求" prop="storageRequire">
        <el-input
          v-model="queryParams.storageRequire"
          placeholder="请输入特殊储存要求"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最近入库时间" prop="lastInTime">
        <el-date-picker clearable
          v-model="queryParams.lastInTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最近入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最近出库时间" prop="lastOutTime">
        <el-date-picker clearable
          v-model="queryParams.lastOutTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最近出库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="记录创建人" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入记录创建人"
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
          v-hasPermi="['system:manage:add']"
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
          v-hasPermi="['system:manage:edit']"
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
          v-hasPermi="['system:manage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:manage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="manageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="原料唯一编号" align="center" prop="materialId" />
      <el-table-column label="原料全称" align="center" prop="materialName" />
      <el-table-column label="原料类别" align="center" prop="materialType" />
      <el-table-column label="规格" align="center" prop="specModel" />
      <el-table-column label="计量单位" align="center" prop="unit" />
      <el-table-column label="原料品牌" align="center" prop="brand" />
      <el-table-column label="当前实时库存数量" align="center" prop="stockQuantity" />
      <el-table-column label="安全库存下限(低于预警)" align="center" prop="safeStock" />
      <el-table-column label="库存上限(高于防积压)" align="center" prop="maxStock" />
      <el-table-column label="库位/货架编号(如A1-02、冷藏库-5号)" align="center" prop="stockLocation" />
      <el-table-column label="最新批次号(溯源核心)" align="center" prop="batchNo" />
      <el-table-column label="供应商全称" align="center" prop="supplierName" />
      <el-table-column label="供应商联系电话" align="center" prop="supplierPhone" />
      <el-table-column label="最新采购单价(含税)" align="center" prop="purchasePrice" />
      <el-table-column label="税率" align="center" prop="taxRate" />
      <el-table-column label="累计采购金额(成本统计)" align="center" prop="totalPurchase" />
      <el-table-column label="原料生产日期(效期管理)" align="center" prop="productionDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.productionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="过期/质保日期(临期预警)" align="center" prop="expireDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expireDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="质量状态(合格/待检/不合格/返工)" align="center" prop="qualityStatus" />
      <el-table-column label="检验结果/不合格原因" align="center" prop="inspectResult" />
      <el-table-column label="特殊储存要求(冷藏0-4℃/避光/密封等)" align="center" prop="storageRequire" />
      <el-table-column label="使用状态(在用/停用/淘汰/待采购)" align="center" prop="useStatus" />
      <el-table-column label="最近入库时间" align="center" prop="lastInTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastInTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最近出库时间" align="center" prop="lastOutTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastOutTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="记录创建人(账号/姓名)" align="center" prop="creator" />
      <el-table-column label="备注(采购频率/领用要求等)" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:manage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:manage:remove']"
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

    <!-- 添加或修改原料管理整合-单全维度管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="原料全称" prop="materialName">
          <el-input v-model="form.materialName" placeholder="请输入原料全称" />
        </el-form-item>
        <el-form-item label="规格/型号/纯度/等级(如25kg/袋、99.9%纯)" prop="specModel">
          <el-input v-model="form.specModel" placeholder="请输入规格/型号/纯度/等级(如25kg/袋、99.9%纯)" />
        </el-form-item>
        <el-form-item label="计量单位(kg/瓶/米/箱/卷等)" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入计量单位(kg/瓶/米/箱/卷等)" />
        </el-form-item>
        <el-form-item label="原料品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入原料品牌" />
        </el-form-item>
        <el-form-item label="当前实时库存数量" prop="stockQuantity">
          <el-input v-model="form.stockQuantity" placeholder="请输入当前实时库存数量" />
        </el-form-item>
        <el-form-item label="安全库存下限(低于预警)" prop="safeStock">
          <el-input v-model="form.safeStock" placeholder="请输入安全库存下限(低于预警)" />
        </el-form-item>
        <el-form-item label="库存上限(高于防积压)" prop="maxStock">
          <el-input v-model="form.maxStock" placeholder="请输入库存上限(高于防积压)" />
        </el-form-item>
        <el-form-item label="库位/货架编号(如A1-02、冷藏库-5号)" prop="stockLocation">
          <el-input v-model="form.stockLocation" placeholder="请输入库位/货架编号(如A1-02、冷藏库-5号)" />
        </el-form-item>
        <el-form-item label="最新批次号(溯源核心)" prop="batchNo">
          <el-input v-model="form.batchNo" placeholder="请输入最新批次号(溯源核心)" />
        </el-form-item>
        <el-form-item label="供应商全称" prop="supplierName">
          <el-input v-model="form.supplierName" placeholder="请输入供应商全称" />
        </el-form-item>
        <el-form-item label="供应商联系电话" prop="supplierPhone">
          <el-input v-model="form.supplierPhone" placeholder="请输入供应商联系电话" />
        </el-form-item>
        <el-form-item label="最新采购单价(含税)" prop="purchasePrice">
          <el-input v-model="form.purchasePrice" placeholder="请输入最新采购单价(含税)" />
        </el-form-item>
        <el-form-item label="税率(%)，默认13%" prop="taxRate">
          <el-input v-model="form.taxRate" placeholder="请输入税率(%)，默认13%" />
        </el-form-item>
        <el-form-item label="累计采购金额(成本统计)" prop="totalPurchase">
          <el-input v-model="form.totalPurchase" placeholder="请输入累计采购金额(成本统计)" />
        </el-form-item>
        <el-form-item label="原料生产日期(效期管理)" prop="productionDate">
          <el-date-picker clearable
            v-model="form.productionDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择原料生产日期(效期管理)">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="过期/质保日期(临期预警)" prop="expireDate">
          <el-date-picker clearable
            v-model="form.expireDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择过期/质保日期(临期预警)">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检验结果/不合格原因" prop="inspectResult">
          <el-input v-model="form.inspectResult" placeholder="请输入检验结果/不合格原因" />
        </el-form-item>
        <el-form-item label="特殊储存要求(冷藏0-4℃/避光/密封等)" prop="storageRequire">
          <el-input v-model="form.storageRequire" placeholder="请输入特殊储存要求(冷藏0-4℃/避光/密封等)" />
        </el-form-item>
        <el-form-item label="最近入库时间" prop="lastInTime">
          <el-date-picker clearable
            v-model="form.lastInTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最近入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最近出库时间" prop="lastOutTime">
          <el-date-picker clearable
            v-model="form.lastOutTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最近出库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="记录创建人(账号/姓名)" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入记录创建人(账号/姓名)" />
        </el-form-item>
        <el-form-item label="备注(采购频率/领用要求等)" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注(采购频率/领用要求等)" />
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
import { listManage, getManage, delManage, addManage, updateManage } from "@/api/system/manage"

export default {
  name: "Manage",
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
      // 原料管理整合-单全维度管理表格数据
      manageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        materialName: null,
        materialType: null,
        specModel: null,
        unit: null,
        brand: null,
        stockQuantity: null,
        safeStock: null,
        maxStock: null,
        stockLocation: null,
        batchNo: null,
        supplierName: null,
        supplierPhone: null,
        purchasePrice: null,
        taxRate: null,
        totalPurchase: null,
        productionDate: null,
        expireDate: null,
        qualityStatus: null,
        inspectResult: null,
        storageRequire: null,
        useStatus: null,
        lastInTime: null,
        lastOutTime: null,
        creator: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        materialName: [
          { required: true, message: "原料全称不能为空", trigger: "blur" }
        ],
        materialType: [
          { required: true, message: "原料类别(主料/辅料/耗材/化工/包装等)不能为空", trigger: "change" }
        ],
        specModel: [
          { required: true, message: "规格/型号/纯度/等级(如25kg/袋、99.9%纯)不能为空", trigger: "blur" }
        ],
        unit: [
          { required: true, message: "计量单位(kg/瓶/米/箱/卷等)不能为空", trigger: "blur" }
        ],
        stockQuantity: [
          { required: true, message: "当前实时库存数量不能为空", trigger: "blur" }
        ],
        safeStock: [
          { required: true, message: "安全库存下限(低于预警)不能为空", trigger: "blur" }
        ],
        stockLocation: [
          { required: true, message: "库位/货架编号(如A1-02、冷藏库-5号)不能为空", trigger: "blur" }
        ],
        batchNo: [
          { required: true, message: "最新批次号(溯源核心)不能为空", trigger: "blur" }
        ],
        supplierName: [
          { required: true, message: "供应商全称不能为空", trigger: "blur" }
        ],
        supplierPhone: [
          { required: true, message: "供应商联系电话不能为空", trigger: "blur" }
        ],
        purchasePrice: [
          { required: true, message: "最新采购单价(含税)不能为空", trigger: "blur" }
        ],
        taxRate: [
          { required: true, message: "税率(%)，默认13%不能为空", trigger: "blur" }
        ],
        productionDate: [
          { required: true, message: "原料生产日期(效期管理)不能为空", trigger: "blur" }
        ],
        expireDate: [
          { required: true, message: "过期/质保日期(临期预警)不能为空", trigger: "blur" }
        ],
        qualityStatus: [
          { required: true, message: "质量状态(合格/待检/不合格/返工)不能为空", trigger: "change" }
        ],
        useStatus: [
          { required: true, message: "使用状态(在用/停用/淘汰/待采购)不能为空", trigger: "change" }
        ],
        creator: [
          { required: true, message: "记录创建人(账号/姓名)不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "记录创建时间(自动生成)不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "记录更新时间(修改自动刷新)不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询原料管理整合-单全维度管理列表 */
    getList() {
      this.loading = true
      listManage(this.queryParams).then(response => {
        this.manageList = response.rows
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
        materialId: null,
        materialName: null,
        materialType: null,
        specModel: null,
        unit: null,
        brand: null,
        stockQuantity: null,
        safeStock: null,
        maxStock: null,
        stockLocation: null,
        batchNo: null,
        supplierName: null,
        supplierPhone: null,
        purchasePrice: null,
        taxRate: null,
        totalPurchase: null,
        productionDate: null,
        expireDate: null,
        qualityStatus: null,
        inspectResult: null,
        storageRequire: null,
        useStatus: null,
        lastInTime: null,
        lastOutTime: null,
        creator: null,
        createTime: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.materialId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加原料管理整合-单全维度管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const materialId = row.materialId || this.ids
      getManage(materialId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改原料管理整合-单全维度管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.materialId != null) {
            updateManage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addManage(this.form).then(response => {
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
      const materialIds = row.materialId || this.ids
      this.$modal.confirm('是否确认删除原料管理整合-单全维度管理编号为"' + materialIds + '"的数据项？').then(function() {
        return delManage(materialIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/manage/export', {
        ...this.queryParams
      }, `manage_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
