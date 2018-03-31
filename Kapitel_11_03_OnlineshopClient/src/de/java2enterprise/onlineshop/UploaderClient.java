package de.java2enterprise.onlineshop;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UploaderClient {

    public static void main(String[] args) 
            throws Exception {

        @SuppressWarnings("resource")
        FileInputStream in = 
            new FileInputStream("/tmp/bild.jpg");
        FileChannel ch = in.getChannel();
        byte[] b = new byte[(int) ch.size()];
        ch.read(ByteBuffer.wrap(b));
        
        new UploaderProxy().getUploader().upload("/kopie.jpg", b);
    }
}
