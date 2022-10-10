package com.csun.csunevent.saiteja.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Component
@Entity
public class Department {

    @GeneratedValue
    public int DepartmentId;
    @Id
    public String departmentName;

}
