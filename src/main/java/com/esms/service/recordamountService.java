package com.esms.service;

import com.esms.entity.recordamount;

import java.util.List;

public interface recordamountService {
    List<Integer> getallWage(String No);
    List<recordamount> getWagebyid(String No, String Name);
    void addWage(recordamount m);
    void updateWage(recordamount m);
}
