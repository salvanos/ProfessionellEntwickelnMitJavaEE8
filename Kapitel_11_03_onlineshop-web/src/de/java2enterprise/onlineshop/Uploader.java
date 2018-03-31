package de.java2enterprise.onlineshop;

import java.io.FileOutputStream;

import javax.activation.DataHandler;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Uploader {

    @Oneway
    @WebMethod
    public void upload(
            String fileName,
            DataHandler dataHandler) {
        try {
            FileOutputStream fos = 
                new FileOutputStream(
                "/tmp/" + fileName);
            dataHandler.writeTo(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
