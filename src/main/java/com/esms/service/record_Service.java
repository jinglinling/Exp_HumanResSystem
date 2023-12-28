package com.esms.service;

import com.esms.entity.record_;

import java.util.List;

public interface record_Service {
    void addrecord(record_ m);
    void updaterecord(record_ m);
    void deleterecord(String No);
    List<record_> getallrecord();
}
