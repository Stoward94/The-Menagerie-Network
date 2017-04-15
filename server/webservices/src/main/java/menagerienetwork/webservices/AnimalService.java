package menagerienetwork.webservices;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import menagerienetwork.entities.Animal;
import menagerienetwork.dataaccess.AnimalRepository;

/**
 * @author Luke Stoward
 */
@Stateless
@Path("animal")
public class AnimalService {

    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;

    public AnimalService(){}

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void create(Animal entity) {}

    
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void edit(@PathParam("id") Integer id, Animal entity) { }

    
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Integer id) {}
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal find(@PathParam("id") Integer id) {
        
        AnimalRepository repo = new AnimalRepository(em);
        Animal animal = repo.getById(id);
        
        return animal;
    }
    
    @GET
    @Path("/search/{q}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AnimalSearchResult> find(@PathParam("q") String q) {
        
        AnimalRepository repo = new AnimalRepository(em);
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
}
