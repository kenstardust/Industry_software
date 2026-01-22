import request from '@/utils/request'

// 查询设备预维护管理列表
export function listMaintenance(query) {
  return request({
    url: '/system/maintenance/list',
    method: 'get',
    params: query
  })
}

// 查询设备预维护管理详细
export function getMaintenance(id) {
  return request({
    url: '/system/maintenance/' + id,
    method: 'get'
  })
}

// 新增设备预维护管理
export function addMaintenance(data) {
  return request({
    url: '/system/maintenance',
    method: 'post',
    data: data
  })
}

// 修改设备预维护管理
export function updateMaintenance(data) {
  return request({
    url: '/system/maintenance',
    method: 'put',
    data: data
  })
}

// 删除设备预维护管理
export function delMaintenance(id) {
  return request({
    url: '/system/maintenance/' + id,
    method: 'delete'
  })
}
