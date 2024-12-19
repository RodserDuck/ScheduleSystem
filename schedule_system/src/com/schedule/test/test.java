package com.schedule.test;

import com.schedule.dao.BaseDao;
import com.schedule.dao.SysUserDao;
import com.schedule.dao.impl.SysUserImpl;
import com.schedule.pojo.SysUser;

public class test {
    public static void main(String[] args) {
        SysUserDao sysUserDao = new SysUserImpl();
        SysUser sysUser = new SysUser(null,"diandian","111111");
        sysUserDao.addSysUser(sysUser);
    }
}
