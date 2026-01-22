import request from '@/utils/request'

// 查询编码管理列表
export function listManagement(query) {
  return request({
    url: '/system/codeManagement/list',
    method: 'get',
    params: query
  })
}

// 查询编码管理详细
export function getManagement(id) {
  return request({
    url: '/system/codeManagement/' + id,
    method: 'get'
  })
}

// 新增编码管理
export function addManagement(data) {
  return request({
    url: '/system/codeManagement',
    method: 'post',
    data: data
  })
}

// 修改编码管理
export function updateManagement(data) {
  return request({
    url: '/system/codeManagement',
    method: 'put',
    data: data
  })
}

// 删除编码管理
export function delManagement(id) {
  return request({
    url: '/system/codeManagement/' + id,
    method: 'delete'
  })
}
