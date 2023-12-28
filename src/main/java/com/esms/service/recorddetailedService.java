package com.esms.service;

import com.esms.entity.recorddetailed;

import java.util.List;

public interface recorddetailedService {
    void adddetailed(recorddetailed m);
    List<recorddetailed> getalldetailedbyNo(String No);
}
