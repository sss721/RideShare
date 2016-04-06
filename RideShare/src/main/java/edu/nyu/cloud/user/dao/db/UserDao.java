package edu.nyu.cloud.user.dao.db;

import edu.nyu.cloud.beans.UserProfile;
import edu.nyu.cloud.dao.db.BaseDatabaseDao;

public interface UserDao extends BaseDatabaseDao<UserProfile, UserProfile> {

	/**
	 * This function is used to persist the new user profile.
	 * 
	 * @param profile
	 */
	public void persistUserProfie(UserProfile profile);
	
	/**
	 * This function is used to fetch user profile by userId.
	 * 
	 * @param userId
	 * @return UserProfile
	 */
	public UserProfile getUserProfileByUserId(String userId);
	
}
