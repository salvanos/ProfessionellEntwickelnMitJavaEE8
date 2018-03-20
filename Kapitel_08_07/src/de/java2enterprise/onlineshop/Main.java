package de.java2enterprise.onlineshop;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) 
        throws Exception {
        final Logger logger =
                Logger.getLogger(
                    Main.class.getName());
        EntityManagerFactory emf = 
            Persistence.
            createEntityManagerFactory(
                "onlineshop-jpa");
        EntityManager em = 
                emf.createEntityManager();        
        logger.info("Open: " + em.isOpen() );
        em.close();
        emf.close();
    }
}
