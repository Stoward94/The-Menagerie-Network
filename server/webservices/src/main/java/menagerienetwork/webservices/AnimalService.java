package menagerienetwork.webservices;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ValidationException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import menagerienetwork.entities.Animal;
import menagerienetwork.dataaccess.AnimalRepository;
import menagerienetwork.dataaccess.ZooAnimalRepository;

/**
 * @author Luke Stoward
 */
@Stateless
@Path("animal")
public class AnimalService {

    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;
    
    private AnimalRepository repo;
    private ZooAnimalRepository zRepo;

    public AnimalService(){}
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal find(@PathParam("id") Integer id) {
        
        repo = new AnimalRepository(em);
        Animal animal = repo.getById(id);
        
        return animal;
    }
    
    @GET
    @Path("/search/{q}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AnimalSearchResult> find(@PathParam("q") String q) {
        
        repo = new AnimalRepository(em);
        Collection<Animal> animals = repo.getByCommonScientificName(q);
        
        //Convert to smaller class
        ArrayList<AnimalSearchResult> results =
                new ArrayList(animals.size());
        
        for(Animal a : animals){
            AnimalSearchResult r = new AnimalSearchResult();
            r.setId(a.getId());
            r.setCommonName(a.getCommonName());
            r.setScientificName(a.getScientificName());
            
            results.add(r);
        }
        
        return results;
    }
    
    /**
     * Register a new species of animal
     * @param entity the properties of the new species
     * @return Response object
     */
    @POST
    @Path("/species")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSpecies(Animal entity) {
        
        //Basic entity checking/validation
        if(entity == null || !entity.isValid())
            webExceptionHandler("Please check the data provided", 400);
        
        try{
            //Handle the new animal
            repo = new AnimalRepository(em);
            repo.registerSpecies(entity);
            
            //Return 201 Created.
            return Response.created(null).build();            
        }
        catch(ValidationException ex){
            //Entity violated validation, likely database level
            webExceptionHandler(ex.getMessage(), 400);
        }
        catch(Exception ex){
            //For any error return 500;     
            webExceptionHandler(ex.getMessage(), 500);
        }
        return null;
    }
    
    
    @POST
    @Path("/zooanimal")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addZooAnimal(NewZooAnimal entity) {
        
        //Basic entity checking/validation
        if(entity == null || !entity.isValid())
            webExceptionHandler("Please check the data provided", 400);
        
        try{            
            //Handle the new animal
            zRepo = new ZooAnimalRepository(em);
            zRepo.registerZooAnimal(entity);
            
            //Return 201 Created.
            return Response.created(null).build();          
        }
        catch(PersistenceException ex){
            //Conflict error
            webExceptionHandler(ex.getMessage(), 409);
        }
        catch(Exception ex){
            //For any error return 500;            
            webExceptionHandler(ex.getMessage(), 500);
        }
        
        return null;
    }
    
    /**
     * Helper method to throw the most relevant error, 
     * which is returned as a HTTP response.
     * @param msg error message to be thrown
     * @param statusCode status code to be thrown
     */
    private void webExceptionHandler(String msg, Integer statusCode){
        Response.Status status;
        
        switch(statusCode){
            case 400: status = Response.Status.BAD_REQUEST;
                break;
            case 409: status = Response.Status.CONFLICT;
                break;
            default: status = Response.Status.INTERNAL_SERVER_ERROR;
                break;
        }
        
        throw new WebApplicationException(msg, status);
    }
}
