/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import services.CategoryService;

/**
 *
 * @author kurtm
 */
public class ManageEventServicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        CategoryService cs = new CategoryService();
        request.setAttribute("editing", false);
        List<Category> catList = new ArrayList<>();

        if (action != null && action.equals("edit")) {
            request.setAttribute("editing", true);
            String catId = request.getParameter("categorySel");
            try {
                Category cat = cs.get(Integer.parseInt(catId));
                session.setAttribute("catId", Integer.parseInt(catId));
                request.setAttribute("catName", cat.getName());
                request.setAttribute("catDesc", cat.getDesc());
                request.setAttribute("catRate", cat.getRate());
                request.setAttribute("catMinNumPar", cat.getMinNumPar());
                request.setAttribute("catMinNumPer", cat.getMinNumPer());
            } catch (SQLException ex) {
                Logger.getLogger(ManageEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (action != null && action.equals("delete")) {
            String catId = request.getParameter("categorySel");
            try {
                request.setAttribute("message", "Deleted Event Service called " + cs.get(Integer.parseInt(catId)).getName());
                cs.del(Integer.parseInt(catId));
            } catch (SQLException ex) {
                request.setAttribute("message", "Some/An events might have this event service. Can not delete!");
                Logger.getLogger(ManageEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

        try {
            catList = cs.getAll();
            request.setAttribute("services", catList);
        } catch (Exception ex) {
            Logger.getLogger(ManageEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/manageeventservices.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        CategoryService cs = new CategoryService();

        if (action != null && action.equals("Save")) {
            try {
                Category cat = cs.get((int) session.getAttribute("catId"));
                String str = cat.getName();
                cat.setName(request.getParameter("catNameEdit"));
                cat.setDesc((String) request.getParameter("catDescEdit"));
                cat.setRate(Double.parseDouble(request.getParameter("catRateEdit")));
                cat.setMinNumPar(Integer.parseInt(request.getParameter("catMinNumParEdit")));
                cat.setMinNumPer(Integer.parseInt(request.getParameter("catMinNumPerEdit")));
                cs.update(cat);
                request.setAttribute("message", "Updated an Event Service called " + str);
                this.doGet(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ManageEventServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action != null && action.equals("Cancel")) {
            request.setAttribute("editing", false);
            this.doGet(request, response);
            return;
        } else if (action != null && action.equals("Back")) {
            response.sendRedirect("loggedadmin");
            return;
        } else if (action != null && action.equals("Add Event Service")) {
            Category cat = new Category();
            cat.setName(request.getParameter("catNameAdd"));
            cat.setDesc((String) request.getParameter("catDescAdd"));
            cat.setRate(Double.parseDouble(request.getParameter("catRateAdd")));
            cat.setMinNumPar(Integer.parseInt(request.getParameter("catMinNumParAdd")));
            cat.setMinNumPer(Integer.parseInt(request.getParameter("catMinNumPerAdd")));
            try {
                cs.add(cat);
            } catch (SQLException ex) {
                request.setAttribute("message", "Something Wrong Adding an Event Service");
                this.doGet(request, response);
                return;
            }
            request.setAttribute("message", "Added an Event Service called " + cat.getName());
            this.doGet(request, response);
            return;
        }

        //getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/manageeventservices.jsp").forward(request, response);
    }

}
