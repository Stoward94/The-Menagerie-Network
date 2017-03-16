/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork.entities;

import java.util.ArrayList;

/**
 *
 * @author Luke
 */
public class Zoo {
    
    private String name;
    private String url;
    private Double latitude;
    private Double longtitude;
    private String postcode;
    private ArrayList<Animal> animals;
    
    public Zoo(){
        animals = new ArrayList<>();
    }
    
    
    
    
}
