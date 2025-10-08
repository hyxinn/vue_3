package org.example.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.example.springboot.mapper.EmployeeMapper;


import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper  employeeMapper;

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }


    public void update(Employee employee) {
        employeeMapper.updateById(employee);
    }
    public List<Employee> selectAll() {
        //额外的业务操作
        return  employeeMapper.selectAll();
    }

    public Employee selecById(Integer id) {
        return employeeMapper.selectById(id);
    }

    public List<Employee> selectList(Employee employee) {
        System.out.println(employee);
        return null;
    }

    public PageInfo selectPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(1, 10);
        List<Employee> list = employeeMapper.selectAll();
        return PageInfo.of(list);
    }
}
