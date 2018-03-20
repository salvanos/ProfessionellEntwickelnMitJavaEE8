package de.java2enterprise.onlineshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JdbcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        final String jdbc_properties = 
            getInitParameter(
                "jdbc_properties");
        final InputStream in = 
           new FileInputStream(jdbc_properties);
        final Properties p = new Properties();
        p.load(in);
        
        response.setContentType(
                "text/html;charset=UTF-8");
        
        final PrintWriter out = 
            response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println(
            "<br>driver: " + 
                p.getProperty("driver"));
        out.println(
            "<br>url: " + 
                p.getProperty("url"));
        out.println(
            "<br>username: " + 
                p.getProperty("username"));
        out.println(
            "<br>password: " + 
            p.getProperty("password"));
        out.println("</body>");
        out.println("</html>");
    }
}
