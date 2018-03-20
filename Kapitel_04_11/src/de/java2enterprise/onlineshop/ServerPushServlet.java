package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

@WebServlet(urlPatterns = { "/serverpush" })
public class ServerPushServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {

        PushBuilder pushBuilder = request.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder.path("resources/img/tau.jpg")
                    .addHeader("content-type", "image/jpg")
                    .push();
        }
        try (PrintWriter respWriter = response
                .getWriter();) {
            respWriter.write(
                    "<html><img src='resources/img/tau.jpg'></html>");

        }
    }
}
