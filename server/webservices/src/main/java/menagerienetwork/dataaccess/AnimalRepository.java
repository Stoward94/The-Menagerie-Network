package menagerienetwork.dataaccess;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import menagerienetwork.entities.Animal;

public class AnimalRepository implements ReadRepository<Animal>
                                        ,InsertRepository<Animal>{    
  
    private final EntityManager em;
    
    public AnimalRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Animal getById(Object id) {
        try{
            Animal animal = em.createNamedQuery("Animal.findById", Animal.class)
                .setParameter("id", (int)id)
                .getSingleResult();
        
            return animal;
        }
        catch(NoResultException ex){
            //No result found, log error...
            return null;
        }
        
    }
    
    /**
     * Find animals using a search term. Matched against the common
     * and scientific names.
     * @param term
     * @return
     */
    public Collection<Animal> getByCommonScientificName(String term){
        
        String likeTerm = ("%" + term + "%");
        
        List<Animal> animals = em.createNamedQuery("Animal.findByCommonScientificName", Animal.class)
                .setParameter("search", likeTerm)
                .setMaxResults(10)
                .getResultList();
        
        return animals;
    }

    @Override
    public Collection<Animal> getAll() {
        List<Animal> animals = em.createNamedQuery("Animal.findAll", Animal.class)
                .getResultList();
        
        return animals;
    }

    /**
     * Register a new species of animal to the menagerie network
     * @param entity
     */
    public void registerSpecies(Animal entity) {
        
        //Perform some logic, or entity validation
        //Make sure the id value is null, preventing manual input
        entity.setId(null);
        
        //Pass to the insert method
        insert(entity);
    }

    @Override
    public void insert(Animal entity) {
        try{
            em.persist(entity);
        }        
        catch(PersistenceException ex){
            //TODO: Log error
            throw ex;
        }
        catch(ConstraintViolationException ex){
            //TODO: Log error
            throw ex;
        }
        catch(Exception ex){
            //TODO: Log error
            throw ex;
        }
    }    
}
