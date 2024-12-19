package com.schedule.dao.impl;

import com.schedule.dao.BaseDao;
import com.schedule.dao.SysScheduleDao;
import com.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleImpl extends BaseDao implements SysScheduleDao {
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql,schedule.getUid(),schedule.getTitle(),schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql = "select * from sys_schedule where uid=?";
        List<SysSchedule> itemList = baseQuery(SysSchedule.class, sql, uid);
        return itemList;
    }

    @Override
    public Integer addDefault(int uid) {
        String sql = "insert into sys_schedule values(null,?,'请输入日程',0)";
        int rows = baseUpdate(sql,uid);
        return rows;
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        String sql = "update sys_schedule set title=?,completed=? where sid=?";
        return baseUpdate(sql,schedule.getTitle(),schedule.getCompleted(),schedule.getSid());
    }

    @Override
    public Integer removeSchedule(Integer sid) {
        String sql = "delete from sys_schedule where sid=?";
        return baseUpdate(sql,sid);
    }
}
