package com.le.ssmintegration.controller;

import com.le.ssmintegration.mapper.EmpMapper;
import com.le.ssmintegration.poji.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController
{
    @Autowired
    EmpMapper empMapper;

    @GetMapping("/test")
    public List<Emp> test()
    {
        List<Emp> emps = empMapper.selectByExample(null);
        return emps;
    }

}
