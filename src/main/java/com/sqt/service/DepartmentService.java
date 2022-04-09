package com.sqt.service;

import com.sqt.bean.Department;
import com.sqt.dao.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper mapper;

    public List<Department> getDepts(){

        return  mapper.selectByExample(null);

    }





}
