package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
        throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Sie haben sich erfolgreich registriert!</h1>");
        out.println("Datum: " + LocalDateTime.now());
        out.println("</body>");
        out.println("</html>");  
    }
}
