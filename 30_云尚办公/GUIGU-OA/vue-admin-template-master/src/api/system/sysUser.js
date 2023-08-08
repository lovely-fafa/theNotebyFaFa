import request from '@/utils/request'

const api_name = '/admin/system/sysUser'

export default {

    getPageList(page, limit, searchObj) {
        return request({
            url: `${api_name}/${page}/${limit}`,
            method: 'get',
            data: searchObj // url查询字符串或表单键值对
        })
    },

    getById(id) {
        return request({
            url: `${api_name}/get/${id}`,
            method: 'get'
        })
    },

    save(role) {
        return request({
            url: `${api_name}/save`,
            method: 'post',
            data: role
        })
    },

    updateById(role) {
        return request({
            url: `${api_name}/update`,
            method: 'put',
            data: role
        })
    },

    removeById(id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: 'delete'
        })
    },

    changeStatus(sysUser) {
        return request({
            url: `${api_name}/status`,
            method: 'put',
            data: sysUser
        })
    },


}
