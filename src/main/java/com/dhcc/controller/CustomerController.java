package com.dhcc.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.dhcc.dao.DepartmentDao;
import com.dhcc.dao.EmployeeDao;
import com.dhcc.entities.Department;
import com.dhcc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangqi
 * @date 2020/6/5
 */
@Controller
public class CustomerController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps/list")
    public String listEmps(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "list";
    }

    @GetMapping("/emps")
    public String toAddPage(Model model) {
        model.addAttribute("dept", departmentDao.getDepartments());
        return "add";
    }

    /**
     * 进入编辑页面
     */
    @GetMapping("/emps/{id}")
    public String getEmpById(@PathVariable("id") Integer id, Model model) {
        Employee employee = this.employeeDao.get(id);
        model.addAttribute("emp", employee);
        model.addAttribute("dept", departmentDao.getDepartments());
        return "add";
    }

    /**
     * 新增员工
     */
    @PostMapping("/emps")
    public String add(Employee employee) {
        this.employeeDao.save(employee);
        System.out.println("method: add");
        return "redirect:/emps/list";
    }

    /**
     * 修改员工信息
     */
    @PutMapping("/emps")
    public String edit(Employee employee) {
        this.employeeDao.save(employee);
        System.out.println("method: edit");
        return "redirect:/emps/list";
    }

    @DeleteMapping("/emps/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.employeeDao.delete(id);
        return "redirect:/emps/list";
    }
}
