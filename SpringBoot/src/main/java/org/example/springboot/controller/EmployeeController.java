package org.example.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Employee;
import org.example.springboot.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;


    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return Result.success();
    }


    @PutMapping("/update")
    public Result update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return Result.success();
    }



    @GetMapping("/selectById/{id}/{no}")
    public Result selecById(@PathVariable Integer id) {
        Employee employee = employeeService.selecById(id);
        return Result.success(employee);
    }

    /*
     * 查询所有员工信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Employee> list = employeeService.selectAll();
        return Result.success(list);
    }

    /*
     * 查询员工信息分页
     * pageNum ；当前页码
     * pageSize：每页的个数
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
         PageInfo<Employee> pageInfo = employeeService.selectPage(pageNum, pageSize);
         return Result.success(pageInfo);
    }


}
