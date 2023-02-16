/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Event;
import models.Service;
import services.EventService;

/**
 *
 * @author Patrick
 */
public class EventServlet extends HttpServlet {
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
             getServletContext().getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
             String action = request.getParameter("action");
      
              EventService es = new EventService();

  
        Event event = new Event();
        Service service = new Service();
        Category category = new Category();
  
        double cost = 0.00;
        String sDate1 =  request.getParameter("date");
        Date start = new Date();
        try {
            start = new SimpleDateFormat("dd/mm/yyyy").parse(sDate1);
        } catch (ParseException ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        event.setStart(start);
        event.setEnd(start);
        String address = request.getParameter("address") + " "
                +  request.getParameter("city") +
                 " " + request.getParameter("province");
        event.setLocation(address);
        
        event.setStatus(1);
        
        String balloons = request.getParameter("balloons");
        String mascot = request.getParameter("mascot");
        String photo = request.getParameter("photography");
        String booth = request.getParameter("photobooth");
        String face = request.getParameter("facepainting");
        String henna = request.getParameter("henna");
        //make category desc contingent on name
        if (balloons != null) {
            category.setName("balloons");
            cost += 100;
        }
            
        else if (mascot != null) {
            category.setName("mascot");
            cost += 100;
        }
        else if (photo != null) {
            category.setName("photography");
            cost += 100;
        }
        else if (booth != null) {
            category.setName("photobooth");
            cost += 100;
        }
        else if (face != null) {
            category.setName("facepainting");
            cost += 100;

        }
        else if (henna != null) {
            category.setName("henna");
            cost += 100;
        }
        else {
            request.setAttribute("message", "no event type selected");
        }
        
        event.setCost(cost);
        event.setInterest(0);
        try {
            es.insert(event.getStart(), event.getEnd(), event.getLocation(), event.getStatus(), event.getInterest(), event.getCost());
           request.setAttribute("message", "event added");

            
        }
        catch (Exception ex) {
            request.setAttribute("message", "error adding event");
        }
        
                    getServletContext().getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);

        
           
       }
        

    }



