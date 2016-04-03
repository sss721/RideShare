/**
 * 
 */
package edu.nyu.cloud.dao.db.hibernate;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import edu.nyu.cloud.dao.db.IDGenerator;

/**
 * This class is used to get a new ID for an Entity.
 * 
 * @author rahulkhanna Date:03-Apr-2016
 */
public class UniqueIdGenerator implements IDGenerator {

	private static final Logger LOG = Logger.getLogger(UniqueIdGenerator.class.getName());
	private AtomicLong currentId;
	private final String entityName;

	/**
	 * @param entityName
	 *            for which ID will be generated.
	 */
	public UniqueIdGenerator(String entityName) {
		super();
		this.entityName = entityName;
	}

	@Override
	public void initialize(long value) {
		LOG.info("Initializing ID generator for entity "+getEntityName());
		currentId = new AtomicLong();
		currentId.set(value);
		LOG.info("Initialized "+getEntityName()+" with ID "+currentId.get());
	}

	@Override
	public long getNewId() {
		return currentId.incrementAndGet();
	}

	@Override
	public String getEntityName() {
		return entityName;
	}

}
