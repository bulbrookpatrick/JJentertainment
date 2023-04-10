package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CategoryQuantity;
import models.User;
import models.Event;
import models.Service;
import models.ServiceCategory;
import services.UserService;
import services.EventService;
import services.ServiceService;

public class OrderSummary extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/ordersum.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        String username = (String) session.getAttribute("username");
        String startDate = (String) session.getAttribute("eventStartDate");
        String endDate = (String) session.getAttribute("eventEndDate");
        String venue = (String) session.getAttribute("eventVenue");
        int status = 0;
        Double interest = (Double) session.getAttribute("eventInterest");
        Double resCost = (Double) session.getAttribute("eventResCost");
        Double eventPrice = (Double) session.getAttribute("eventSerPrice");
        Double total = interest + eventPrice + resCost;
        EventService es = new EventService();
        UserService us = new UserService();
        ServiceService ss = new ServiceService();

        List<CategoryQuantity> cq = (List<CategoryQuantity>) session.getAttribute("chosenCategory");
        if(action != null && action.equals("Continue")) {
        try {
            User user = us.get(username);
            Event event = event = es.add(startDate, endDate, venue, status, interest, resCost, eventPrice, total, user);
            int j = 1;
            for (CategoryQuantity c : cq) {
                for (int k = 1; k < c.getQuantity() + 1; k++) {
                    ServiceCategory scm = (ServiceCategory) session.getAttribute(j + "categoryService" + k);

                    Service ser = scm.getService();
                    ser.setEvent(event);
                    ss.add(ser);
                }
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderSummary.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("loggedcustomer");
        } else if (action != null && action.equals("Cancel")) {
            response.sendRedirect("loggedcustomer");
            return;
        }
        
        
        
        //getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/ordersum.jsp").forward(request, response);

    }
}
