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

    private static Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //connect to database
        logger.warn("=========================================");
        logger.warn("  RoboReceptionistServlet init() started");
        logger.warn("    http://localhost:8080/roboreceptionist/servlet");
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
            
            Class.forName("com.mysql.jdbc.Driver"); 
            
            //here _____ is database name, port #3306,  root is username and password is lwtech 
            con = DriverManager.getConnection("jdbc:mysql://(whatever we connect to):3306/(name of database)","root","lwtech");  
                
            /* these are template statment and result set for query that could be in the dal
             *
             * Statement stmt=con.createStatement();  
             * ResultSet rs = stmt.executeQuery("query");  
             * 
             */

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
        if (command == null) command = "show";

        String template = "";
        Map<String, Object> model = new HashMap<>();

        //TODO: Add more URL commands to the servlet
        switch (command) {

            case "show":
                String indexParam = request.getParameter("index");
                int index = (indexParam == null) ? 0 : Integer.parseInt(indexParam);
                int numItems = DemoPojoDAL.getNumItems();
                int nextIndex = (index + 1) % numItems;
                int prevIndex = index - 1;
                if (prevIndex < 0) prevIndex = numItems-1;

                template = "show.tpl";
                model.put("item", DemoPojoDAL.getItem(index));
                model.put("prevIndex", prevIndex);
                model.put("nextIndex", nextIndex);
                break;
            case "Home":
                //show Home page (home.tpl)
                break;
            case "Guest":
                //show guest page (guest.tpl)
                break;
            case "Delivery":
                //show delivery page (delivery.tpl)
                break;  
            case "Cancel":
                //guest/delivery user decides this was the wrong company and cancels the form (home.tpl)
                break; 
            case "DeliveryType":
                //will dictate where a delivery order email is sent to
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
        String template = "confirmation.tpl";
        Map<String, Object> model = new HashMap<>();
        
        switch (command) {
            case "Message":

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

            con.close();

        } catch (Exception e)
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
    private void emailFormatLog(String employeeEmail, String guestName, String message)
    {
        
    }

}
