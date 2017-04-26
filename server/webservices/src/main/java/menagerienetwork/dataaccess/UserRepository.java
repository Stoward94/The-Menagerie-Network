package menagerienetwork.dataaccess;

import java.util.Collection;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import menagerienetwork.entities.User;
import menagerienetwork.security.Authenticator;
import menagerienetwork.security.PBKDF2Hash;
import menagerienetwork.webservices.RegisterRequest;

/**
 * @author Luke Stoward
 */
public class UserRepository implements ReadRepository<User>,
                                       InsertRepository<User> {
    private final EntityManager em;
    
    public UserRepository(EntityManager em){
        this.em = em;
    }
    
    public boolean registerUser(RegisterRequest model){
        
        try{
            //Generate a hash + salt for the provided password
            Authenticator auth = new Authenticator();
            PBKDF2Hash hash = auth.generateHash(model.getPassword(), null);
            
            //Check we have a hash & salt
            if(hash == null){
                return false;
            }
            
            //Create a user object with the generated hash & salt
            User user = new User(model.getEmail(), hash.getHash(),
                    hash.getSalt(), model.getRole());

            
            insert(user);
        }
        catch(Exception ex){
            return false;
        }
        
        return true;
    }
    
    public User getByEmail(String email){
        try{
            User user = em.createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getSingleResult();
            
            return user;
        }
        catch(NoResultException ex){
            //Log error
            return null;
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public void insert(User entity) {
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

    @Override
    public User getById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
