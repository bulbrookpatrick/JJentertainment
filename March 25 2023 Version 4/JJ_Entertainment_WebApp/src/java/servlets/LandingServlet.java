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

public class LandingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String page = request.getParameter("page");

        if (page == null || page.equals("")) {
  
            getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);

        } else if (page.equals("about")) {

            getServletContext().getRequestDispatcher("/WEB-INF/about.jsp").forward(request, response);
        } else if (page.equals("contact")) {
  
            getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp").forward(request, response);
        } else if (page.equals("gallery")) {
 
            getServletContext().getRequestDispatcher("/WEB-INF/gallery.jsp").forward(request, response);
        } else if (page.equals("login")) {
            String reg = request.getParameter("registerAcc");

            if (reg == null || reg == "") {
                request.setAttribute("registerAcc", false);
            } else if (reg != null && reg.equals("true")) {
                request.setAttribute("registerAcc", true);
            } else if (reg != null && reg.equals("false")) {
                request.setAttribute("registerAcc", false);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (page == null || page.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
