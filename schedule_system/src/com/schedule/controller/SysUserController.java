package com.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schedule.common.Result;
import com.schedule.common.ResultCodeEnum;
import com.schedule.pojo.SysUser;
import com.schedule.service.SysUserService;
import com.schedule.service.impl.SysUserServiceImpl;
import com.schedule.util.MD5Util;
import com.schedule.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class SysUserController extends BaseController{

    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 接收用户注册请求的业务处理方法
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp)throws Exception {

        SysUser user = WebUtil.readJson(req,SysUser.class);

        int rows = userService.regist(user);
        Result result =Result.ok(null);
        if(rows < 1){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp){

        SysUser sysUser = WebUtil.readJson(req,SysUser.class);
        SysUser loginUser = userService.findByUsername(sysUser.getUsername());
        Result result =null;

            if(null==loginUser){
                result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
            } else if(!MD5Util.encrypt(sysUser.getUserPwd()).equals(loginUser.getUserPwd())) {
                result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }else{
                loginUser.setUserPwd("");
                result = Result.ok(loginUser);
            }
        WebUtil.writeJson(resp,result);
    }


    /**
     * 注册时，接收要注册的用户名
     * @param req
     * @param resp
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收用户名
        String username = req.getParameter("username");
        //查询用户名是否有对应的用户
        SysUser byUsername = userService.findByUsername(username);
        //如果有响应已占有
        //如果没用响应可用
        Result result= Result.ok(null);
        if(null!=byUsername){
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String info = objectMapper.writeValueAsString(result);


        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(info);
    }
}
