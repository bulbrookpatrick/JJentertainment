/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
import services.CategoryService;
import services.EventService;
import services.ServiceService;

/**
 *
 * @author kurtm
 */
public class EventApprovalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        EventService es = new EventService();
        ServiceService ss = new ServiceService();
        String eventSelected = request.getParameter("pendEventSel");
        request.setAttribute("view", true);
        List<Event> events = new ArrayList<>();

        try {
            events = es.getAllPending();
        } catch (Exception ex) {
            Logger.getLogger(ChooseEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("pendingEvent", events);

        if (eventSelected == null || eventSelected == "") {
            getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/eventapproval.jsp").forward(request, response);

        } else {
            int eventSel = Integer.parseInt(eventSelected);
            request.setAttribute("view", false);
            Event event;
            try {
                event = es.get(eventSel);
                request.setAttribute("eventSelCustomer", event.getUser().getUsername());
                request.setAttribute("eventSelLocation", event.getLocation());
                request.setAttribute("eventSelTotal", event.getTotal());
                request.setAttribute("eventSelInterest", event.getInterest());
                request.setAttribute("eventSelResCost", event.getReservation());
                request.setAttribute("eventSelService", event.getPrice());
            } catch (SQLException ex) {
                Logger.getLogger(EventApprovalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            session.setAttribute("pendEventSel", eventSel);
            try {
                List<Service> eventSelServ = ss.getAllServEvent(eventSel);
                request.setAttribute("eventSelected", eventSelServ);
            } catch (SQLException ex) {
                Logger.getLogger(EventApprovalServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EventApprovalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/eventapproval.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        EventService es = new EventService();

        if (action.equals("Approve")) {
            try {
                int eventSelected = (int) session.getAttribute("pendEventSel");
                es.activate(eventSelected);
                request.setAttribute("pendEventSel", null);
                request.setAttribute("view", true);
            } catch (SQLException ex) {
                Logger.getLogger(EventApprovalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("Cancel")) {
            request.setAttribute("pendEventSel", null);
            request.setAttribute("view", true);
        } else if (action.equals("Refund")) {
            try {
                int eventSelected = (int) session.getAttribute("pendEventSel");
                es.refund(eventSelected);
                request.setAttribute("pendEventSel", null);
                request.setAttribute("view", true);
            } catch (SQLException ex) {
                Logger.getLogger(EventApprovalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("Back")) {
            response.sendRedirect("loggedadmin");
            return;
        }
        this.doGet(request, response);
    }

}
