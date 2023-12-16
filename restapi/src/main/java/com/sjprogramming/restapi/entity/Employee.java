package com.sjprogramming.restapi.entity;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    @Column(name = "ename")
    private String ename;
    @Column(name = "sal")
    private double sal;
    @Column(name = "pfNp")
    private String pfNo;
    @Column(name = "rollNo")
    private String rollNo;
//	private Date dateOfJoining;


}
