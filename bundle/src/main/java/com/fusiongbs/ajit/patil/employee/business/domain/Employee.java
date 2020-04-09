package com.fusiongbs.ajit.patil.employee.business.domain;

public class Employee {

    public String employeeId;
    public String fullName;
    public String id;

    public Employee (String employeeId, String fullName, String id){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.id = id;
    }

    public Employee (){
    }

    public String getEmployeeId (){
        return employeeId;
    }

    public void setEmployeeId (String employeeId){
        this.employeeId = employeeId;
    }

    public String getFullName (){
        return fullName;
    }

    public void setFullName (String fullName){
        this.fullName = fullName;
    }

    public String getId (){
        return id;
    }

    public void setId (String id){
        this.id = id;
    }
}
