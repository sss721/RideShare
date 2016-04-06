/**
 * 
 */
package edu.nyu.cloud.service.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.nyu.cloud.beans.Route;
import edu.nyu.cloud.google.service.MapService;
import edu.nyu.cloud.newride.NewRideCreator;
import edu.nyu.cloud.service.beans.IncomingPoolRequest;
import edu.nyu.cloud.service.beans.NewRideSharingRequest;
import edu.nyu.cloud.service.beans.NewUserRegistrationForm;

/**
 * This class represents the controller for the app.
 * 
 * @author rahulkhanna Date:04-Apr-2016
 */

@RestController
public class RideShareController {

	@SuppressWarnings("unused")
	private static final Logger LOG = (Logger) Logger.getLogger(RideShareController.class.getName());
	private final NewRideCreator rideCreator;
	private final MapService mapService;

	/**
	 * Constructor
	 * 
	 * @param rideCreator
	 */
	public RideShareController(NewRideCreator rideCreator, MapService mapService) {
		super();
		this.rideCreator = rideCreator;
		this.mapService = mapService;
	}

	public NewRideCreator getRideCreator() {
		return rideCreator;
	}

	public MapService getMapService() {
		return mapService;
	}

	/**
	 * This method is called when the user has selected the favorable route for
	 * the new pool request.
	 * 
	 * @param newPoolRequest
	 */
	@RequestMapping(value = "/newpoolrequest", method = { RequestMethod.POST, RequestMethod.GET })
	public void openNewRideSharingRequest(@RequestBody IncomingPoolRequest newPoolRequest) {
		getRideCreator().createNewRideForPool(newPoolRequest);
	}

	/**
	 * This is called when a new user registration request comes in.
	 * 
	 * @param newUserData
	 */
	@RequestMapping(value = "/newuser", method = { RequestMethod.POST, RequestMethod.GET })
	public void registerNewUser(@RequestBody(required = false) NewUserRegistrationForm newUserData) {
		System.out.println("incoming new userId = " + newUserData.getFirstName());
	}

	/**
	 * This function is called when a user wanted to open a new pool request.
	 * 
	 * @param newPoolRequestToSearchRoutes
	 * @return List of <code>Routes</code> which are will be selected by the
	 *         user defining the route which will be followed by the cab driver.
	 */
	@RequestMapping(value = "/searchRoutesForNewCarPoolRequest", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseEntity<List<Route>> fetchRoutesForNewRideRegistration(
			@RequestBody IncomingPoolRequest newPoolRequestToSearchRoutes) {
		return new ResponseEntity<List<Route>>(mapService.fetchPossibleRoutes(newPoolRequestToSearchRoutes.getSource(),
				newPoolRequestToSearchRoutes.getDestination()), HttpStatus.FOUND);
	}

	/**
	 * This function is called when a user wants to search for already opened
	 * car pool request between source and destination.
	 * 
	 * @param newRideRequest
	 */
	@RequestMapping(value = "/searchCarForPooling", method = { RequestMethod.POST, RequestMethod.GET })
	public void searchNewRideToShare(@RequestBody NewRideSharingRequest newRideRequest) {
		
	}

}
