package com.esms.service.impl;

import com.esms.entity.SecondInsitution;
import com.esms.mapper.SecondInsitutionMapper;
import com.esms.service.SecondInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondInsitutionServiceImpl implements SecondInsitutionService {
    @Autowired
    private SecondInsitutionMapper secondInsitutionMapper;

    @Override
    public List<SecondInsitution> listSecondInsitution() {
        return secondInsitutionMapper.listSecondInsitution();
    }

    @Override
    public SecondInsitution getSecondInsitution(int secondInsitutionNum) {
        return secondInsitutionMapper.getSecondInsitution(secondInsitutionNum);
    }

    @Override
    public void addSecondInsitution(SecondInsitution secondInsitution) {
        secondInsitutionMapper.addSecondInsitution(secondInsitution);
    }

    @Override
    public void updateSecondInsitution(SecondInsitution secondInsitution) {
        secondInsitutionMapper.updateSecondInsitution(secondInsitution);
    }

    @Override
    public void deleteSecondInsitution(int secondInsitutionNum) {
        secondInsitutionMapper.deleteSecondInsitution(secondInsitutionNum);
    }

    @Override
    public List<SecondInsitution> listSecondInsitutionByPrimaryInsitutionNum(Integer primaryInsitutionNum) {
        return secondInsitutionMapper.listSecondInsitutionByPrimaryInsitutionNum(primaryInsitutionNum);
    }
}
