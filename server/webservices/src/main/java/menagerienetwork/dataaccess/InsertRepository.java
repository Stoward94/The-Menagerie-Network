package menagerienetwork.dataaccess;

public interface InsertRepository<T> {
    
    /**
     * Insert a new entity of type T 
     * @param entity
     */
    void insert(T entity);
}
