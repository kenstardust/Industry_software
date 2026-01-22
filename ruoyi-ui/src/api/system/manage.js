import request from '@/utils/request'

// 查询原料管理整合-单全维度管理列表
export function listManage(query) {
  return request({
    url: '/system/manage/list',
    method: 'get',
    params: query
  })
}

// 查询原料管理整合-单全维度管理详细
export function getManage(materialId) {
  return request({
    url: '/system/manage/' + materialId,
    method: 'get'
  })
}

// 新增原料管理整合-单全维度管理
export function addManage(data) {
  return request({
    url: '/system/manage',
    method: 'post',
    data: data
  })
}

// 修改原料管理整合-单全维度管理
export function updateManage(data) {
  return request({
    url: '/system/manage',
    method: 'put',
    data: data
  })
}

// 删除原料管理整合-单全维度管理
export function delManage(materialId) {
  return request({
    url: '/system/manage/' + materialId,
    method: 'delete'
  })
}
