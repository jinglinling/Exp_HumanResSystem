package com.esms.service;

import com.esms.entity.ThirdInsitution;

import java.util.List;

public interface ThirdInsitutionService {
    List<ThirdInsitution> listThirdInsitution();
    ThirdInsitution getThirdInsitution(int thirdInsitutionNum);
    void addThirdInsitution(ThirdInsitution thirdInsitution);
    void updateThirdInsitution(ThirdInsitution thirdInsitution);
    void deleteThirdInsitution(int thirdInsitutionNum);
    int getMaxThirdInsitutionId();
}
