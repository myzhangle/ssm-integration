package com.le.ssmintegration.controller;


import com.le.ssmintegration.poji.Emp;
import com.le.ssmintegration.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController
{
    @Autowired
    EmpService empService;
    //获取所有员工信息
    @GetMapping("/emp/all")
    public List<Emp> index()
    {
        return empService.getAllEmp();
    }
}
