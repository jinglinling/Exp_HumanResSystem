package com.esms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class standard {
    private String StandardName;
    private String StandardNo;
    private String Date;
    private String Registrant;
    private int Total;
    private int Check;
    private int PrimaryWage;
    private String Creator;
}
