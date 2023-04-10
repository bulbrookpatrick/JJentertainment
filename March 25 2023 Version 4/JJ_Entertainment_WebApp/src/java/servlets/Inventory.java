/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.Service;
import services.EventService;
import services.ServiceService;

/**
 *
 * @author bulbr
 */
@WebServlet(name = "inventory", urlPatterns = {"/inventory"})
public class Inventory extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        String[] months = {
         
            "",
	"January",
	"February",
	"March",
	"April",
	"May",
	"June",
	"July",
	"August",
	"September",
	"October",
	"November",
	"December"

        };
        

     
  ArrayList<LocalDate> dates = new ArrayList<>();
  
  int displayCurrDate = 1;
  
 
  
  String action = request.getParameter("action");

  LocalDate today = LocalDate.now();
          
  int intMonth = 0;
  intMonth = today.getMonthValue();
 request.setAttribute("intMonth", intMonth + 1);
//  add a parameter check for month + year so it doesnt rest when switching months
  if (action != null && action.equals("nextMonth")) {
      displayCurrDate = 0;

      int year = Integer.parseInt(request.getParameter("year"));
      String strMonth = request.getParameter("month");
      
      intMonth = 12;
      for(int i = 1; i < months.length - 1; i++) {
          if (months[i].equals(strMonth)) {
              intMonth = i;
             
          }
          
      }
           request.setAttribute("intMonth", intMonth + 2);
     
      LocalDate prev = LocalDate.of(year, intMonth, 1);
      prev = prev.plusMonths(1);
      today = prev;
  }
  else if (action != null && action.equals("prevMonth")) {
        displayCurrDate = 0;

      int year = Integer.parseInt(request.getParameter("year"));
      String strMonth = request.getParameter("month");
      
       intMonth = 12;
      for(int i = 1; i < months.length - 1; i++) {
          if (months[i].equals(strMonth)) {
              intMonth = i;
              
             
              
          }
          
          
           request.setAttribute("intMonth", intMonth);
     
      LocalDate prev = LocalDate.of(year, intMonth, 1);
      prev = prev.minusMonths(1);
      today = prev;
  }
  }
  
  
  LocalDate dayone = today.withDayOfMonth(1);
  LocalDate lastday = today.withDayOfMonth(today.getMonth().length(today.isLeapYear()));

  
  String weekDay = dayone.getDayOfWeek().toString();

 
  // LocalDate prevDay = lastday.minusMonths(1);
  // LocalDate nextDay = lastday.plusDays(1);

  int startBuffer = 0;
 
  switch(weekDay) {

    case "MONDAY":
    startBuffer = 1;
    break;
    
    case "TUESDAY":
    startBuffer = 2;
    break;

    case "WEDNESDAY":
    startBuffer = 3;
    break;

    case "THURSDAY":
    startBuffer = 4;
    break;
    
    case "FRIDAY":
    startBuffer = 5;
    break;
    
    case "SATURDAY":
    startBuffer = 6;
    break;
  }

  
LocalDate start = dayone.minusDays(startBuffer);

  for(int i = 0; i < 42; i++) {
      
      dates.add(start.plusDays(i));
//    dates.add(start.plusDays(i).getDayOfMonth());
    
  }

  
  String currMonth = today.getMonth().toString().toLowerCase();
  currMonth = currMonth.substring(0, 1).toUpperCase() + currMonth.substring(1);
  
  request.setAttribute("month", currMonth);
  request.setAttribute("year", today.getYear());
  request.setAttribute("dates", dates);
 

//  retrieve events
    ServiceService es = new ServiceService();
    List<Service> events = null;
//    List<Service> prevEvents = null;
//    List<Service> nextEvents = null;
    try {
//        get events from the month and adjacent months JUST SEND EVENTS
// use a sentinel value when reaching th eend of the month, use lastday + 1 day and prevday - 1 day
   events = es.getByMonthYear(intMonth - 1, today.getYear());
   events.addAll((es.getByMonthYear(intMonth, today.getYear())));
   events.addAll((es.getByMonthYear(intMonth + 1, today.getYear())));
   
       }  
    catch(SQLException ex) {
        System.out.println("sql exception");
    }
    
    
    
      
            
            request.setAttribute("events", events);
           
    
            getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/eventCalendar.jsp").forward(request, response);
              System.out.println("hi");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  

        
    }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 

