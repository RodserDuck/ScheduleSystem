package com.schedule.service;

import com.schedule.pojo.SysUser;

/**
 * 该接口定义了以sys_user为核心的业务处理功能
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser 将要注册的用户名和明文密码以sysUser对象接收
     * @return 注册成功返回1，注册失败返回0
     */
    int regist(SysUser sysUser);


    SysUser findByUsername(String username);
}
