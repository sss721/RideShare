package edu.nyu.cloud.dao.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import edu.nyu.cloud.dao.db.BaseDatabaseDao;

/**
 * The base class for all the DAOs. It encapsulate the session factory and
 * expose methods to get the Session and StateLessSessions
 * 
 * @author rahulkhanna Date:03-Apr-2016
 * @param <T>
 * @param <E>
 */
public class CommonDBDao<T, E> implements BaseDatabaseDao<T, E> {

	private SessionFactory sessionFactory;

	public CommonDBDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Returns the current session. Do not close the session as it is managed by
	 * spring.
	 * 
	 * @return <code>Session</code>
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Returns the current session. Do not close the session as it is managed by
	 * spring.
	 * 
	 * @return Session
	 */
	protected Session openSession() {
		return sessionFactory.openSession();
	}

	/**
	 * Returns a StateLessSession which can be used in cases where we do not
	 * need additional benefits like first level cache. Cascading doesn't work
	 * with it.
	 * 
	 * @return StatelessSession
	 */
	protected StatelessSession getStateLessSession() {
		return sessionFactory.openStatelessSession();
	}

}
