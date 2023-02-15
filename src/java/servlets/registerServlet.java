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
import models.Client;
import services.ClientService;

/**
 *
 * @author Patrick
 */
public class registerServlet extends HttpServlet {
   

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
         String action = request.getParameter("action");
      
              ClientService cs = new ClientService();

  
        Client client = new Client();
        client.setEmail(request.getParameter("emailInput"));
//        client.setUsername(request.getParameter("emailInput"));
        client.setPassword(request.getParameter("passwordInput"));
        client.setfName(request.getParameter("fNameInput"));
        client.setlName(request.getParameter("lNameInput"));
        client.setPhone(Integer.parseInt(request.getParameter("phoneInput")));
        client.setPrefer(0);
        client.setUsername("user");
        HttpSession session = request.getSession();

        
//        not inserting
        try {
            cs.insert(client.getUsername(), client.getEmail(),  client.getPassword(),
                    client.getfName(), 
                    client.getlName(),
                    client.getPhone(),
                    client.getPrefer()
            );
        }
        catch (Exception ex) {
            request.setAttribute("RegisterMessage", "users not updated");
        }
        
        response.sendRedirect("home");
           
           
       }
    }


