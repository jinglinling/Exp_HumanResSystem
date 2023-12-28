package com.esms.mapper;
import com.esms.entity.record_;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface record_Mapper {
    void addrecord(record_ m);
    void updaterecord(record_ m);
    void deleterecord(String No);
    List<record_> getallrecord();

}
