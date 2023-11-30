package com.esms.mapper;

import com.esms.entity.PrimaryInsitution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaryInsitutionMapper {
    List<PrimaryInsitution> listPrimaryInsitution();
    PrimaryInsitution getPrimaryInsitution(int primaryInsitutionNum);
    void addPrimaryInsitution(PrimaryInsitution primaryInsitution);
    void updatePrimaryInsitution(PrimaryInsitution primaryInsitution);
    void deletePrimaryInsitution(int primaryInsitutionNum);
}
