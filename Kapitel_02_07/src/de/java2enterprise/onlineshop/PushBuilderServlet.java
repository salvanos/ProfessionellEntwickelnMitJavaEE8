package de.java2enterprise.onlineshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

@WebServlet("/PushBuilderServlet")
public class PushBuilderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PushBuilder pushBuilder = request.newPushBuilder();
		pushBuilder
			.path("images/bild1.jpg")
			.addHeader("content-type", "image/jpg")
			.push();
	}
}
