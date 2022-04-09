package com.sqt.service;

import com.sqt.bean.Employee;
import com.sqt.bean.EmployeeExample;
import com.sqt.dao.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllList() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    public int saveEmp(Employee employee){
        return employeeMapper.insert(employee);
    }

    public boolean hasEmpName(String name) {

        EmployeeExample emp=new EmployeeExample();
        emp.createCriteria().andEmpNameEqualTo(name);

        return employeeMapper.countByExample(emp)==0;
    }

    public Employee getName(Integer id) {

        Employee employee = employeeMapper.selectByPrimaryKey(id);

        return employee;
    }

    public int updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer deleteEmp(Integer id) {

        return employeeMapper.deleteByPrimaryKey(id);
    }

    public void delectBatch(List<Integer> idList) {
            EmployeeExample example=new EmployeeExample();
            example.createCriteria().andEmpIdIn(idList);
            employeeMapper.deleteByExample(example);
    }
}
