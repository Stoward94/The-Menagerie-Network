package menagerienetwork.dataaccess;

import java.util.Collection;

public interface ReadRepository<T> {

    /**
     * Get single object by id
     * @param id
     * @return instance of type T or null
     */
    T getById(Object id);
    
    /**
     * Get all objects
     * @return Collection of type T or null
     */
    Collection<T> getAll();
}
