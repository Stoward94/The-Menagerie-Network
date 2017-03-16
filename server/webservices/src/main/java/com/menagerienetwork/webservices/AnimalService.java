package com.menagerienetwork.webservices;

import com.menagerienetwork.models.Animal;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("animals") //http://localhost:8080/webservices/webapi/animals
public class AnimalService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> searchAnimal(@PathParam("q") String q) {
        
        if(q == null) { return null; }
        
        Animal a = new Animal();
        a.setCommonName("Monkey");
        a.setLatinName("shit");
        a.setPetName("tim");
        
        List<Animal> list = new ArrayList<Animal>();
        list.add(a);
        
        return list;
    }    
    
}
