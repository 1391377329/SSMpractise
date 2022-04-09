package com.sqt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqt.bean.Employee;
import com.sqt.bean.Message;
import com.sqt.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Validated
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String toIndex(){

        return "index";
    }

    @GetMapping ("/list")
    @ResponseBody()
    public Message selectEmp(@RequestParam( value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {

        PageHelper.startPage(pageNum,5);
        List<Employee> list = employeeService.getAllList();
        PageInfo<Employee> info=new PageInfo<Employee>(list,5);

//        model.addAttribute("pageInfo", info);
        info.getList().forEach(System.out::println);

        return Message.success().add("pageInfo",info);
    }


    @PostMapping("/verifyEmp")
    @ResponseBody()
    public Message saveEmp(@Valid Employee employee, BindingResult result) {
        employeeService.saveEmp(employee);
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();

            for(FieldError error:fieldErrors){
                //得到错误的字段名
                String field = error.getField();
                //
                String defaultMessage = error.getDefaultMessage();
                map.put(field,defaultMessage);
            }
            return Message.failure().add("ErrorInfo",map);
        } else {
            return Message.success();
        }
    }

    @RequestMapping("/verify")
    @ResponseBody()
    public Message verifyEmpInfo( @Param("empName")String empName){

        if(employeeService.hasEmpName(empName)) {
            //不存在，状态码为1
            return Message.success();
        }
        //存在状态码为2
        return Message.failure();
    }

    @GetMapping ("/emp/{id}")
    @ResponseBody()
    public Message getEmpName(@PathVariable("id") Integer id){

        System.out.println("--------------加载了此方法-------------");
        Employee employee =employeeService.getName(id);


        return Message.success().add("emp",employee);
    }

    @PutMapping("/emp/{empId}")
    @ResponseBody()
    public Message updateEmp(Employee employee){

        System.out.println("执行了put");

        int i =employeeService.updateEmp(employee);

        return Message.success();
    }

    @DeleteMapping("/emp/{ids}")
    @ResponseBody
    public Message deleteOne(@PathVariable("ids") String ids){
        List<Integer> idList = new ArrayList<>();
        if(ids.contains("-")){
            String[] split = ids.split("-");
            for (String s:split) {
                idList.add(Integer.parseInt(s));
            }
            employeeService.delectBatch(idList);
        }else{
            Integer res = employeeService.deleteEmp(Integer.parseInt(ids));
        }
        System.out.println("执行了删除");
        return Message.success();
    }
}
