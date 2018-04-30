package de.java2enterprise.onlineshop;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;

@Named
@RequestScoped
public class BuyController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static Logger log = Logger
            .getLogger(BuyController.class.toString());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public String update(Long id) {
        FacesContext ctx = FacesContext
                .getCurrentInstance();
        ELContext elc = ctx.getELContext();
        ELResolver elr = ctx.getApplication()
                .getELResolver();
        SigninController signinController = (SigninController) elr
                .getValue(
                        elc,
                        null,
                        "signinController");

        Customer customer = signinController.getCustomer();
        try {
            ut.begin();
            Item item = em.find(Item.class, id);
            item.setBuyer(customer);
            item.setSold(LocalDateTime.now());
            ut.commit();
            log.info(item + " bought by " + customer);
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
        return "/search.jsf";
    }
}
