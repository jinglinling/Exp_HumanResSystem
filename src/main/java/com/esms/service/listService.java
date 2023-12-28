package com.esms.service;

import com.esms.entity.list;

import java.util.List;

public interface listService {
    void addWage(list m);
    void deleteWage(String WageName);
    List<list> getWage();
}
