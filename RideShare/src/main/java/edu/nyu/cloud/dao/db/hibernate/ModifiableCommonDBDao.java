/**
 * 
 */
package edu.nyu.cloud.dao.db.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import edu.nyu.cloud.dao.db.BaseModifiableDao;

/**
 * @author rahulkhanna
 * Date:03-Apr-2016
 * @param <T>
 * @param <E>
 */
public class ModifiableCommonDBDao<T, E> extends CommonDBDao<T, E>  implements BaseModifiableDao<T, E>{

	private final String entityName;
	
	public ModifiableCommonDBDao(SessionFactory sessionFactory, String entityName) {
		super(sessionFactory);
		this.entityName = entityName;
	}

	@Override
	public long getNextKey() {
		return 0;
	}

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(Long key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<T> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAll(List<T> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mergeAll(List<T> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePersistent(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mergePersistent(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAllPersistent(List<E> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mergeAllPersistent(List<E> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePersistent(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAllPersistent(List<E> listOfObjects) {
		// TODO Auto-generated method stub
		
	}

}
