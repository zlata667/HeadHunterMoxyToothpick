package com.example.headhunter.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vacancy{

    private String description;
    private SalaryBean salary;
    private String name;
    private EmployerBean employer;

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public SalaryBean getSalary(){
        return salary;
    }

    public void setSalary(SalaryBean salary){
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public EmployerBean getEmployer(){
        return employer;
    }

    public void setEmployer(EmployerBean employer){
        this.employer = employer;
    }

    public static class SalaryBean{

        private int from;
        private String currency;

        public int getFrom(){
            return from;
        }

        public void setFrom(int from){
            this.from = from;
        }

        public String getCurrency(){
            return currency;
        }

        public void setCurrency(String currency){
            this.currency = currency;
        }
    }

    public static class EmployerBean{

        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
