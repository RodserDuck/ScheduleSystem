package com.schedule.controller;

import com.schedule.common.Result;
import com.schedule.pojo.SysSchedule;
import com.schedule.service.SysScheduleService;
import com.schedule.service.impl.SysScheduleServiceImpl;
import com.schedule.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        Map data = new HashMap();
        data.put("itemList", itemList);
        Result result = Result.ok(data);
        WebUtil.writeJson(resp,result);
    }
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        scheduleService.addDefault(uid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        SysSchedule schedule = WebUtil.readJson(req,SysSchedule.class);
        scheduleService.updateSchedule(schedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        scheduleService.removeSchedule(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
