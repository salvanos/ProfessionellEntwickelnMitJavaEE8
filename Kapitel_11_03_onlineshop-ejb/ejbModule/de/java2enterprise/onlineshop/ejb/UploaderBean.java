package de.java2enterprise.onlineshop.ejb;

import java.io.FileOutputStream;

import javax.activation.DataHandler;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class UploaderBean {

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
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
