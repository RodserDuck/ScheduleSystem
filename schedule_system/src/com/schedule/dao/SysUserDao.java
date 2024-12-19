package com.schedule.dao;

import com.schedule.pojo.SysUser;

import java.util.List;

public interface SysUserDao {
    int addSysUser(SysUser sysUser);
    SysUser getSysUserByUsername(String username);
}
