package de.java2enterprise.onlineshop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LocaleController implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lang = "de_DE";

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String change(String lang) {
        this.lang = lang;
        return "/index.jsf";
    }
}
