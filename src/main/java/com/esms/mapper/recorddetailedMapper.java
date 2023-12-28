package com.esms.mapper;
import org.springframework.stereotype.Repository;
import com.esms.entity.recorddetailed;

import java.util.List;

@Repository
public interface recorddetailedMapper {
    void adddetailed(recorddetailed m);
    List<recorddetailed> getalldetailedbyNo(String No);
}
