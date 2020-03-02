package edu.lwtech.csd299.roboreceptionist;

import java.util.*;

//TODO: Create additional POJO classes
public class Visits {
    
    // Encapsulated member variables
    // TODO: Replace these with your actual member variables
    private Employee emp;                 // Database ID (or -1 if it isn't in the database yet)
    private String guest;            // Name of the item that the POJO is storing
    private String company;
    private Date time;
    public Visits() {
        
    }
    
    public Visits(Employee empl, String guest, String company) {
        this.emp = empl;
        this.guest = guest;
        this.company = company;
        time = new Date();
    }



    public Employee getEmployee(){
        return emp;
    }
    public String getEmployeeName() {
        return emp.toString();
    }

    public String getGuestName() {
        return guest;
    }

    public String getCompany() {
        return company;
    }

    public String getTime() {
        return time.toString();
    }



}
