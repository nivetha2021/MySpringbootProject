package com.sjprogramming.restapi.service;

import com.sjprogramming.restapi.dto.EmpDto;

import java.util.List;

public interface EmpService {
    List<EmpDto> getAllEmployees();
    EmpDto getEmployeeById(Integer empid);
    EmpDto saveEmployee(EmpDto empDto);
    EmpDto updateEmployee(EmpDto empDto);
    void deleteEmployee(Integer empid);
    void deleteAllEmployee();


}
