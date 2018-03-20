package de.java2enterprise.onlineshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(
    urlPatterns = {"/sell"}, asyncSupported=true)
@MultipartConfig(
    maxFileSize=1024*1024*10, 
    maxRequestSize=1024*1024*30)
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doPost(
        final HttpServletRequest request, 
        final HttpServletResponse response) 
        throws ServletException, IOException {
        
        
        final String title =
            request.getParameter("title");
        final String description = 
            request.getParameter("description");
        final String price =
            request.getParameter("price");
        final Part part = request.getPart("foto");
        
        InputStream is = part.getInputStream();
        
        String path = part.getSubmittedFileName();
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>Artikel: " + title);
        out.println("<br>Beschreibung: " + description);
        out.println("<br>Preis: " + price);
        out.println("<br>Ihr Bild wird hier hochgeladen: "
                + file.getAbsolutePath());
        out.println("</body>");
        out.println("</html>");
        
        final AsyncContext ac = request.startAsync();
        ac.start(new FotoService(is, os));
        ac.complete();
    }
}
