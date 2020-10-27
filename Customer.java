package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/*
 Customer class
 Customer object has customer information and contact details
*/

public class Customer {

    // customer information
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String DOB;
    private String Email;
    private int PhoneNumber;
    private boolean Active;

    // customer contact details
    private String AddressLine1;
    private String AddressLine2;
    private String City;
    private String State;
    private int ZipCode;

    //constructors, one default, and one for all info
    public Customer() {
        this.CustomerID = 0;
        this.FirstName = "John";
        this.LastName = "Doe";
        this.DOB = "00/00/0000";
        this.Email = "JohnDoe@gmail.com";
        this.PhoneNumber = 0;
        this.Active = true;

        this.AddressLine1 = "Pune";
        this.AddressLine2 = "Yup, definitely Pune";
        this.City = "Pune";
        this.State = "Maharashtra";
        this.ZipCode = 0;
    }

    public Customer(int customerID, String firstName, String lastName, String DOB, String email, int phoneNumber, boolean active, String addressLine1, String addressLine2, String city, String state, int zipCode) {
        CustomerID = customerID;
        FirstName = firstName;
        LastName = lastName;
        this.DOB = DOB;
        Email = email;
        PhoneNumber = phoneNumber;
        Active = active;
        AddressLine1 = addressLine1;
        AddressLine2 = addressLine2;
        City = city;
        State = state;
        ZipCode = zipCode;
    }

    /*
    JSON print function
    Created "customer.json" file with JSON formatted customer object
    Calls ObjectMapper function writeValue
    */
    public void writeJSON() {
        ObjectMapper OM = new ObjectMapper();
        OM.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            OM.writeValue(new File("customer.json"), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
