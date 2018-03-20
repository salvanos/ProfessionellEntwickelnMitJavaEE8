import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.java2enterprise.onlineshop.ejb.RegisterBeanRemote;

public class Main {
    public static void main(String[] args) throws NamingException {
        new Main();
    }

    /* (non-Java-doc)
     * @see java.lang.Object#Object()
     */
    public Main() throws NamingException {
        Context c = new InitialContext();
        RegisterBeanRemote register = 
        (RegisterBeanRemote)
        c.lookup(
        "java:global"
        + "/"
//        + "onlineshop"        // EAR-Datei
//        + "/"
        + "onlineshop-ejb"        // EJB-Modul
        + "/"
        + "RegisterBean"        // SessionBean
        + "!"
        + "de.java2enterprise.onlineshop.ejb."
        + "RegisterBeanRemote");    // Business-Interface
        System.out.println(register.persist(
            "j@java2enterprise.de", "Taxi_123"));
    }
}
