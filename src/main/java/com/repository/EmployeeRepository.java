package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.model.Employee;
import com.utils.DatabaseConnetion;

public class EmployeeRepository implements Repository<Employee> {
    private Connection getConnection() throws SQLException {
        return DatabaseConnetion.getInstance();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Statement myStant = getConnection().createStatement();
                ResultSet myRest = myStant.executeQuery("SELECT * FROM employees")) {
            while (myRest.next()) {
                Employee e = createEmployee(myRest);
                employees.add(e);
            }
        }
        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try (PreparedStatement myStand = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?")) {
            myStand.setInt(1, id);
            try (ResultSet myRest = myStand.executeQuery()) {
                if (myRest.next()) {
                    employee = createEmployee(myRest);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Employee createEmployee(ResultSet myRest) throws SQLException {
        Employee e = new Employee();
        e.setId(myRest.getInt("id"));
        e.setFirst_name(myRest.getString("first_name"));
        e.setPa_surname(myRest.getString("pa_surname"));
        e.setMa_surname(myRest.getString("ma_surname"));
        e.setEmail(myRest.getString("email"));
        e.setSalary(myRest.getFloat("salary"));
        return e;
    }

}
