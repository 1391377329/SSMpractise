package com.sqt.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Employee {
    private Integer empId;

    @Pattern(regexp = "^[0-9a-zA-Z\\u4e00-\\u9fa5_]{2,16}$",message = "用户名非法!")
    @NotBlank(message = "姓名不能为空" )
    private String empName;

    @Pattern(regexp = "^(?:[1-9][0-9]?|1[01][0-9]|120)$",message = "年龄不正确!")
    private Integer empAge;

    private String gender;

    private Integer empDeptid;

    private Department department;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Integer empAge, String gender, Integer empDeptid) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.gender = gender;
        this.empDeptid = empDeptid;
    }

    public Employee(Integer empId, String empName, Integer empAge, String gender, Integer empDeptid, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.gender = gender;
        this.empDeptid = empDeptid;
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getEmpDeptid() {
        return empDeptid;
    }

    public void setEmpDeptid(Integer empDeptid) {
        this.empDeptid = empDeptid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", gender='" + gender + '\'' +
                ", empDeptid=" + empDeptid +
                ", department=" + department +
                '}';
    }
}