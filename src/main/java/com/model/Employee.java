package com.model;

import java.util.Objects;

public class Employee {
    private Integer id;
    private String first_name;
    private String pa_surname;
    private String ma_surname;
    private String email;
    private Float salary;
    private String curp;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", first_name='" + getFirst_name() + "'" +
                ", pa_surname='" + getPa_surname() + "'" +
                ", ma_surname='" + getMa_surname() + "'" +
                ", email='" + getEmail() + "'" +
                ", salary='" + getSalary() + "'" +
                ", curp='" + getCurp() + "'" +
                "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPa_surname() {
        return this.pa_surname;
    }

    public void setPa_surname(String pa_surname) {
        this.pa_surname = pa_surname;
    }

    public String getMa_surname() {
        return this.ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return this.salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCurp() {
        return this.curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Employee(Integer id, String first_name, String pa_surname, String ma_surname, String email, Float salary,
            String curp) {
        this.id = id;
        this.first_name = first_name;
        this.pa_surname = pa_surname;
        this.ma_surname = ma_surname;
        this.email = email;
        this.salary = salary;
        this.curp = curp;
    }

    public Employee() {
    }

}
