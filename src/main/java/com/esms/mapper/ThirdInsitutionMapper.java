package com.esms.mapper;

import com.esms.entity.ThirdInsitution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdInsitutionMapper {
    List<ThirdInsitution> listThirdInsitution();
    ThirdInsitution getThirdInsitution(int ThirdInsitutionNum);
    void addThirdInsitution(ThirdInsitution thirdInsitution);
    void updateThirdInsitution(ThirdInsitution thirdInsitution);
    void deleteThirdInsitution(int ThirdInsitutionNum);
    int getMaxThirdInsitutionId();
}
