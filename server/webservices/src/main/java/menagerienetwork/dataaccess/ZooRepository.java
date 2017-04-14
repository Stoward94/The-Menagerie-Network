package menagerienetwork.dataaccess;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import menagerienetwork.entities.Zoo;
import menagerienetwork.entities.ZooAnimal;

/**
 * @author Luke
 */
public class ZooRepository implements ReadRepository<Zoo> {
    
    private EntityManager em;
 
    public ZooRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Zoo getById(Object id) {
        try{
            Zoo zoo = em.createNamedQuery("Zoo.findById", Zoo.class)
                .setParameter("id", (int)id)
                .getSingleResult();
            
            return zoo;
        }
        catch(PersistenceException ex){
            //Do something with the error...
            //In this case return null, simulating zoo not found.
            return null;
        }
    }

    @Override
    public Collection<Zoo> getAll() {
        try{
            Collection<Zoo> zoos = em.createNamedQuery("Zoo.findAll", Zoo.class)
                .getResultList();
        
            return zoos;
        }
        catch(PersistenceException ex){
            //Do something with the error...
            //In this case return an empty list, naughty!
            return new ArrayList<Zoo>();
        }
    }

    /**
     * Retrieve a collection of animals located at a given zoo
     * @param id of the target zoo
     * @return A collection of real life animals
     */
    public Collection<ZooAnimal> getZooAnimals(Integer id) {
        try{
            Collection<ZooAnimal> animals = em.createNamedQuery("ZooAnimal.findByZoo", ZooAnimal.class)
                    .setParameter("id", new Zoo(id))
                    .getResultList();
            
            return animals;
        }
        catch(PersistenceException ex){
            //Do something with the error...
            //In this case return an empty list, naughty!
            return new ArrayList<ZooAnimal>();
        }
    }
    
}
