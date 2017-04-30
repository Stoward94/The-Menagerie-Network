package menagerienetwork.webservices;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import menagerienetwork.annotations.RoleSecured;

import menagerienetwork.entities.Zoo;
import menagerienetwork.entities.ZooAnimal;
import menagerienetwork.dataaccess.ZooRepository;

/**
 * @author Luke Stoward
 */
@Stateless
@Path("zoo")
public class ZooService {
    
    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;
    
    private ZooRepository repo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Zoo> getAllZoos() {       
        repo = new ZooRepository(em);
        Collection<Zoo> zoos = repo.getAll();
        
        return zoos;
    }
    
    @POST
    @RoleSecured("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createZoo(Zoo model) {       
        repo = new ZooRepository(em);
        boolean success = repo.registerZoo(model);
        
        if(success)
            return Response.created(null).build();
        else{
            return Response.serverError().build();
        }        
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Zoo getZoo(@PathParam("id") Integer id) {
        repo = new ZooRepository(em);
        Zoo zoo = repo.getById(id);
        
        return zoo;
    }
    
    @GET
    @Path("{id}/animals")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ZooAnimal> getAnimalsAtZoo(@PathParam("id") Integer id) {
        repo = new ZooRepository(em);
        Collection<ZooAnimal> animals = repo.getZooAnimals(id);
        
        return animals;
    }   
}
