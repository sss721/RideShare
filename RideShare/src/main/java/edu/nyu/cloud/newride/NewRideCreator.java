/**
 * 
 */
package edu.nyu.cloud.newride;

import edu.nyu.cloud.beans.NewRide;
import edu.nyu.cloud.newride.dao.NewRideDao;
import edu.nyu.cloud.service.beans.IncomingPoolRequest;

/**
 * This class is used to create a new ride which will be shared by other users.
 * 
 * @author rahulkhanna
 * Date:05-Apr-2016
 */
public class NewRideCreator {

	private final NewRideDao dao;
	
	/**
	 * Constructor 
	 * 
	 * @param dao
	 */
	public NewRideCreator(NewRideDao dao) {
		super();
		this.dao = dao;
	}

	public void createNewRideForPool(IncomingPoolRequest newPoolRequest) {
		NewRide ride  = new NewRide(newPoolRequest.getUserId(), newPoolRequest.getSource(), newPoolRequest.getDestination(), newPoolRequest.getDate()
				,null //possibleRoutes
				,0// selectedRouteIndex);
				);
		
	}

	
	
}
