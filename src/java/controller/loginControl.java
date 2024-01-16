/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.accountDAO;
import entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author quann
 */
public class loginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        accountDAO dao = new accountDAO();
        
        if ("login".equals(action)) {
            String username = request.getParameter("user");
            String password = request.getParameter("password");
            Account a = dao.login(username, password);
            if (a == null) {
                request.setAttribute("mess", "Wrong user or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("name", a.getName());
                request.getRequestDispatcher("home").forward(request, response);
            }
        }else if("signup".equals(action)){
            String username = request.getParameter("usernameSignup");
            String email = request.getParameter("emailusernameSignup");
            String password = request.getParameter("passwordusernameSignup");
            if(dao.checkDuplicateUsername(username) == false ){
                request.setAttribute("messError", "User already exists");
                 
            }else if(dao.checkDuplicateEmail(email) == false){
                request.setAttribute("messError", "Email already exists");
            }else{
                dao.signup(username, email, password);
            }
            
            
            String script = "<script type='text/javascript'>"
                      + "toggleSignUp(event);"
                      + "</script>";

        // Gửi mã JavaScript về client
        response.getWriter().write(script);
        request.getRequestDispatcher("login").forward(request, response);
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
