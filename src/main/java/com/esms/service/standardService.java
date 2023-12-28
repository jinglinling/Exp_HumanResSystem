package com.esms.service;

import com.esms.entity.standard;

import java.util.List;

public interface standardService {
    void addstandard(standard m);
    void deletestandard(String m);
    standard getstandardbyNo(String No);
    List<standard> getstandardbykeyword(String keyword);
    List<standard> getstandardbyDate(String before,String after);
    void updatestandard(standard m);
    List<standard> getallstandard();
}
