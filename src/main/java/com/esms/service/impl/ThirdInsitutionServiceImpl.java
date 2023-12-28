package com.esms.service.impl;

import com.esms.entity.ThirdInsitution;
import com.esms.mapper.ThirdInsitutionMapper;
import com.esms.service.ThirdInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdInsitutionServiceImpl implements ThirdInsitutionService {
    @Autowired
    private ThirdInsitutionMapper thirdInsitutionMapper;

    @Override
    public List<ThirdInsitution> listThirdInsitution() {
        return thirdInsitutionMapper.listThirdInsitution();
    }

    @Override
    public ThirdInsitution getThirdInsitution(int thirdInsitutionNum) {
        return thirdInsitutionMapper.getThirdInsitution(thirdInsitutionNum);
    }

    @Override
    public void addThirdInsitution(ThirdInsitution thirdInsitution) {
        thirdInsitutionMapper.addThirdInsitution(thirdInsitution);
    }

    @Override
    public void updateThirdInsitution(ThirdInsitution thirdInsitution) {
        thirdInsitutionMapper.updateThirdInsitution(thirdInsitution);
    }

    @Override
    public void deleteThirdInsitution(int thirdInsitutionNum) {
        thirdInsitutionMapper.deleteThirdInsitution(thirdInsitutionNum);
    }

    @Override
    public int getMaxThirdInsitutionId() {
        return thirdInsitutionMapper.getMaxThirdInsitutionId();
    }
}
