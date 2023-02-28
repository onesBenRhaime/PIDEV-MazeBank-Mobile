/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author BAZINFO
 */
public class CarteBancaire {
      private int id;
       private String identifier,email,description,cinS1,cinS2;


    public CarteBancaire(int id, String identifier, String email, String description, String cinS1, String cinS2) {
        this.id = id;
        this.identifier = identifier;
        this.email = email;
        this.description = description;
        this.cinS1 = cinS1;
        this.cinS2 = cinS2;
    }

    public CarteBancaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCinS1() {
        return cinS1;
    }

    public void setCinS1(String cinS1) {
        this.cinS1 = cinS1;
    }

    public String getCinS2() {
        return cinS2;
    }

    public void setCinS2(String cinS2) {
        this.cinS2 = cinS2;
    }

    @Override
    public String toString() {
        return "CarteBancaire{" + "id=" + id + ", identifier=" + identifier + ", email=" + email + ", description=" + description + ", cinS1=" + cinS1 + ", cinS2=" + cinS2 + '}';
    }
     
    
    
}
