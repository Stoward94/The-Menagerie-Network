/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork.dataaccess;

import java.util.List;
import menagerienetwork.entities.Zoo;

/**
 *
 * @author Luke
 */
public class ZooRepository implements IRepository<Zoo> {

    private LocalDb db;
    
    public ZooRepository(){
        db = new LocalDb();
    }
    
    @Override
    public void add(Zoo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Zoo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Zoo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zoo FindById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Zoo> All() {
        return db.GetZoos();
    }
    
}
