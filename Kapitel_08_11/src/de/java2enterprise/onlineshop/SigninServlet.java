package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
                throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
                
        HttpSession session = request.getSession();
        try {
            TypedQuery<Customer> query = 
                    em.createQuery(
                    "FROM " + 
                    Customer.class.getSimpleName() + " c " +
                    "WHERE c.email = ?1 " +
                    "AND c.password = ?2",
                    Customer.class);
            query.setParameter(1, email);
            query.setParameter(2, password);
            Customer customer = query.getSingleResult();
            
            session.setAttribute("customer", customer);
        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
        }
        response.setContentType(
                "text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}