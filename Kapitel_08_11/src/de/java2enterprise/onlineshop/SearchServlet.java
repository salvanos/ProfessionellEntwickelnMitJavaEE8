package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.util.List;

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

import de.java2enterprise.onlineshop.model.Item;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String s = request.getParameter("search");
        HttpSession session = request.getSession();
        try {
            TypedQuery<Item> query = 
                    em.createQuery(
                        "FROM Item i "
                        + "WHERE i.title LIKE '%" + s + "%'",
                    Item.class);

            List<Item> items = query.getResultList();
            if (items != null) {
                session.setAttribute("items", items);
            }
        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
        }
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
    }
}
