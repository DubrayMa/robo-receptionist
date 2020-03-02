package edu.lwtech.csd299.roboreceptionist;

//import java.util.*;

//TODO: Create additional POJO classes
public class Employee {
    
    // Encapsulated member variables
    // TODO: Replace these with your actual member variables

    private String firstName;                 // Database ID (or -1 if it isn't in the database yet)
    private String lastName;            // Name of the item that the POJO is storing
    
    public Employee() {
        
    }
    
    public Employee(String first, String last) {

        if (last == null|| last =="" || first == null || first == "") {
            throw new IllegalArgumentException("Invalid arguments");
        }

        this.firstName = first;
        this.lastName =last;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
