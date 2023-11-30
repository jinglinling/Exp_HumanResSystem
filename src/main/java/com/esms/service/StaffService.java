package com.esms.service;

import com.esms.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> listStaff();
    Staff getStaff(Long fileNo);
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
    void changeStaff(Staff staff);
    List<Staff> listProcessStaff();
    List<Staff> listDeleteStaff();
    Staff getProcessStaff(Long fileNo);
    Staff getDeleteStaff(Long fileNo);
    Integer getMaxId();
}
