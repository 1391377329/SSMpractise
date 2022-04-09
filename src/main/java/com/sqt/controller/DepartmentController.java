package com.sqt.controller;

import com.sqt.bean.Department;
import com.sqt.bean.Message;
import com.sqt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @RequestMapping("/depts")
    @ResponseBody()
    public Message getDepts(){
        List<Department> list = service.getDepts();
        Message depts = Message.success().add("depts", list);
        return depts;
    }

}
