package com.esms.service.impl;

import com.esms.service.recordamountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esms.mapper.recordamountMapper;
import com.esms.entity.recordamount;

import java.util.List;

@Service
public class recordamountServiceImpl implements recordamountService {
    @Autowired
    private recordamountMapper Mapper;
    @Override
    public List<Integer> getallWage(String No){
        return Mapper.getallWage(No);
    }
    @Override
    public List<recordamount> getWagebyid(String No, String Name){
        return Mapper.getWagebyid(No,Name);
    }
    @Override
    public void addWage(recordamount m){
        Mapper.addWage(m);
    }
    @Override
    public void updateWage(recordamount m){
        Mapper.updateWage(m);
    }
}
