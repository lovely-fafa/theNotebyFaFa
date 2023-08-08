import request from '@/utils/request'


export default {

  bindPhone(bindPhoneVo) {
    return request({
      url: `/admin/wechat/bindPhone`,
      method: 'post',
      data: bindPhoneVo
    })
  },

  getCurrentUser() {
    return request({
      url: `/admin/process/getCurrentUser/`,
      method: 'get'
    })
  },
}
