package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.utils.DatabaseConnetion;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnetion.getConnection();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection myConn = getConnection();
                Statement myStant = myConn.createStatement();
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
        try (Connection myConn = getConnection();
                PreparedStatement myStand = myConn.prepareStatement("SELECT * FROM employees WHERE id = ?")) {
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
    public void save(Employee employee) throws SQLException {
        String sql;
        if (employee.getId() != null && employee.getId() > 0) {
            sql = "UPDATE employees SET first_name=?, pa_surname=?, ma_surname=?, email=?, salary=? WHERE id=?";
        } else {
            sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary, curp) VALUES (?,?,?,?,?,?)";
        }
        try (Connection myConn = getConnection();
                PreparedStatement myStamt = myConn.prepareStatement(sql)) {
            myStamt.setString(1, employee.getFirst_name());
            myStamt.setString(2, employee.getPa_surname());
            myStamt.setString(3, employee.getMa_surname());
            myStamt.setString(4, employee.getEmail());
            myStamt.setFloat(5, employee.getSalary());
            myStamt.setString(6, employee.getCurp());
            if (employee.getId() != null && employee.getId() > 0) {
                myStamt.setInt(7, employee.getId());
            }
            myStamt.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (getById(id) != null) {
            try (Connection myConn = getConnection();
                    PreparedStatement myStamt = myConn.prepareStatement("DELETE FROM employees WHERE id= ?")) {
                myStamt.setInt(1, id);
                myStamt.executeUpdate();
                System.out.println("Eliminado");
            }
            ;
        } else {
            System.out.println("El empleado no existe");
        }
    }

    private Employee createEmployee(ResultSet myRest) throws SQLException {
        Employee e = new Employee();
        e.setId(myRest.getInt("id"));
        e.setFirst_name(myRest.getString("first_name"));
        e.setPa_surname(myRest.getString("pa_surname"));
        e.setMa_surname(myRest.getString("ma_surname"));
        e.setEmail(myRest.getString("email"));
        e.setSalary(myRest.getFloat("salary"));
        e.setCurp(myRest.getString("curp"));
        return e;
    }

}
