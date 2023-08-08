import request from '@/utils/request'

const api_name = 'admin/system/sysRole'

export function getPageList(page, limit, searchObj) {
    return request({
        url: `/${api_name}/${page}/${limit}`,
        method: 'get',
        params: searchObj
    })
}

export function save(sysRole) {
    return request({
        url: `/${api_name}/save`,
        method: 'post',
        data: sysRole
    })
}

export function selectById(id) {
    return request({
        url: `/${api_name}/get/${id}`,
        method: 'get'
    })
}

export function update(sysRole) {
    return request({
        url: `/${api_name}/update`,
        method: 'put',
        data: sysRole
    })
}

export function removeById(id) {
    return request({
        url: `/${api_name}/remove/${id}`,
        method: 'delete'
    })
}

export function removeByIds(ids) {
    return request({
        url: `/${api_name}/removes`,
        method: 'delete',
        data: ids
    })
}

export function getRoles(id) {
    return request({
        url: `/${api_name}/toAssign/${id}`,
        method: 'get'
    })
}

export function assignRoles(assign) {
    return request({
        url: `/${api_name}/doAssign`,
        method: 'post',
        data: assign
    })
}

