/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author kurtm
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        UserService us = new UserService();
        RoleService rs = new RoleService();
        if (action != null && action.equals("Login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            try {
                user = us.get(username);
                if (user != null) {
                    if (user.getPassword().equals(password) == true) {
                        session.setAttribute("username", username);
                        if (user.getRole().getId() == 2) {
                            response.sendRedirect("loggedcustomer");
                        } else if (user.getRole().getId() == 1) {
                            response.sendRedirect("loggedadmin");
                        }
                    } else {
                        response.sendRedirect("landing?page=login");
                    }
                } else {
                    response.sendRedirect("landing?page=login");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action != null && action.equals("Cancel")) {
            response.sendRedirect("landing?page=login");

        } else if (action != null && action.equals("Register")) {
            String username = request.getParameter("userReg");
            try {
                int counter = us.countUname(username);
                if (counter != 0) {
                    //request.setAttribute("message", "Username is already Taken.");
                    response.sendRedirect("landing?page=login&registerAcc=true&msg=0");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String email = request.getParameter("emailReg");
            try {
                int counter = us.countEmail(email);
                if (counter != 0) {
                    //request.setAttribute("message", "Email is already Taken.");
                    response.sendRedirect("landing?page=login&registerAcc=true&msg=0");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String password = request.getParameter("passReg");
            String fname = request.getParameter("firstReg");
            String lname = request.getParameter("lastReg");
            String phone = request.getParameter("phoneReg");
            int pref = Integer.parseInt(request.getParameter("prefReg"));

            try {
                Role role = rs.get(2);
                User user = new User(username, email, password, fname, lname, phone, pref, role);
                 us.add(user);
                //request.setAttribute("message", "Registered an account.");
               
                response.sendRedirect("landing?page=login");
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
