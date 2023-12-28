package com.esms.service.impl;

import com.esms.service.record_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esms.entity.record_;
import com.esms.mapper.record_Mapper;

import java.util.List;

@Service
public class record_ServiceImpl implements record_Service {
    @Autowired
    private record_Mapper Mapper;
    @Override
   public void addrecord(record_ m){
        Mapper.addrecord(m);
    }
    @Override
   public void updaterecord(record_ m){
       Mapper.updaterecord(m);
   }
    @Override
    public void deleterecord(String No){
        Mapper.deleterecord(No);
    }
    @Override
    public List<record_> getallrecord(){
        return Mapper.getallrecord();
    }
}
