package com.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.repository.Repository;
import com.utils.DatabaseConnetion;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection myConn = DatabaseConnetion.getInstance()) {
            Repository<Employee> repository = new EmployeeRepository();
            System.out.println("Insertando");
            Employee employee = new Employee();
            employee.setId(4);
            employee.setFirst_name("Diego");
            employee.setPa_surname("Pimento");
            employee.setMa_surname("Gutirre");
            employee.setEmail("maicol@g.com");
            employee.setSalary((float) 4000);
            repository.save(employee);

            System.out.println("Mostrando");
            repository.findAll().forEach(System.out::println);
        }
    }

}
