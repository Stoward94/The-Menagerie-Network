package menagerienetwork.dataaccess;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import menagerienetwork.entities.Zoo;
import menagerienetwork.entities.ZooAnimal;

/**
 * @author Luke
 */
public class ZooRepository implements ReadRepository<Zoo>,
                                      InsertRepository<Zoo>{
    
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
    
    public boolean registerZoo(Zoo model){
        
        //Perform some entity validation here...
        
        //Set id to null incase its been overposted
        model.setId(null);
        
        try{
            insert(model);
            return true;
        }       
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public void insert(Zoo entity) {        
        try{
            em.persist(entity);
            em.flush(); //Necessary to force FK constraint errors...
        }        
        catch(EntityExistsException ex){
            //(Log error or something)
            throw ex;
        }
        catch(PersistenceException ex){
            //Potential foreign key contstraint errors (Log error or something)
            throw ex;
        }
        catch(Exception ex){
            //Handle any other error. (Log error or something)
            throw ex;
        }
    }
    
}
