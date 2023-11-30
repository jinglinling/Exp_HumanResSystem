package com.esms.service.impl;

import com.esms.entity.PrimaryInsitution;
import com.esms.mapper.PrimaryInsitutionMapper;
import com.esms.service.PrimaryInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimaryInsitutionServiceImpl implements PrimaryInsitutionService {
    @Autowired
    private PrimaryInsitutionMapper primaryInsitutionMapper;

    @Override
    public List<PrimaryInsitution> listPrimaryInsitution() {
        return primaryInsitutionMapper.listPrimaryInsitution();
    }

    @Override
    public PrimaryInsitution getPrimaryInsitution(int primaryInsitutionNum) {
        return primaryInsitutionMapper.getPrimaryInsitution(primaryInsitutionNum);
    }

    @Override
    public void addPrimaryInsitution(PrimaryInsitution primaryInsitution) {
        primaryInsitutionMapper.addPrimaryInsitution(primaryInsitution);
    }

    @Override
    public void updatePrimaryInsitution(PrimaryInsitution primaryInsitution) {
        primaryInsitutionMapper.updatePrimaryInsitution(primaryInsitution);
    }

    @Override
    public void deletePrimaryInsitution(int primaryInsitutionNum) {
        primaryInsitutionMapper.deletePrimaryInsitution(primaryInsitutionNum);
    }
}
