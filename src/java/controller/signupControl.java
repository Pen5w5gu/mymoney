package controller;

import DAO.accountDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupControl
 */
public class signupControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signupControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        accountDAO dao = new accountDAO();

        String username = request.getParameter("usernameSignup");
        String email = request.getParameter("emailSignup");
        String password = request.getParameter("passwordSignup");

        // Check for null or empty values before using them
        if (username == null || email == null || password == null || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("mess", "Account registration failed");
            request.setAttribute("messError", "Please fill in all the fields");
        } else {
            if (dao.checkDuplicateUsername(username) == false) {
                request.setAttribute("mess", "Account registration failed");
                request.setAttribute("messError", "User already exists");
            } else if (dao.checkDuplicateEmail(email) == false) {
                request.setAttribute("mess", "Account registration failed");
                request.setAttribute("messError", "Email already exists");
            } else {
                // Use try-with-resources to handle resources properly
                try {
                    dao.signup(username, email, password);
                    request.setAttribute("mess", "Successful account registration");
                    request.removeAttribute("messError");
                } catch (Exception e) {
                    // Log or handle the exception
                    e.printStackTrace();
                    request.setAttribute("mess", "Account registration failed");
                    request.setAttribute("messError", "An error occurred during registration");
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("login");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
