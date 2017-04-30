package menagerienetwork.dataaccess;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import menagerienetwork.entities.Animal;
import menagerienetwork.entities.Zoo;
import menagerienetwork.entities.ZooAnimal;
import menagerienetwork.webservices.NewZooAnimal;

/**
 * @author Luke Stoward
 */
public class ZooAnimalRepository implements ReadRepository<ZooAnimal>
                                          , InsertRepository<ZooAnimal> {

    private final EntityManager em;
    
    public ZooAnimalRepository(EntityManager em){
        this.em = em;
    }
    
    
    public void registerZooAnimal(NewZooAnimal entity) {
        
        //Take the data transfer object and create the 
        //appropiate class to process further
        ZooAnimal zooAnimal = new ZooAnimal(null
                , entity.getPetName()
                , entity.isMale()
                , entity.getAgeInMonths()
                , new Animal(entity.getSpeciesId())
                , new Zoo(entity.getZooId()));
        
        insert(zooAnimal);
    }
    
    @Override
    public ZooAnimal getById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ZooAnimal> getAll() {
        List<ZooAnimal> zooAnimals = em.createNamedQuery("ZooAnimal.findAll", ZooAnimal.class)
                .getResultList();
        
        return zooAnimals;
    }

    @Override
    public void insert(ZooAnimal entity) {
        
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
