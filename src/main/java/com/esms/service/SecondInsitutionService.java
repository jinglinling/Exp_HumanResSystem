package com.esms.service;

import com.esms.entity.SecondInsitution;

import java.util.List;

public interface SecondInsitutionService {
    List<SecondInsitution> listSecondInsitution();
    SecondInsitution getSecondInsitution(int secondInsitutionNum);
    void addSecondInsitution(SecondInsitution secondInsitution);
    void updateSecondInsitution(SecondInsitution secondInsitution);
    void deleteSecondInsitution(int secondInsitutionNum);
    List<SecondInsitution> listSecondInsitutionByPrimaryInsitutionNum(Integer primaryInsitutionNum);
}
