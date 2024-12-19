package com.schedule.service.impl;

import com.schedule.dao.SysUserDao;
import com.schedule.dao.impl.SysUserImpl;
import com.schedule.pojo.SysUser;
import com.schedule.service.SysUserService;
import com.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserImpl();
    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        int rows = userDao.addSysUser(sysUser);
        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser sysUser =userDao.getSysUserByUsername(username);
        return sysUser;
    }
}
