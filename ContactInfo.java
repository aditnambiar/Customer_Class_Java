package com.io.cred;

/*
 ContactInfo class
 Contains contact information of customer
*/

import java.sql.Connection;
import java.sql.DriverManager;

public class ContactInfo {
    private int customerID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private int phoneNumber;

    // Setters and Getters for ContactInfo class

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Constructors for ContactInfo class, one default, one with all variables

    public ContactInfo() {
        this.customerID = 1;
        this.firstName = "Aditya";
        this.lastName = "Nambiar";
        this.dateOfBirth = "05/08/1998";
        this.email = "xyz@gmail.com";
        this.phoneNumber = 0;
    }

    public ContactInfo(int customerID, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
