package edu.lwtech.csd299.roboreceptionist;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.log4j.*;
import freemarker.core.*;
import freemarker.template.*;

@WebServlet(name = "RoboReceptionistServlet", urlPatterns = {"/servlet"}, loadOnStartup = 0)
public class RoboReceptionistServlet extends HttpServlet {

    private static final long serialVersionUID = 2020111122223333L;
    private static final Logger logger = Logger.getLogger(RoboReceptionistServlet.class);

    private static final String TEMPLATE_DIR = "/WEB-INF/classes/templates";
    private static final Configuration freemarker = new Configuration(Configuration.getVersion());

    private static final boolean USE_SQL = false;
    private static VisitsSqlDAL dal = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //connect to database
        logger.warn("=========================================");
        logger.warn("RoboReceptionistServlet init() started");
        logger.warn("http://localhost:8080/roboreceptionist/servlet");
        logger.warn("=========================================");

        logger.info("Getting real path for templateDir");
        String templateDir = config.getServletContext().getRealPath(TEMPLATE_DIR);
        logger.info("...real path is: " + templateDir);
        
        logger.info("Initializing Freemarker. templateDir = " + templateDir);
        try {
            freemarker.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            logger.error("Template directory not found in directory: " + templateDir, e);
        }
        logger.info("Successfully Loaded Freemarker");
        
        addDemoData();
        try
        {   
            //for when we implement functions
            //dal = USE_SQL ? initSqlDAL() : initMemoryDAL();
            dal = initSqlDAL();

        }catch(Exception e)
        { 
            logger.error("cannot connect to database (name)", e);
        }   

        logger.warn("Initialize complete!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("IN - GET " + request.getRequestURI());
        long startTime = System.currentTimeMillis();

        String command = request.getParameter("cmd");
        if (command == null) command = "showHome";//"show";

        String template = "";
        Map<String, Object> model = new HashMap<>();

        //TODO: Add more URL commands to the servlet
        switch (command) {
            case "showHome":
                //show Home page (home.tpl)
                
                template = "home.tpl";
                break;
            case "showGuest":
                //show guest page (guest.tpl)
                template = "guest.tpl";
                break;
            case "showDelivery":
                //show delivery page (delivery.tpl)
                
                template = "delivery.tpl";
                break; 
            case "showAdmin":
                //show delivery page (delivery.tpl)
                
                template = "admin.tpl";
                break; 
            default:
                logger.debug("Unknown GET command received: " + command);

                // Send 404 error response
                try {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                } catch (IOException e)  {
                    logger.error("IO Error: ", e);
                }
                return;
        }
        processTemplate(response, template, model);

        long time = System.currentTimeMillis() - startTime;
        logger.info("OUT- GET " + request.getRequestURI() + " " + time + "ms");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("IN -POST " + request.getRequestURI());
        long startTime = System.currentTimeMillis();
        
        String command = request.getParameter("cmd");
        if (command == null) command = "";

        String confirmationMessage = "";
        String template = "confirmationPage.tpl";
        Map<String, Object> model = new HashMap<>();
        Visits visits;
        switch (command) {
            case "submitGuest":

                visits = getVisitsFromRequestVisits(request);
                dal.insertVisits(visits);
                
                emailFormatLog(visits);
                confirmationMessage = "success! you're sign in has been logged and employee has been notified.";
                break;
            case "deliveryPerson":
                String company = request.getParameter("company");
                String message = "your package has arrived please come and get it from: ";

                visits = new Visits("Recpetionist","john Doe",company,message);
                dal.insertVisits(visits);

                //alert/email receptionist
                
                emailFormatLog(visits);
                confirmationMessage = "success! you're sign in has been logged and employee has been notified.";
                break;  

            default:
                logger.info("Unknown POST command received: " + command);

                // Send 404 error response
                try {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                } catch (IOException e)  {
                    logger.error("IO Error: ", e);
                }
                return;
        }

        model.put("confirmationMessage", confirmationMessage);
        
        processTemplate(response, template, model);

        long time = System.currentTimeMillis() - startTime;
        logger.info("OUT- GET " + request.getRequestURI() + " " + time + "ms");
    }
    
    @Override
    public void destroy() {
        //disconnect from database
        try 
        {
            logger.info("Disconnecting from the database.");
            //when we add disconnect function
            dal.disconnect();
            logger.info("Disconneced!");
        } 
        catch (Exception e)
        {
            logger.error("could not disconnect from database", e);
        }
        logger.warn("-----------------------------------------");
        logger.warn("  RoboReceptionistServlet destroy() completed");
        logger.warn("-----------------------------------------");
    }

    @Override
    public String getServletInfo() {
        return "robo-receptionist Servlet";
    }

    // ========================================================================
    //for when we add the constructors in the DAL
    /*private VisitsDAL initMemoryDAL() throws ServletException {
        return new VisitsDAL(null);
    }*/

    private VisitsSqlDAL initSqlDAL() throws ServletException {
        logger.info("Connecting to the database...");

        String jdbcDriver = "org.mariadb.jdbc.Driver";          // Use MariaDB driver in case we connect to a cloud DB
        String connString = "jdbc:mariadb://";
        connString += "localhost:3306";
        connString += "/roboreceptionist";
        connString += "?user=root&password=lwtech";             //TODO: Remove these credentials from the source code 

        Connection conn = SQLUtils.connect(connString, jdbcDriver);
        if (conn == null) {
            logger.error("Unable to connect to SQL Database with JDBC string: " + connString);
            throw new UnavailableException("Unable to connect to database.");
        }
        logger.info("...connected!");

        return new VisitsSqlDAL(conn);
    }

    private void processTemplate(HttpServletResponse response, String template, Map<String, Object> model) {
        logger.debug("Processing Template: " + template);
        
        try (PrintWriter out = response.getWriter()) {
            Template view = freemarker.getTemplate(template);
            view.process(model, out);
        } catch (TemplateException | MalformedTemplateNameException | ParseException e) {
            logger.error("Template Error: ", e);
        } catch (IOException e) {
            logger.error("IO Error: ", e);
        } 
    }    

    private void addDemoData() {
        logger.debug("Creating sample DemoPojos...");
        
        //guest name
        DemoPojoDAL.insertItem(new DemoPojo("Item I"));
        //employee name
        DemoPojoDAL.insertItem(new DemoPojo("Item II"));
        //message
        DemoPojoDAL.insertItem(new DemoPojo("Item III"));
        
        logger.info("...items inserted");
    }
    private void emailFormatLog(Visits visit)
    {
        logger.info("-----------------------------------------");
        logger.info("sent to: " + visit.getEmployee() + "@company.com");
        logger.info("sent from: " + visit.getGuestName());
        logger.info(visit.getMessage());
        logger.info("-----------------------------------------");
    }

    private Visits getVisitsFromRequestVisits(HttpServletRequest request)
    {
        Visits visits;
        String employeeName = request.getParameter("employee");
        String guestName = request.getParameter("guest");
        String company = "notACompany";//request.getParameter("company");
        String message = request.getParameter("message");
        if(company != "")
        {
            visits = new Visits(employeeName,guestName,company, message);
        }
        else 
        {
            visits = new Visits(employeeName,guestName,company, message);
        }
        return visits;
    }
}
