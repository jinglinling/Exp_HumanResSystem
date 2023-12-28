package com.esms.mapper;
import com.esms.entity.list;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface listMapper {
    void addWage(list m);
    void deleteWage(String WageName);
    List<list> getWage();
}
