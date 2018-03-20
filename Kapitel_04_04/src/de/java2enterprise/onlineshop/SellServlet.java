package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/sell")
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
                throws ServletException, IOException {
        response.setContentType(
                "text/html;charset=UTF-8");

    	final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");

        final HttpSession session = request.getSession();
        final Object object = session.getAttribute("customer");
        if(object != null && object instanceof Customer) {
            out.println("Ihr Artikel wurde zum Verkauf angeboten!"); 
        } else {
            out.println("Der Benutzer ist nicht valide!"); 
        }
        
        out.println("</body>");
        out.println("</html>");            
    }
}
