package com.esms.service.impl;

import com.esms.service.listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esms.entity.list;
import com.esms.mapper.listMapper;

import java.util.List;

@Service("listServiceImpl")
public class listServiceImpl implements listService {
    @Autowired
    private listMapper Mapper;
    @Override
     public void addWage(list m){
        Mapper.addWage(m);
    }
    @Override
    public void deleteWage(String WageName){
        Mapper.deleteWage(WageName);
    }
    @Override
    public  List<list> getWage(){
        return Mapper.getWage();
    }
}
