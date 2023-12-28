package com.esms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esms.service.standardService;
import com.esms.entity.standard;
import com.esms.mapper.standardMapper;

import java.util.List;

@Service
public class standardServiceImpl implements standardService {
    @Autowired
    private standardMapper Mapper;
    @Override
    public void addstandard(standard m){
        Mapper.addstandard(m);
    }
    @Override
    public void deletestandard(String m){
        Mapper.deletestandard(m);
    }
    @Override
    public standard getstandardbyNo(String No){
        return Mapper.getstandardbyNo(No);
    }
    @Override
    public List<standard> getstandardbykeyword(String keyword){
        return Mapper.getstandardbykeyword(keyword);
    }
    @Override
    public List<standard> getstandardbyDate(String before,String after){
        return Mapper.getstandardbyDate(before,after);
    }
    @Override
    public void updatestandard(standard m){
        Mapper.updatestandard(m);
    }
    @Override
    public List<standard> getallstandard(){
       return Mapper.getallstandard();
    }
}
