/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menagerienetwork.models;

/**
 *
 * @author Luke
 */
public class Animal {
    
    private String petName;
    private String commonName;
    private String latinName;
    
    public Animal(){}

    /**
     * @return the petName
     */
    public String getPetName() {
        return petName;
    }

    /**
     * @param petName the petName to set
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * @return the commonName
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * @param commonName the commonName to set
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * @return the latinName
     */
    public String getLatinName() {
        return latinName;
    }

    /**
     * @param latinName the latinName to set
     */
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
    
}
