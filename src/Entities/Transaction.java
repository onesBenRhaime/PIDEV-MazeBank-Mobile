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
public class Transaction {
    
       private int id;
       private String agenceName,statue,requestTo ,requestFrom,montant,typeTransaction,compte;

    public Transaction(int id, String agenceName, String statue, String requestTo, String requestFrom, String montant, String typeTransaction, String compte) {
        this.id = id;
        this.agenceName = agenceName;
        this.statue = statue;
        this.requestTo = requestTo;
        this.requestFrom = requestFrom;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
        this.compte = compte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgenceName() {
        return agenceName;
    }

    public void setAgenceName(String agenceName) {
        this.agenceName = agenceName;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getRequestTo() {
        return requestTo;
    }

    public void setRequestTo(String requestTo) {
        this.requestTo = requestTo;
    }

    public String getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(String requestFrom) {
        this.requestFrom = requestFrom;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", agenceName=" + agenceName + ", statue=" + statue + ", requestTo=" + requestTo + ", requestFrom=" + requestFrom + ", montant=" + montant + ", typeTransaction=" + typeTransaction + ", compte=" + compte + '}';
    }

    
    
    
}
