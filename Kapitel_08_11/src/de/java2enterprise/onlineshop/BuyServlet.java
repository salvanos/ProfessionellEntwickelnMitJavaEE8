package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private UserTransaction ut;

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Long itemId = Long
                .parseLong(request.getParameter("item_id"));
        HttpSession session = request.getSession();
        Customer customer = (Customer) session
                .getAttribute("customer");

        try {
            update(itemId, customer.getId());
        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
        }
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("search");
        dispatcher.forward(request, response);
    }

    public void update(Long itemId, Long buyerId)
            throws Exception {
        
        ut.begin();
        Item item = em.find(Item.class, itemId);
        Customer buyer = em.find(Customer.class, buyerId);
        item.setBuyer(buyer);
        item.setSold(LocalDateTime.now());
        ut.commit();
    }
}
