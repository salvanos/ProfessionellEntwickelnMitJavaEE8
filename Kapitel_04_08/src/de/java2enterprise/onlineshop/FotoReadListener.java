package de.java2enterprise.onlineshop;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FotoReadListener implements ReadListener {
    private AsyncContext ac;
    
    public FotoReadListener(AsyncContext ac) {
        this.ac = ac;
    }
    
    @Override
    public void onDataAvailable() {
        final HttpServletRequest request = 
                (HttpServletRequest) ac.getRequest();
        final HttpServletResponse response = 
            (HttpServletResponse) ac.getResponse();
        
        OutputStream os = null;
        InputStream is = null;
        PrintWriter out = null;
        try {
            final Part part = request.getPart("foto");
            os = new FileOutputStream(
                    "/tmp/" + 
                    part.getSubmittedFileName());
            is = part.getInputStream();
            out = response.getWriter();
            
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }
            os.flush();
            out.write("true");
            ac.complete();
        } catch (Exception ex) {
            out.write("false");
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void onAllDataRead() {
        ac.complete();
    }
    
    @Override
    public void onError(Throwable ex) {
        ex.printStackTrace();
        ac.complete();
    }
}
