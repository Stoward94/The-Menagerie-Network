package menagerienetwork.dataaccess;

import java.util.Collection;

public interface RemoveRepository<T> {
    
    /**
     * Remove a single entity of type T
     * @param entity
     */
    void remove(T entity);
    
    /**
     * Remove a collection of entities of type T
     * @param entities
     */
    void remove(Collection<T> entities);
}
