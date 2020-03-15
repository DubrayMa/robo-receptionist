package edu.lwtech.csd299.roboreceptionist;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

 public class VisitsSqlDAL {
    
    private static final Logger logger = Logger.getLogger(VisitsSqlDAL.class.getName());

    private Connection conn = null;
    
    public VisitsSqlDAL(Connection conn) {
        this.conn = conn;
    }

    public Visits insertVisits (Visits Visit) {
        logger.debug("Inserting " + Visit + "...");

        // if (list.getID() != -1) {
        //     logger.error("Attempting to add previously added TopTenList: " + list);
        //     return null;
        // }

        String query = "INSERT INTO Visits";
        query += " (guest, company, message, employee, time)";
        //query += " VALUES ("+ Visit.getGuestName()+", "+ Visit.getCompany()+", "+ Visit.getMessage()+
        //", NOW(), " + Visit.getEmployee()+")";
        query += " VALUES (?,?,?,?,?)";

        //List<String> items = list.getItems();

        java.sql.Timestamp timee = new java.sql.Timestamp(Visit.getVisitTime().getTime()); 

        //int listID = SQLUtils.executeSQLInsert(conn, query, "listID", 1, Visit.getGuestName(),
        //Visit.getCompany(),Visit.getMessage(),timee, Visit.getEmployee());

        int listID = SQLUtils.executeSQLInsert(conn, query, "listID",
        timee,Visit.getGuestName(), Visit.getCompany(), Visit.getMessage(),Visit.getEmployee());
        
        logger.debug("Visit successfully inserted with listID = " + listID);

        return new Visits(Visit.getEmployee(), Visit.getGuestName(), Visit.getCompany(), Visit.getMessage());
    }

    public void deleteVisit(int ID) {
        logger.debug("Trying to delete Visit with index: " + ID);

        String query = "DELETE FROM Visits WHERE visitID=" + ID;
        SQLUtils.executeSQL(conn, query);
    }
    
    public Visits getVisit(String name) {
        logger.debug("Trying to get TopTenList with index: " + name);
        
        String query = "SELECT *";
        query += " FROM Visits WHERE guest =" + name + "OR employee = " + name;

        List<SQLRow> rows = SQLUtils.executeSQL(conn, query);
        
        if (rows != null) {
            logger.debug("Found Visit!");
        } else {
            logger.debug("Did not find Visit.");
            return null;
        }
        
        SQLRow row = rows.get(0);

        return convertRowToVisit(row);
    }
    
    public List<Visits> getAllVisits() {
        logger.debug("Getting all TopTenLists...");
        
        String query = "SELECT *";
        //query += " item1, item2, item3, item4, item5, item6, item7, item8, item9, item10";
        query += " FROM Visits ORDER BY visitID";

        List<SQLRow> rows = SQLUtils.executeSQL(conn, query);
        
        if (rows == null) {
            logger.debug("No lists found!");
            return null;
        }
       
        List<Visits> lists = new ArrayList<>();
        for (SQLRow row : rows) {
            //TopTenList toptenlist = convertRowToList(row);
            Visits visit = convertRowToVisit(row);
            lists.add(visit);
        }
        return lists;
    }
    
    // public List<Integer> getAllListIDs() {
    //     logger.debug("Getting List IDs...");

    //     String query = "SELECT listID FROM TopTenLists ORDER BY listID";

    //     List<SQLRow> rows = SQLUtils.executeSQL(conn, query);
        
    //     if (rows == null) {
    //         logger.debug("No lists found!");
    //         return null;
    //     }
        
    //     List<Integer> listIDs = new ArrayList<>();
    //     for (SQLRow row : rows) {ssssss
    //         String value = row.getItem("listID");
    //         int i = Integer.parseInt(value);
    //         listIDs.add(i);
    //     }
    //     return listIDs;
    // }

    public void disconnect() {
        SQLUtils.disconnect(conn);
        conn = null;
    }
    

    // =====================================================================

    private Visits convertRowToVisit(SQLRow row) {
        // List<String> items = new ArrayList<>();
        // int listID = Integer.parseInt(row.getItem("listID"));
        // String title = row.getItem("title");
        // for (int i=1; i <= 10; i++)
        //     items.add(row.getItem("item"+i));
        
        Visits res = new Visits(row.getItem("employee"), row.getItem("guest"), row.getItem("company")
        , row.getItem("message"));
        return res;//new TopTenList(listID, title, items);
    }

}
