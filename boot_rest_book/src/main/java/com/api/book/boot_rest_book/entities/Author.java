package com.api.book.boot_rest_book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    
    
   // @GeneratedValue(strategy = GenerationType.AUTO)
   @Id
    private int aid;
    private String firstname;
    private String lastname;
    private String language;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Author(int aid, String firstname, String lastname, String language) {
        this.aid = aid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.language = language;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author [aid=" + aid + ", firstname=" + firstname + ", language=" + language + ", lastname=" + lastname
                + "]";
    }
}
