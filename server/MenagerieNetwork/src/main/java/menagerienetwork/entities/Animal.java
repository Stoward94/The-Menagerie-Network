/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork.entities;

/**
 *
 * @author Luke
 */
public class Animal {
    
    private String petName;
    private String commonName;
    private String latinName;
    private String order;
    private String family;
    private String genus;
    private String species;
    private Zoo zoo;
    
    public Animal(){}
    
    
    
    //Setters and getters
    
    public String getCommonName(){
        return commonName;
    }
    public void setCommonName(String name){
        
    }
}
