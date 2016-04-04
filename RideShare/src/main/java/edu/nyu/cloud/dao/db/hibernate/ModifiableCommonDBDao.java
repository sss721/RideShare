/**
 * 
 */
package edu.nyu.cloud.dao.db.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import edu.nyu.cloud.dao.db.BaseModifiableDao;
import edu.nyu.cloud.dao.db.IDGenerator;

/**
 * @author rahulkhanna Date:03-Apr-2016
 * @param <T>
 * @param <E>
 */
public class ModifiableCommonDBDao<T, E> extends CommonDBDao<T, E> implements BaseModifiableDao<T, E> {

	private final String entityName;
	private final IDGenerator idGenerator;
	private static final Logger LOG = Logger.getLogger(ModifiableCommonDBDao.class.getName());

	public ModifiableCommonDBDao(SessionFactory sessionFactory, String entityName, IDGenerator idGenerator) {
		super(sessionFactory);
		this.entityName = entityName;
		this.idGenerator = idGenerator;
	}

	@Override
	public long getNextKey() {
		return getIdGenerator().getNewId();
	}

	@Override
	public String getEntityName() {
		return entityName;
	}

	@Override
	public void initialize() {
		if (idGenerator != null) {
			Long result = initializeIdgeneratorWithGivenFieldsName(idGenerator, "key");
			LOG.info("Initialized " + idGenerator.getEntityName() + " entity with id :" + result);
		}
	}

	/**
	 * This function is used to initialize the <code>IDGenerator</code> for the
	 * given <code>entityName</code>
	 * 
	 * @param idGenerator
	 * @param fieldName
	 *            column name of the id for that particular entity.
	 * @return
	 */
	private Long initializeIdgeneratorWithGivenFieldsName(IDGenerator idGenerator, String fieldName) {
		long value = 0;
		StatelessSession session = getStateLessSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(getEntityName()).setProjection(Projections.max(fieldName));

		Object result = criteria.uniqueResult();

		if (result == null || result instanceof Integer) {
			idGenerator.initialize(0);
		} else {
			value = (long) result;
			idGenerator.initialize(value);
		}
		transaction.commit();
		session.close();

		return value;
	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object get(Long key) {
		return getSession().get(getEntityName(), key);
	}

	@Override
	public void saveAll(List<T> listOfObjects) {
		for (T t : listOfObjects) {
			save(t);
		}
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
		for (T t : listOfObjects) {
			update(t);
		}
	}

	@Override
	public void mergeAll(List<T> listOfObjects) {
		for (T t : listOfObjects) {
			merge(t);
		}
	}

	@Override
	public void updatePersistent(E e) {
		getSession().update(getEntityName(), e);
	}

	@Override
	public void mergePersistent(E e) {
		getSession().merge(getEntityName(), e);
	}

	@Override
	public void updateAllPersistent(List<E> listOfObjects) {
		for (E e : listOfObjects) {
			updatePersistent(e);
		}
	}

	@Override
	public void mergeAllPersistent(List<E> listOfObjects) {
		for (E e : listOfObjects) {
			mergePersistent(e);
		}
	}

	@Override
	public void savePersistent(E e) {
		getSession().persist(getEntityName(), e);
	}

	@Override
	public void saveAllPersistent(List<E> listOfObjects) {
		for (E e : listOfObjects) {
			savePersistent(e);
		}
	}

	/**
	 * @return the idGenerator
	 */
	public IDGenerator getIdGenerator() {
		return idGenerator;
	}

}
