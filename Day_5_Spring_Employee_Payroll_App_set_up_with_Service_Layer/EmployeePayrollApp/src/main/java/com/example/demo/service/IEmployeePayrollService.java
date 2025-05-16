package com.example.demo.service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getAll();
    EmployeePayrollData getById(int empId);
    EmployeePayrollData create(EmployeePayrollDTO dto);
    EmployeePayrollData update(int empId, EmployeePayrollDTO dto);
    void delete(int empId);
}