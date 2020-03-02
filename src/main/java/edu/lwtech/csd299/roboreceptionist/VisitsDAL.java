package edu.lwtech.csd299.roboreceptionist;

import java.util.*;

import org.apache.log4j.Logger;

//TODO: Create additional DAL classes for additional POJO classes
public class VisitsDAL {
    
    private static final Logger logger = Logger.getLogger(DemoPojoDAL.class.getName());
    
    private static int nextId = 1000;
    private static List<Visits> memoryDB = new ArrayList<>();
    
    public static void reset() {
        nextId = 1000;
        memoryDB = new ArrayList<>();
    }

    public static boolean insertItem(Visits item) {
        logger.debug("Inserting " + item + "...");

        if (item.getEmployee() == null) {
            logger.error("Adding null visit: " + item);
            return false;
        }
        
        // item = new DemoPojo(generateNextItemID(), item.getName());
        memoryDB.add(item);
        
        logger.debug("Item successfully inserted!");
        return true;
    }
    
    public static Visits getItem(int index) {
        logger.debug("Trying to get item with index: " + index);
        
        Visits item = memoryDB.get(index);
        
        if (item != null) {
            logger.debug("Found item!");
        } else {
            logger.debug("Did not find item.");
        }
        
        return item;
    }
    
    public static List<Visits> getAllItems() {
        logger.debug("Getting all items");
        return new ArrayList<>(memoryDB);
    }    
    
    public static int getNumItems() {
        return memoryDB.size();
    }
    
    // public static int getFirstItemID() {
    //     Visits item = memoryDB.get(0);
    //     return item.getId();
    // }
    
    public static synchronized int generateNextItemID() {
        return nextId++;
    }
}
