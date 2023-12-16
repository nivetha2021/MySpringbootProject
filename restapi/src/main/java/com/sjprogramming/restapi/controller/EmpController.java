package com.sjprogramming.restapi.controller;

import com.sjprogramming.restapi.dto.EmpDto;
import com.sjprogramming.restapi.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmpController {
    @Autowired
    private EmpService empService;
    // build get All Employee REST API
//http://localhost:8080/api/employee
    @GetMapping
    public ResponseEntity<List<EmpDto>> getAllEmployees(){
        List<EmpDto> employee=empService.getAllEmployees();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
//get an employee detail
    @GetMapping("/{empid}")
    public ResponseEntity<EmpDto> getEmployeeById(@PathVariable ("empid") Integer empid) {
        EmpDto employee = empService.getEmployeeById(empid);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
// save an employee detail
    @PostMapping("/add")
    public ResponseEntity<EmpDto> saveEmployee(@RequestBody EmpDto empDto){
        EmpDto savedEmployee=empService.saveEmployee(empDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
//update an employee detail
   @PutMapping("/{empid}")
    public ResponseEntity<EmpDto> updateEmployee(@PathVariable int empid, @RequestBody EmpDto employee){
        employee.setEmpid(empid);
        EmpDto updatedEmployee=empService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

    }
//delete an employee detail
    @DeleteMapping("/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empid){
       empService.deleteEmployee(empid);
       return new ResponseEntity<>("Employee Deleted Successfully!..", HttpStatus.OK);
   }
//delete all employee
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee(){
        empService.deleteAllEmployee();
        return new ResponseEntity<>("Deleted all Employee..",HttpStatus.OK);
}

}
/* save details
id deleting
updating data
search details
findall, findbyid
 */