package de.java2enterprise.onlineshop;

import java.io.InputStream;
import java.io.OutputStream;

public class FotoService implements Runnable {
    private InputStream is;
    private OutputStream os;
    
    public FotoService(
            InputStream is, 
            OutputStream os) {
        this.is = is;
        this.os = os;
    }
    
    @Override
    public void run() {    
        try {
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
