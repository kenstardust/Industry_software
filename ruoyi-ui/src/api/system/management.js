import request from '@/utils/request'

// 查询设备管理列表
export function listManagement(query) {
  return request({
    url: '/system/management/list',
    method: 'get',
    params: query
  })
}

// 查询设备管理详细
export function getManagement(id) {
  return request({
    url: '/system/management/' + id,
    method: 'get'
  })
}

// 新增设备管理
export function addManagement(data) {
  return request({
    url: '/system/management',
    method: 'post',
    data: data
  })
}

// 修改设备管理
export function updateManagement(data) {
  return request({
    url: '/system/management',
    method: 'put',
    data: data
  })
}

// 删除设备管理
export function delManagement(id) {
  return request({
    url: '/system/management/' + id,
    method: 'delete'
  })
}
