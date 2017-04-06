package menagerienetwork.dataaccess;

public interface UpdateRepository<T> {
    
    /**
     * Update an entity of type T
     * @param entity
     */
    void update(T entity);
}
