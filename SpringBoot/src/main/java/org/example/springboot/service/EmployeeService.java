package org.example.springboot.service;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.example.springboot.mapper.EmployeeMapper;


import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper  employeeMapper;

    public List<Employee> selectAll() {
        //额外的业务操作
        return  employeeMapper.selectAll();
    }
}
