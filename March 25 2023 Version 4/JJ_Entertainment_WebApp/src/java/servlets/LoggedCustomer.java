/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kurtm
 */
public class LoggedCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String page = request.getParameter("page");

        if (page == null || page.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/landing.jsp").forward(request, response);
        } else if (page.equals("about")) {

            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/about.jsp").forward(request, response);
        } else if (page.equals("contact")) {

            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/contact.jsp").forward(request, response);
        } else if (page.equals("gallery")) {

            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/gallery.jsp").forward(request, response);
        } else if (page.equals("profile")) {
            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/profile.jsp").forward(request, response);
        } else if (page == null || page.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/landing.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/LoggedCustomerJSPs/landing.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action!=null && action.equals("Logout")) {
            session.invalidate();
            response.sendRedirect("landing");
        }
    }

}
