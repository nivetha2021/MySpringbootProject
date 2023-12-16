package com.sjprogramming.restapi.service.impl;

import com.sjprogramming.restapi.dto.EmpDto;
import com.sjprogramming.restapi.entity.Employee;
import com.sjprogramming.restapi.mapper.EmpMapper;
import com.sjprogramming.restapi.repository.EmpRepo;
import com.sjprogramming.restapi.service.EmpService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmpService {
    @Autowired
    private EmpRepo empRepo;

    @Override
    public List<EmpDto> getAllEmployees() {
        List<Employee> employee=empRepo.findAll();
        return employee.stream().map(EmpMapper :: mapToEmpDto)
                .collect(Collectors.toList());
    }
    @Override
    public EmpDto getEmployeeById(Integer empid){
        Optional<Employee> optionalEmployee=empRepo.findById(empid);
        Employee employee= optionalEmployee.get();
        return EmpMapper.mapToEmpDto(employee);
    }
    @Override
    public EmpDto saveEmployee(EmpDto empDto){
        // convert EmpDto into Employee JPA Entity
        Employee employee= EmpMapper.mapToEmployee(empDto);
        Employee savedEmployee=empRepo.save(employee);
        // convert Employee JPA Entity to EmpDto
        EmpDto savedEmpDto= EmpMapper.mapToEmpDto(savedEmployee);
        return savedEmpDto;
    }
    @Override
    public EmpDto updateEmployee(EmpDto employee){
        Employee existingEmployee=empRepo.findById(employee.getEmpid()).get();
        existingEmployee.setEname(employee.getEname());
        existingEmployee.setSal(employee.getSal());
        existingEmployee.setPfNo(employee.getPfNo());
        existingEmployee.setRollNo(employee.getRollNo());
        Employee updatedEmployee=empRepo.save(existingEmployee);
        return EmpMapper.mapToEmpDto(updatedEmployee);
    }


    @Override
    public void deleteEmployee(Integer empid){

        empRepo.deleteById(empid);
    }
    @Override
    public void deleteAllEmployee(){

        empRepo.deleteAll();
    }

}
