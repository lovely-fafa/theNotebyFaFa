package com.atguigu.wechat.controller;


import com.atguigu.auth.service.SysUserService;
import com.atguigu.common.jwt.JwtHelper;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.wechat.BindPhoneVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/admin/wechat")
@CrossOrigin
@Slf4j
public class WechatController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private WxMpService wxMpService;

    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl,
                            HttpServletRequest request) throws UnsupportedEncodingException {
        // buildAuthorizationUrl三个参数
        // 第一个参数: 授权路径，在哪个路径获取微信信息
        // 第二个参数: 固定值，授权类型 WxConsts.OAuth2Scope.SNSAPI_USERINFO
        // 第三个参数: 授权成功之后，跳转路径guiguoa’ 转换成#
        String url = wxMpService.getOAuth2Service()
                .buildAuthorizationUrl(userInfoUrl,
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URLEncoder.encode(returnUrl.replace("guiguoa", "#"),"utf-8"));
        return "redirect:" + url;
    }

    @GetMapping("userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) throws WxErrorException {
        // 获取 accessToken
        WxOAuth2AccessToken accessToken = wxMpService.getOAuth2Service().getAccessToken(code);

        // 获取 openId
        String openId = accessToken.getOpenId();
        log.info("openId={}", openId);

        // 获取用户信息
        WxOAuth2UserInfo userInfo = wxMpService.getOAuth2Service().getUserInfo(accessToken, code);
        log.info("userInfo={}", userInfo);

        // 查用户表 看是否绑定了
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getOpenId, openId);
        SysUser user = sysUserService.getOne(lambdaQueryWrapper);

        String token = "";
        if (user != null) {
            token = JwtHelper.createToken(user.getId(), user.getUsername());
        }

        if (!returnUrl.contains("?")) {
            return "redirect:" + returnUrl + "?token=" + token + "&openId=" + openId;
        } else {
            return "redirect:" + returnUrl + "&token=" + token + "&openId=" + openId;
        }
    }

    @PostMapping("/bindPhone")
    @ResponseBody
    public Result bindPhone(@RequestBody BindPhoneVo bindPhoneVo) {
        // 根据手机号查数据库
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getPhone, bindPhoneVo.getPhone());
        SysUser user = sysUserService.getOne(lambdaQueryWrapper);

        if (user != null) {
            // 存在 更新 openid
            user.setOpenId(bindPhoneVo.getOpenId());
            sysUserService.updateById(user);

            String token = JwtHelper.createToken(user.getId(), user.getUsername());
            return Result.success(token);
        } else {
            return Result.error("手机号不存在，请联系管理员添加手机号");
        }
    }
}
