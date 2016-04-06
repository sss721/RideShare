/**
 * 
 */
package edu.nyu.cloud.user.dao.db.hibernate;

import org.hibernate.SessionFactory;

import edu.nyu.cloud.beans.UserProfile;
import edu.nyu.cloud.dao.db.IDGenerator;
import edu.nyu.cloud.dao.db.hibernate.ModifiableCommonDBDao;
import edu.nyu.cloud.user.dao.db.UserDao;

/**
 * @author rahulkhanna
 * Date:06-Apr-2016
 */
public class UserDaoImpl extends ModifiableCommonDBDao<UserProfile, UserProfile> implements UserDao {

	
	public UserDaoImpl(SessionFactory sessionFactory, String entityName, IDGenerator idGenerator) {
		super(sessionFactory, entityName, idGenerator);
	}

	@Override
	public void persistUserProfie(UserProfile profile) {
		save(profile);
	}

	@Override
	public UserProfile getUserProfileByUserId(String userId) {
		//TODO: implement fetching of user profile.
		return null;
	}

}
