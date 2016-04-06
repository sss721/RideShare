package edu.nyu.cloud.dao.db;

import java.util.List;


/**
 * The parent for all the Modifiable daos of entities which can be inserted or updated
 * 
 * @author rahul.khanna
 * Date:28-Mar-2016
 * 
 * @param T = Application Object E = Persistent object
 */
public interface BaseModifiableDao<T, E> extends BaseDatabaseDao<T, E> {

	
    public long getNextKey();

    public String getEntityName();

    public void initialize();

    /**
     * Saves the object in the data store.
     * 
     * @param object Object to be saved.
     * @throws RuntimeException If any problem in saving.
     * @throws NullPointerException If any <code>object</code> is <code>null</code>.
     */
    void save(T object);

    /**
     * This function is used to fetch the object based to primary key
     * 
     * @param key
     * @return
     */
    public Object get(Long key);

    /**
     * Saves a list of objects
     * 
     * @param listOfObjects
     */
    void saveAll(List<T> listOfObjects);

    /**
     * Updates the object in the data store.
     * 
     * @param object Object to be saved.
     * @throws RuntimeException If any problem in saving.
     * @throws NullPointerException If any <code>object</code> is <code>null</code>.
     */
    void update(T object);

    /**
     * @param object
     */
    void merge(T object);

    /**
     * Updates a list of objects
     * 
     * @param listOfObjects
     */
    void updateAll(List<T> listOfObjects);

    /**
     * @param listOfObjects
     */
    void mergeAll(List<T> listOfObjects);

    /**
     * This function is used to update the persistent object.
     * @param e
     */
    public void updatePersistent(E e);

    /**
     * This function is used to merge the persistent object.
     * 
     * @param e
     */
    public void mergePersistent(E e);

    /**
     * This function is used to update all the given persistent objects.
     * 
     * @param listOfObjects of Persistent objects. 
     */
    public void updateAllPersistent(List<E> listOfObjects);

    public void mergeAllPersistent(List<E> listOfObjects);

    /**
     * Saves a persistent object.
     * 
     * @param Persistent object
     */
    public void savePersistent(E e);

    /**
     * Saves a list of persistent objects
     * 
     * @param listOfObjects
     */
    public void saveAllPersistent(List<E> listOfObjects);
}
