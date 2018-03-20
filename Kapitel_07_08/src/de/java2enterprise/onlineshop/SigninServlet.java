package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private DataSource ds;

    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
                throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
                
        try {
            Customer customer = find(email, password);
            
            if(customer!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
            }
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        response.setContentType(
                "text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
    public Customer find(
            String _email, 
            String _password) 
            throws Exception {  
        try(final Connection con = ds.getConnection();
            final PreparedStatement stmt = con.prepareStatement(
                "SELECT " +
                    "id, " +
                    "email, " +
                    "password " +
                "FROM onlineshop.customer " +
                "WHERE email=? " +
                "AND password=?")) {
        
            stmt.setString(1, _email);
            stmt.setString(2, _password);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                            
                Customer customer = new Customer();
    
                Long id = Long.valueOf(rs.getLong("id"));
                customer.setId(id);
                
                String email = rs.getString("email");
                customer.setEmail(email);
                
                String password = rs.getString("password");
                customer.setPassword(password);     
    
                return customer;
            }
        }
        return null;
    }
}