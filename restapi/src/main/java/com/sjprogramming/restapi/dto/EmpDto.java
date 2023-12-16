package com.sjprogramming.restapi.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
    private int empid;
    private String ename;
    private double sal;
    private String pfNo;
    private String rollNo;
}