/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import menagerienetwork.dataaccess.ZooRepository;
import menagerienetwork.entities.Zoo;

/**
 * REST Web Service
 *
 * @author Luke
 */
@Path("/animals")
public class AnimalsService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalsService
     */
    public AnimalsService() {
    }

    /**
     * Retrieves representation of an instance of menagerienetwork.AnimalsService
     * @param q
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{q}")
    public List<Zoo> search(@PathParam("q") String q) {
        //TODO: Search for matching animals.
        ZooRepository repo = new ZooRepository();
        
        List<Zoo> zoos = repo.All();
        
        return zoos;
    }

    /**
     * PUT method for updating or creating an instance of AnimalsService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
