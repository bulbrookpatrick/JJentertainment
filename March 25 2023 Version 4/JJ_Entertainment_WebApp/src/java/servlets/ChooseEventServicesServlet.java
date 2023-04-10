/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import models.CategoryQuantity;
import services.CategoryService;
import services.UserService;
import services.EventService;
import validation.Validator;

public class ChooseEventServicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        CategoryService cats = new CategoryService();

        List<Category> categories = new ArrayList<>();

        try {
            categories = cats.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ChooseEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("category", categories);

        getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/addevent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        EventService es = new EventService();
        UserService us = new UserService();
        CategoryService cats = new CategoryService();
        Validator validator = new Validator();
        if (action != null && action.equals("Continue")) {
            //Get neccessary parameters
            String venue = request.getParameter("eventVenue");
            String startDate = request.getParameter("eventStartDate");
            String endDate = request.getParameter("eventEndDate");

            //null or empty string
            if (venue == null || venue.equals("")) {
                request.setAttribute("message", "Entered Invalid Venue Field");
                this.doGet(request, response);
                return;
            }

            //validify dates
            if (validator.checkIfDate(startDate) == false) {
                request.setAttribute("message", "Entered Invalid Date for Start Date field");
                this.doGet(request, response);
                return;
            }
            if (validator.checkIfDate(endDate) == false) {
                request.setAttribute("message", "Entered Invalid Date for End Date field");
                this.doGet(request, response);
                return;
            }
            ;
            if (validator.checkStartEndDate(startDate, endDate) == false) {
                request.setAttribute("message", "Entered Invalid Date Range");
                this.doGet(request, response);
                return;
            }
            

            //Logic for Category chosen and its amount
            List<Category> listCategory;
            try {
                listCategory = cats.getAll();
                List<CategoryQuantity> chosenQuantityPerCategory = new ArrayList<>();
                int i = 1;
                int counter = 0;
                for (Category category : listCategory) {
                    String quantityStr = request.getParameter("quantityId" + i);

//                    //if user change the variable name
//                    if(quantityStr == null || quantityStr.equals("")) {
//                        this.doGet(request, response);
//                        break;
//                    }
                    int quantity = Integer.parseInt(quantityStr);
                    if (quantity != 0) {
                        counter += quantity;
                        CategoryQuantity placeholder = new CategoryQuantity(category, quantity);
                        chosenQuantityPerCategory.add(placeholder);
                    }
                    i++;
                }

                if (counter == 0) {
                    request.setAttribute("message", "Please add at least one event service");
                    this.doGet(request, response);
                    return;
                }
                //set session variables
                session.setAttribute("chosenCategory", chosenQuantityPerCategory);
                session.setAttribute("eventStartDate", startDate);
                session.setAttribute("eventEndDate", endDate);
                session.setAttribute("eventVenue", venue);
                //redirect to filloutservices 
                response.sendRedirect("filloutservice");
                return;
            } catch (Exception ex) {
                Logger.getLogger(ChooseEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action != null && action.equals("Cancel")) {
            response.sendRedirect("loggedcustomer");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/AddEventJSPs/addevent.jsp").forward(request, response);
    }

}
