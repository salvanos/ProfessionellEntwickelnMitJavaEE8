package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private UserTransaction ut;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        response.setContentType(
                "text/html;charset=UTF-8"
        );

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        try {
            ut.begin();
            em.persist(customer);
            ut.commit();

            if (customer.getId() != null) {
                request.setAttribute(
                        "message",
                        "Die Registrierung war erfolgreich!"
                                + customer
                );
            } else {
                request.getSession().setAttribute(
                        "customer",
                        customer
                );
                request.setAttribute(
                        "message",
                        "Die Registrierung war erfolglos!"
                );
            }

        } catch (Exception e) {
            request.setAttribute(
                    "message",
                    e.getMessage()
            );
        }

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("index.jsp");
        dispatcher.forward(
                request,
                response
        );
    }
}
