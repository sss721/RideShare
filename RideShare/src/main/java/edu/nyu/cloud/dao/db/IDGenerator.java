/**
 * 
 */
package edu.nyu.cloud.dao.db;

/**
 * @author rahulkhanna Date:03-Apr-2016
 */
public interface IDGenerator {

	/**
	 * This function is used to initialize <code>IDGenerator</code> at the
	 * bootstrap of the application with the current value for the given entity.
	 * 
	 * @param value
	 */
	public void initialize(long value);

	/**
	 * @return new ID for an entity.
	 */
	public long getNewId();

	/**
	 * @return the name of the entity.
	 */
	String getEntityName();

}
