package de.java2enterprise.onlineshop;

public class RegisterClient {

    public static void main(String[] args) throws Exception {
        Register register = 
            new RegisterProxy().getRegister();
        String s = register.persist(
            "j@java2enterprise.de", 
            "Taxi_123");
        System.out.println(s);
    }
}
