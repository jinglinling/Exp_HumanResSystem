package com.esms.service;

import com.esms.entity.PrimaryInsitution;

import java.util.List;

public interface PrimaryInsitutionService {
    List<PrimaryInsitution> listPrimaryInsitution();
    PrimaryInsitution getPrimaryInsitution(int primaryInsitutionNum);
    void addPrimaryInsitution(PrimaryInsitution primaryInsitution);
    void updatePrimaryInsitution(PrimaryInsitution primaryInsitution);
    void deletePrimaryInsitution(int primaryInsitutionNum);
}
