package com.io.cred;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;


/*
 Customer class
 Customer object has customer information and contact details
*/

public class Customer {

    private ContactInfo contactInfo;
    private boolean active;
    private Address address;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //constructors, one default, and one for all variables

    public Customer() {
        this.contactInfo = new ContactInfo();
        this.active = true;
        this.address = new Address();
    }

    public Customer(ContactInfo contactInfo, boolean active, Address address) {
        this.contactInfo = contactInfo;
        this.active = active;
        this.address = address;
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

    /*
    Insert into CustomerInfo table function
    Takes Customer Object and inserts the ContactInfo object information into relavant table in PostgreSQL Database
     */
    public void insertIntoDB(){

    }

}
