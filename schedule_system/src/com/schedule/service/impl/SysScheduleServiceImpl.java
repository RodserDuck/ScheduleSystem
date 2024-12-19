package com.schedule.service.impl;

import com.schedule.dao.SysScheduleDao;
import com.schedule.dao.impl.SysScheduleImpl;
import com.schedule.pojo.SysSchedule;
import com.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao scheduleDao = new SysScheduleImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {

        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(Integer sid) {
        return scheduleDao.removeSchedule(sid);
    }

}
