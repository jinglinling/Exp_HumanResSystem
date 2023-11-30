package com.esms.mapper;

import com.esms.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {
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
