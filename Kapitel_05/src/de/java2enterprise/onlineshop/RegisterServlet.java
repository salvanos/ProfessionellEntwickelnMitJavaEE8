package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType(
				"text/html;charset=UTF-8");
		
		final String email =
			request.getParameter("email");
		final String password = 
			request.getParameter("password");
		
		final Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		
		// Persist customer to database

		final RequestDispatcher dispatcher = 
			request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
