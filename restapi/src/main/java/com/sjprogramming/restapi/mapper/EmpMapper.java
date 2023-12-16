package com.sjprogramming.restapi.mapper;

import com.sjprogramming.restapi.dto.EmpDto;
import com.sjprogramming.restapi.entity.Employee;

public class EmpMapper {
    //convert Employee JPA Entity into EmpDto
    public static EmpDto mapToEmpDto(Employee employee){
        EmpDto empDto= new EmpDto(
                employee.getEmpid(),
                employee.getEname(),
                employee.getSal(),
                employee.getPfNo(),
                employee.getRollNo()
        );
        return empDto;
    }
    //convert EmpDto into Employee JPA Entity
    public static Employee mapToEmployee(EmpDto empDto){
        Employee employee=new Employee(
                empDto.getEmpid(),
                empDto.getEname(),
                empDto.getSal(),
                empDto.getPfNo(),
                empDto.getRollNo()
        );
        return employee;
    }
}
