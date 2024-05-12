package com.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.repository.Repository;
import com.utils.DatabaseConnetion;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Listar todos");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);
    }

}
