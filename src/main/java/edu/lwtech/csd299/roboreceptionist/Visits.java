package edu.lwtech.csd299.roboreceptionist;

import java.util.*;

//TODO: Create additional POJO classes
public class Visits {
    
    // Encapsulated member variables
    // TODO: Replace these with your actual member variables
    private String emp;                 // Database ID (or -1 if it isn't in the database yet)
    private String guest;            // Name of the item that the POJO is storing
    private String company;
    private Date time;
    private String message;
    public Visits() {
        
    }
    
    
    public Visits(String empl, String guest, String company, String message) {
        this.emp = empl;
        this.guest = guest;
        this.company = company;
        time = new Date();
        this.message = message;
    }

    // public Visits(String empl, String guest, String company){
    //     this(empl, guest, company, "");
    // }

    // incase team wants to make company optional instead of message 
    // public Visits(Employee empl, String guest, String message){
    //     this(empl, guest, "" , message);
    // }

    public String getMessage(){
        return message;
    }
    public String getEmployee(){
        return emp;
    }
    // public String getEmployeeName() {
    //     return emp.toString();
    // }

    public String getGuestName() {
        return guest;
    }

    public String getCompany() {
        return company;
    }

    public Date getVisitTime() {
        return time;
    }



}
