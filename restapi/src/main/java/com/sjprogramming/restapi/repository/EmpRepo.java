package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sjprogramming.restapi.entity.Employee;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
}
