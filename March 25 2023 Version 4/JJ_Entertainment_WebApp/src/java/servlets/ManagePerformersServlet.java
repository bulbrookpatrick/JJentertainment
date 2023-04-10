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
import models.Performer;
import models.PerformerCategory;
import services.CategoryService;
import services.PerformerCategoryService;
import services.PerformerService;

/**
 *
 * @author kurtm
 */
public class ManagePerformersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        PerformerService ps = new PerformerService();
        PerformerCategoryService pcs = new PerformerCategoryService();
        CategoryService cs = new CategoryService();
        request.setAttribute("editing", false);
        List<Performer> perList = new ArrayList<>();
        List<PerformerCategory> pc = new ArrayList<>();
        List<Category> addCategories = new ArrayList<>();

        if (action != null && action.equals("deleteSpec")) {
            int userId = Integer.parseInt((String) session.getAttribute("performerId"));
            int delPer = Integer.parseInt(request.getParameter("manSpecPer"));
            int delCat = Integer.parseInt(request.getParameter("manSpecCat"));
            try {
                pcs.del(delPer, delCat);

                Category deletedCat = cs.get(delCat);
                Performer performer = ps.get(delPer);
                List<Category> cat = new ArrayList<>();
                List<Category> catAvail = new ArrayList<>();
                List<PerformerCategory> pc3 = new ArrayList<>();
                try {
                    cat = cs.getAll();
                    pc = pcs.getAllPerId(userId);
                    boolean bool = false;
                    for (Category c : cat) {
                        for (PerformerCategory pac : pc) {
                            if (c.getName().equals(pac.getCategory().getName())) {
                                bool = true;
                                break;
                            }
                        }
                        if (bool == false) {
                            catAvail.add(c);
                        }
                        bool = false;
                    }

                    request.setAttribute("manageSpecialties", true);
                    request.setAttribute("manageSpecialtyOfPerformer", pc);
                    request.setAttribute("manageSpecialtyAdd", catAvail);
                    request.setAttribute("messageManageSpecialty", "Deleted " + deletedCat.getName() + " from " + performer.getUsername() + "'s specialties");
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (action != null && action.equals("edit")) {
            request.setAttribute("editing", true);
            try {
                Performer performer = ps.get(Integer.parseInt(request.getParameter("performerSel")));
                pc = pcs.getAllPerId(performer.getId());
                session.setAttribute("performerId", request.getParameter("performerSel"));
                request.setAttribute("perUName", performer.getUsername());
                request.setAttribute("perEmail", performer.getEmail());
                request.setAttribute("perPass", performer.getPassword());
                request.setAttribute("perFName", performer.getFname());
                request.setAttribute("perLName", performer.getLname());
                request.setAttribute("perPhone", performer.getPhoneNumber());
                request.setAttribute("perPSEdit", pc);
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (action != null && action.equals("delete")) {
            String perId = request.getParameter("performerSel");

        }

        try {
            perList = ps.getAll();
            addCategories = cs.getAll();
            int count = 1;
            for (Performer p : perList) {
                int performerId = p.getId();
                pc = pcs.getAllPerId(performerId);
                request.setAttribute("performerSpecialty" + count, pc);
                count++;
            }
            request.setAttribute("performers", perList);
            request.setAttribute("addSpecialties", addCategories);
        } catch (Exception ex) {
            Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/manageperformers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        PerformerCategoryService pcs = new PerformerCategoryService();
        PerformerService ps = new PerformerService();
        CategoryService cs = new CategoryService();
        List<PerformerCategory> pc = new ArrayList<>();

        if (action != null && action.equals("Manage Specialties")) {
            int userId = Integer.parseInt((String) session.getAttribute("performerId"));
            List<Category> cat = new ArrayList<>();
            List<Category> catAvail = new ArrayList<>();
            List<PerformerCategory> pc3 = new ArrayList<>();
            try {
                cat = cs.getAll();
                pc = pcs.getAllPerId(userId);
                boolean bool = false;
                for (Category c : cat) {
                    for (PerformerCategory pac : pc) {
                        if (c.getName().equals(pac.getCategory().getName())) {
                            bool = true;
                            break;
                        }
                    }
                    if (bool == false) {
                        catAvail.add(c);
                    }
                    bool = false;
                }

                request.setAttribute("manageSpecialties", true);
                request.setAttribute("manageSpecialtyOfPerformer", pc);
                request.setAttribute("manageSpecialtyAdd", catAvail);
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.doGet(request, response);
            return;
        } else if (action != null && action.equals("Back")) {
            session.setAttribute("performerId", null);
            response.sendRedirect("loggedadmin");
            return;
        } else if (action != null && action.equals("Add Specialty")) {
            int userId = Integer.parseInt((String) session.getAttribute("performerId"));
            String category = request.getParameter("manSpecAddThis");
            if (category == null || category == "") {
                List<Category> cat = new ArrayList<>();
                List<Category> catAvail = new ArrayList<>();
                List<PerformerCategory> pc3 = new ArrayList<>();
                try {
                    cat = cs.getAll();
                    pc = pcs.getAllPerId(userId);
                    boolean bool = false;
                    for (Category c : cat) {
                        for (PerformerCategory pac : pc) {
                            if (c.getName().equals(pac.getCategory().getName())) {
                                bool = true;
                                break;
                            }
                        }
                        if (bool == false) {
                            catAvail.add(c);
                        }
                        bool = false;
                    }

                    request.setAttribute("manageSpecialties", true);
                    request.setAttribute("manageSpecialtyOfPerformer", pc);
                    request.setAttribute("manageSpecialtyAdd", catAvail);

                    request.setAttribute("messageManageSpecialty", "There is no such specialty.");
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.doGet(request, response);
                return;
            }
            try {
                Category catCh = cs.get(Integer.parseInt(category));
                pcs.add(userId, catCh.getId(), catCh.getName());

                List<Category> cat = new ArrayList<>();
                List<Category> catAvail = new ArrayList<>();
                List<PerformerCategory> pc3 = new ArrayList<>();
                try {
                    cat = cs.getAll();
                    pc = pcs.getAllPerId(userId);
                    Performer performer = ps.get(userId);
                    boolean bool = false;
                    for (Category c : cat) {
                        for (PerformerCategory pac : pc) {
                            if (c.getName().equals(pac.getCategory().getName())) {
                                bool = true;
                                break;
                            }
                        }
                        if (bool == false) {
                            catAvail.add(c);
                        }
                        bool = false;
                    }

                    request.setAttribute("manageSpecialties", true);
                    request.setAttribute("manageSpecialtyOfPerformer", pc);
                    request.setAttribute("manageSpecialtyAdd", catAvail);
                    request.setAttribute("messageManageSpecialty", "Added " + catCh.getName() + " to " + performer.getUsername() + "'s specialties");
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.doGet(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action != null && action.equals("Cancel")) {
            session.setAttribute("performerId", null);
            request.setAttribute("editing", false);
            this.doGet(request, response);
            return;
        } else if (action != null && action.equals("Save")) {
            int userId = Integer.parseInt((String) session.getAttribute("performerId"));
            String newUName = request.getParameter("perUNameEdit");
            String email = request.getParameter("perEmailEdit");
            String password = request.getParameter("perPassEdit");
            String fname = request.getParameter("perFNameEdit");
            String lname = request.getParameter("perLNameEdit");
            String phone = request.getParameter("perPhoneEdit");

            Performer performer = new Performer(userId, newUName, email, password, fname, lname, phone);
            try {
                ps.update(performer, userId);
                request.setAttribute("messageManagePerformers", "Updated " + newUName + "'s Info");
                session.setAttribute("performerUsername", null);
                request.setAttribute("editing", false);
                this.doGet(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action != null && action.equals("Go Back")) {
            List<Category> addCategories = new ArrayList<>();
            request.setAttribute("editing", true);
            int userId = Integer.parseInt((String) session.getAttribute("performerId"));
            try {
                Performer performer = ps.get(userId);
                pc = pcs.getAllPerId(performer.getId());
                session.setAttribute("performerId", Integer.toString(userId));
                request.setAttribute("perUName", performer.getUsername());
                request.setAttribute("perEmail", performer.getEmail());
                request.setAttribute("perPass", performer.getPassword());
                request.setAttribute("perFName", performer.getFname());
                request.setAttribute("perLName", performer.getLname());
                request.setAttribute("perPhone", performer.getPhoneNumber());
                request.setAttribute("perPSEdit", pc);
                List<Performer> perList = new ArrayList<>();
                perList = ps.getAll();
                addCategories = cs.getAll();
                int count = 1;
                for (Performer p : perList) {
                    int performerId = p.getId();
                    pc = pcs.getAllPerId(performerId);
                    request.setAttribute("performerSpecialty" + count, pc);
                    count++;
                }
                request.setAttribute("performers", perList);
                request.setAttribute("addSpecialties", addCategories);
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action != null && action.equals("Add Performer")) {
            Performer performer = new Performer();
            List<Category> catList = new ArrayList<>();
            performer.setUsername(request.getParameter("perUNameAdd"));
            performer.setEmail(request.getParameter("perEmailAdd"));
            performer.setPassword(request.getParameter("perPassAdd"));
            performer.setFname(request.getParameter("perFNameAdd"));
            performer.setLname(request.getParameter("perLNameAdd"));
            performer.setPhoneNumber(request.getParameter("perPhoneAdd"));
            try {
                Performer per = ps.add(performer);
                catList = cs.getAll();
                int count = 1;
                for(Category c : catList) {
                    if(request.getParameter("addingHere"+count)!= null){
                        pcs.add(per.getId(), c.getId(), c.getName());
                    }
                    count++;
                }
                this.doGet(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ManagePerformersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        getServletContext().getRequestDispatcher("/WEB-INF/AdminJSPs/manageperformers.jsp").forward(request, response);
    }
}
