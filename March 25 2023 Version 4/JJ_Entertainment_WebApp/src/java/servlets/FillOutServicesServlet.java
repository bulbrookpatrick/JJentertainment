package servlets;

import models.CategoryPrice;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CategoryQuantity;
import models.Service;
import models.ServiceCategory;
import services.EventService;
import services.ServiceService;
import validation.Validator;

public class FillOutServicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        List<CategoryQuantity> cq = (List<CategoryQuantity>) session.getAttribute("chosenCategory");
        int j = 1;

        for (CategoryQuantity c : cq) {
            List<ServiceCategory> scg = new ArrayList<ServiceCategory>(c.getQuantity());
            for (int k = 0; k < c.getQuantity(); k++) {
                Service service = new Service();
                ServiceCategory scm = new ServiceCategory(service, c.getCategory());
                scg.add(scm);
            }
            session.setAttribute("chosenCategory" + j, scg);
            j++;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/filloutservices.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        ServiceService ss = new ServiceService();
        EventService es = new EventService();
        Validator valid = new Validator();
        if (action != null && action.equals("Continue")) {
            List<CategoryQuantity> cq = (List<CategoryQuantity>) session.getAttribute("chosenCategory");
            List<CategoryPrice> cp = new ArrayList<>();
            Double eventPrice = 0.0;
            int j = 1;

            String eventStartDate = (String) session.getAttribute("eventStartDate");
            String eventEndDate = (String) session.getAttribute("eventEndDate");

            for (CategoryQuantity c : cq) {
                List<ServiceCategory> scg = new ArrayList<ServiceCategory>(c.getQuantity());
                CategoryPrice catpri = new CategoryPrice();
                catpri.setCatName(c.getCategory().getName());
                double catPriPrice = 0;
                for (int k = 1; k < c.getQuantity() + 1; k++) {
                    Service service = new Service();
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

                    String startDate = request.getParameter(j + "serviceStartDate" + k);
                    String endDate = request.getParameter(j + "serviceEndDate" + k);
                    String numOfPart = request.getParameter(j + "serviceNumParticipants" + k);

                    if (valid.isIntegerGreaterZero(numOfPart) == false) {
                        request.setAttribute("message", "Put at least 1 participant for each service");
                        this.doGet(request, response);
                        return;
                    }

                    try {
                        if (valid.checkIfDateTime(startDate) == false) {
                            request.setAttribute("message", "Entered Invalid Date for Start Date field");
                            this.doGet(request, response);
                            return;
                        }

                        if (valid.checkIfDateTime(endDate) == false) {
                            request.setAttribute("message", "Entered Invalid Date for End Date field");
                            this.doGet(request, response);
                            return;
                        }

                        if (valid.checkIfDateTimeWithin(eventStartDate, startDate, eventEndDate) == false) {
                            request.setAttribute("message", "Entered start date doesn't correspond with event date range");
                            this.doGet(request, response);
                            return;
                        }

                        if (valid.checkIfDateTimeWithin(eventStartDate, endDate, eventEndDate) == false) {
                            request.setAttribute("message", "Entered end date doesn't correspond with event date range");
                            this.doGet(request, response);
                            return;
                        }

                        if (valid.checkStartEndDateTime(startDate, endDate) == false) {
                            request.setAttribute("message", "Service start and end date is contradictory");
                            this.doGet(request, response);
                            return;
                        }

                    } catch (ParseException ex) {
                        Logger.getLogger(FillOutServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        Date start = (Date) formatter.parse(startDate);
                        Date end = (Date) formatter.parse(endDate);
                        service.setStart(start);
                        service.setEnd(end);

                        service.setParticipants(Integer.parseInt(numOfPart));
                        int duration = ss.getDuration(start, end);
                        if (duration <= 0) {
                            request.setAttribute("message","Please put at least an hour timeframe for each service");
                            this.doGet(request, response);
                            return;
                        }
                        service.setDuration(duration);
                        int numOfPerAss = ss.getNumOfPerformerAssigned(service, c.getCategory());
                        service.setNumPerformersAssigned(numOfPerAss);
                        double serPrice = ss.getServicePrice(service, c.getCategory());
                        service.setPrice(serPrice);
                        service.setCategory(c.getCategory());

                        catPriPrice += serPrice;

                    } catch (ParseException ex) {
                        request.setAttribute("message", "Entered Invalid Date for a service.");
                        this.doGet(request, response);
                        return;
                    }

                    ServiceCategory scm = new ServiceCategory(service, c.getCategory());
                    session.setAttribute(j + "categoryService" + k, scm);
                    scg.add(scm);
                    eventPrice = eventPrice + service.getPrice();
                }
                j++;
                catpri.setTotalPrice(catPriPrice);
                cp.add(catpri);
            }

            double interest = es.getInterest(eventPrice);
            double reservationCost = es.getResCost(eventPrice + interest);
            double eventSerPriceInterest = interest + eventPrice;

            session.setAttribute("eventSerPriceInterest", eventSerPriceInterest);
            session.setAttribute("eventSerPrice", eventPrice);
            session.setAttribute("eventResCost", reservationCost);
            session.setAttribute("eventInterest", interest);
            session.setAttribute("summCat", cp);
            System.out.println(cp.get(0).getCatName());
            response.sendRedirect("ordersummary");
            return;
        } else if (action != null && action.equals("Cancel")) {
            response.sendRedirect("loggedcustomer");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/addservicetoevent.jsp").forward(request, response);
    }
}
