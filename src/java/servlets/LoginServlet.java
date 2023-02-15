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
import models.*;
import services.ClientService;
/**
 *
 * @author Patrick
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              HttpSession session = request.getSession();
         session.invalidate();
         
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
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
      HttpSession session = request.getSession();
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       String action = request.getParameter("action");
      
              ClientService cs = new ClientService();

       
     
     
       
       
       
       Client client = cs.login(email, password);
       try {
       client = cs.get(email);
       }
       catch (Exception ex) {
           
       }
     
       if (client == null) {
           request.setAttribute("message", "unable to login");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
       }
       
       
       session.setAttribute("email", client.getEmail());
       session.setAttribute("fName", client.getfName());
       session.setAttribute("lName", client.getlName());
       session.setAttribute("password", client.getPassword());

       session.setAttribute("username", client.getUsername());
       session.setAttribute("phone", client.getPhone());
       session.setAttribute("prefer", client.getPrefer());
       
       response.sendRedirect("home");

         
}
    }

 
