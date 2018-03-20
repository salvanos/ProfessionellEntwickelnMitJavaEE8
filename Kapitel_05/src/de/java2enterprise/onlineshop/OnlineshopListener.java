package de.java2enterprise.onlineshop;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineshopListener 
		implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext servletContext = 
			session.getServletContext();
		servletContext.log(
			"SESSION CREATED: " + event.toString());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext servletContext =
			session.getServletContext();
		servletContext.log(
			"SESSION DESTROYED: " + event.toString());
	}
}
