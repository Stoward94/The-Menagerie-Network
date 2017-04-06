package menagerienetwork.dataaccess;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import menagerienetwork.entities.Animal;

public class AnimalRepository implements ReadRepository<Animal> {    
  
    private final EntityManager em;
    
    public AnimalRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Animal getById(Object id) {
        
        Animal animal = em.createNamedQuery("Animal.findById", Animal.class)
                .setParameter("id", (int)id)
                .getSingleResult();
        
        return animal;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
