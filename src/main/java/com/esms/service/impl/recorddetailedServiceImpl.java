package com.esms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esms.service.recorddetailedService;
import com.esms.mapper.recorddetailedMapper;
import com.esms.entity.recorddetailed;

import java.util.List;

@Service
public class recorddetailedServiceImpl implements recorddetailedService{
    @Autowired
    private recorddetailedMapper Mapper;
    @Override
    public void adddetailed(recorddetailed m){
        Mapper.adddetailed(m);
    }
    @Override
    public List<recorddetailed> getalldetailedbyNo(String No){
        return Mapper.getalldetailedbyNo(No);
    }
}
