package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private DataSource ds;

    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType(
                "text/html;charset=UTF-8");
        
        String email = request.getParameter("email");
        String password = 
            request.getParameter("password");
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        
        try {
            persist(customer);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        
        if(customer.getId() != null) {
            request.setAttribute("message", "Die Registrierung war erfolgreich!");
        } else {
            request.setAttribute("message", "Die Registrierung war erfolglos!");
        }
        
        RequestDispatcher dispatcher = 
            request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void persist(Customer customer) 
            throws Exception {
        try(final Connection con = ds.getConnection();
            final PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO onlineshop.customer(" +
                "email, " +
                "password" +
            ") VALUES (" +
                "?, " +
                "?)"
            )) {
            stmt.setString(1, customer.getEmail());
            stmt.setString(2, customer.getPassword());
            stmt.executeUpdate();
        }
    }
}

