/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Msi
 */
@WebServlet(name = "UserEdit", urlPatterns = {"/user-edit"})
public class UserEdit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        try {
            User user = userDao.find(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/user_edit.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
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
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.find(userId);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setUsername(username);
           
            request.setAttribute("user", user);
            boolean userEdit = userDao.update(user);
            if (userEdit) {
                response.sendRedirect("user-list");
            } else {
                request.setAttribute("form_message", "User couldnt update!");
                request.getRequestDispatcher("WEB-INF/user_edit.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("form_message", ex.getMessage());
            request.getRequestDispatcher("WEB-INF/user_edit.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
