package com.io.cred;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.cred.Customer;
import com.io.cred.Address;
import com.io.cred.ContactInfo;


import java.io.File;
import java.sql.*;

// Code to test out Customer, Address, and ContactInfo class and writeJSON function
public class Main {

    // function to connect to cred database created in postgresSQL
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/CRED_DB",
                "postgres", "123456");
    }

    // Insert ContactInfo into contactinfo table in database
    public long insertCustomerInfo(Customer customer) throws SQLException {
        String SQL = "INSERT INTO contactinfo(id, firstname, lastname, dateofbirth, email, phonenumber) "
                + "VALUES(?,?,?,?,?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            // Retrieve info from class
            pstmt.setInt(1, customer.getContactInfo().getCustomerID());
            pstmt.setString(2, customer.getContactInfo().getFirstName());
            pstmt.setString(3, customer.getContactInfo().getLastName());
            pstmt.setString(4, customer.getContactInfo().getDateOfBirth());
            pstmt.setString(5, customer.getContactInfo().getEmail());
            pstmt.setInt(6, customer.getContactInfo().getPhoneNumber());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong("phonenumber");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;

    }

    // Insert Address into addressinfo table in database
    public long insertAddress(Customer customer) throws SQLException {
        String SQL = "INSERT INTO addressinfo(addressline1, addressline2, city, state, zipcode, id) "
                + "VALUES(?,?,?,?,?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            // Retrieve info from class
            pstmt.setString(1, customer.getAddress().getAddressLine1());
            pstmt.setString(2, customer.getAddress().getAddressLine2());
            pstmt.setString(3, customer.getAddress().getCity());
            pstmt.setString(4, customer.getAddress().getState());
            pstmt.setInt(5, customer.getAddress().getZipCode());
            pstmt.setInt(6, customer.getContactInfo().getCustomerID());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong("zipcode");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;

    }

    // calls both insert functions to insert all relavant data into database
    public void insertCustomer(Customer customer) throws SQLException {
        this.insertCustomerInfo(customer);
        this.insertAddress(customer);
    }

    // delete information in database (both in contactinfo and addressinfo tables) through Customer ID
    public void deleteCustomer(int id) {
        String SQL = "DELETE FROM contactinfo WHERE id = ?";

        int affectedrows = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // update contact info using id
    public void updateContact(int id, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber) {
        String SQL = "UPDATE contactinfo "
                + "SET firstname = ?, "
                + "lastname = ?, "
                + "dateofbirth = ?, "
                + "email = ?, "
                + "phonenumber = ? "
                + "WHERE id = ?";

        int affectedrows = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, dateOfBirth);
            pstmt.setString(4, email);
            pstmt.setInt(5, phoneNumber);
            pstmt.setInt(6, id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // update address info using id
    public void updateAddress(int id, String addressline1, String addressline2, String city, String state, int zipcode) {
        String SQL = "UPDATE addressinfo "
                + "SET addressline1 = ?, "
                + "addressline2 = ?, "
                + "city = ?, "
                + "state = ?, "
                + "zipcode = ? "
                + "WHERE id = ?";

        int affectedrows = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, addressline1);
            pstmt.setString(2, addressline2);
            pstmt.setString(3, city);
            pstmt.setString(4, state);
            pstmt.setInt(5, zipcode);
            pstmt.setInt(6, id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) throws SQLException {

        Main main = new Main();

        Customer customer = new Customer();

        main.insertCustomer(customer);

        main.updateContact(1, "Shreeraj", "Pathare", "06/07/1996", "ashddvhjkfjhvdf", 28384);

    }
}
