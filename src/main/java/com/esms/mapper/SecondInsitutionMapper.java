package com.esms.mapper;

import com.esms.entity.SecondInsitution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondInsitutionMapper {
    List<SecondInsitution> listSecondInsitution();
    SecondInsitution getSecondInsitution(int secondInsitutionNum);
    void addSecondInsitution(SecondInsitution secondInsitution);
    void updateSecondInsitution(SecondInsitution secondInsitution);
    void deleteSecondInsitution(int secondInsitutionNum);
    List<SecondInsitution> listSecondInsitutionByPrimaryInsitutionNum(Integer primaryInsitutionNum);
}
