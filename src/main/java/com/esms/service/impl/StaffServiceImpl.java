package com.esms.service.impl;

import com.esms.entity.Staff;
import com.esms.mapper.StaffMapper;
import com.esms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> listStaff() {
        return staffMapper.listStaff();
    }

    @Override
    public Staff getStaff(Long fileNo) {
        return staffMapper.getStaff(fileNo);
    }

    @Override
    public void addStaff(Staff staff) {
        staffMapper.addStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    @Override
    public void changeStaff(Staff staff) {
        staffMapper.changeStaff(staff);
    }

    @Override
    public List<Staff> listProcessStaff() {
        return staffMapper.listProcessStaff();
    }

    @Override
    public List<Staff> listDeleteStaff() {
        return staffMapper.listDeleteStaff();
    }

    @Override
    public Staff getProcessStaff(Long fileNo) {
        return staffMapper.getProcessStaff(fileNo);
    }

    @Override
    public Staff getDeleteStaff(Long fileNo) {
        return staffMapper.getDeleteStaff(fileNo);
    }

    @Override
    public Integer getMaxId() {
        Integer maxId = staffMapper.getMaxId();
        return maxId != null ? maxId : 0;
    }
}
