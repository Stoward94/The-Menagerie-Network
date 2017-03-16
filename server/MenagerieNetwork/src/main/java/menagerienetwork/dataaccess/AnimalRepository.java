/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork.dataaccess;

import java.util.List;
import menagerienetwork.entities.Animal;

/**
 *
 * @author Luke
 */
public class AnimalRepository implements IRepository<Animal> {

    private LocalDb db;
    
    public AnimalRepository(){
        db = new LocalDb();
    }
    
    @Override
    public void add(Animal entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Animal entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Animal entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animal FindById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> All() {
        List<Animal> animals = db.GetAnimals();
        
        return animals;
    }

}
