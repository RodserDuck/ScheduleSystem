package com.schedule.dao.impl;

import com.schedule.dao.SysUserDao;
import com.schedule.pojo.SysSchedule;
import com.schedule.pojo.SysUser;
import com.schedule.dao.BaseDao;

import java.util.List;

public class SysUserImpl extends BaseDao implements SysUserDao {

    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        int rows = baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
        return rows;
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username=?";
        List<SysUser> user = baseQuery(SysUser.class,sql,username);
        return user.isEmpty() ? null : user.get(0);
    }
}
