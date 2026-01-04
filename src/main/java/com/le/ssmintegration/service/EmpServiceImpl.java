package com.le.ssmintegration.service;


import com.le.ssmintegration.mapper.EmpMapper;
import com.le.ssmintegration.poji.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService
{
    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Emp> getAllEmp()
    {
        return empMapper.selectByExample(null);
    }
}
