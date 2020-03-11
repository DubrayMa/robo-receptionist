package edu.lwtech.csd299.roboreceptionist;

import java.util.*;

public interface TopTenListDAL {
    public Visits insertVisits(Visits Visit);
    public void deleteVisit(int listID);
    public Visits getVisits(String name);
    public List<Visits> getAllVisits();
    //public List<I> getAllListIDs();
    public void disconnect();
}
