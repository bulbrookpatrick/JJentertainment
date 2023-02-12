/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Client;
import services.ClientService;
/**
 *
 * @author Patrick
 */
public class HomeServlet extends HttpServlet {
   

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
           ClientService cs =  new ClientService();
        
        try {
            HttpSession session = request.getSession();
            
            List<Client> clients = cs.getAll();
            
            request.setAttribute("clients", clients);
            
        }
        catch (Exception ex) {
         request.setAttribute("message", "error");

        }
       
     getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

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
       getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        ClientService cs = new ClientService();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        String email;
        int active;
        String fName;
        String lName;
        String password;
        int role;
        
        if(action.equals("add")) {
             email = request.getParameter("emailInput");
             active = Integer.parseInt(request.getParameter("activeInput"));
             fName = request.getParameter("fNameInput");
             lName = request.getParameter("lNameInput");
             password = request.getParameter("passwordInput");
             role = Integer.parseInt(request.getParameter("roleInput"));
             
             
                     
                     
        }
      
        
        else {
           email = request.getParameter("email").replace(" ", "+");
           active = Integer.parseInt(request.getParameter("active"));
           fName = request.getParameter("fName");
           lName = request.getParameter("lName");
           password = request.getParameter("password");
           role = Integer.parseInt(request.getParameter("role"));
        }
        
        try {
            switch (action) {
                case "add":
                 //   cs.insert(email, active, fName, lName, password, role);
                    break;
                case "update":
                  //  cs.update(email, active, fName, lName, password, role);
                    break;
                case "delete":
                    cs.delete(email);
                    break;
            }
        }
        catch (Exception ex) {
            request.setAttribute("message", "clients not updated");
        }
        
        try {
            List<Client> clients = cs.getAll();
            request.setAttribute("clients", clients);
        } catch (Exception e) {
            request.setAttribute("message", "clients not found");
        }
      
    }



}
