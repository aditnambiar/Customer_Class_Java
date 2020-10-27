package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.Customer;

import java.io.File;

// Code to test out Customer class and writeJSON function

public class Main {

    public static void main(String[] args) {
        Customer SampleCust = new Customer(050603, "Aditya", "Nambiar", "00/00/0000", "adityanambiar123@gmail.com", 000000, true, "C456", "Balewadi", "Pune", "Maharashtra", 000000);
        SampleCust.writeJSON();
    }
}
