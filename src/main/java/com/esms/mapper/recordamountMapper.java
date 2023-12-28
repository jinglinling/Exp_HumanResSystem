package com.esms.mapper;
import com.esms.entity.recordamount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface recordamountMapper {
     List<Integer>getallWage(String No);
     List<recordamount> getWagebyid(@Param("No") String No, @Param("Name") String Name);
     void addWage(recordamount m);
     void updateWage(recordamount m);
}
