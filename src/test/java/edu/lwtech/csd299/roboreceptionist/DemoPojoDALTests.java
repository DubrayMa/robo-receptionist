package edu.lwtech.csd299.roboreceptionist;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

//TODO: Update DAL Unit Tests
public class DemoPojoDALTests {

    DemoPojo thirdItem;

    // Note: Cannot use @Before since we're testing a static class
    public void setUp() {
        DemoPojoDAL.reset();

        DemoPojoDAL.insertItem(new DemoPojo("Test Item 1"));
        DemoPojoDAL.insertItem(new DemoPojo("Test Item 2"));
        thirdItem = new DemoPojo("Test Item 3");
    }

    @Test
    public void resetTest() {
        setUp();
        DemoPojoDAL.reset();
        assertEquals(0, DemoPojoDAL.getNumItems());
    }

    @Test
    public void insertDemoPojoTest() {
        setUp();
        DemoPojoDAL.insertItem(thirdItem);
        assertEquals(3, DemoPojoDAL.getNumItems());
    }
    
    @Test
    public void getDemoPojoTest() {
        setUp();
        DemoPojo item = DemoPojoDAL.getItem(0);
        assertEquals(1000, item.getId());
        item = DemoPojoDAL.getItem(1);
        assertEquals(1001, item.getId());
    }
    
    @Test
    public void getAllDemoPojosTest() {
        setUp();

        List<DemoPojo> allItems = new ArrayList<>();
        allItems = DemoPojoDAL.getAllItems();
        assertEquals(2, allItems.size());
    }    
    
    @Test
    public void getNumItemsTest() {
        DemoPojoDAL.reset();
        assertEquals(0, DemoPojoDAL.getNumItems());
        setUp();
        assertEquals(2, DemoPojoDAL.getNumItems());
        DemoPojoDAL.insertItem(thirdItem);
        assertEquals(3, DemoPojoDAL.getNumItems());
    }
    
    @Test
    public void getFirstItemIDTest() {
        setUp();
        assertEquals(1000, DemoPojoDAL.getFirstItemID());
    }
    
    @Test
    public void generateNextItemIDTest() {
        setUp();
        assertEquals(1002, DemoPojoDAL.generateNextItemID());
    }
    
}
