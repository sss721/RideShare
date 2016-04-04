/**
 * 
 */
package edu.nyu.cloud.service.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nyu.cloud.service.beans.IncomingPoolRequest;

/**
 * @author rahulkhanna
 * Date:04-Apr-2016
 */

@RestController
public class RideShareController {

	@RequestMapping("/newRideShare")
	public void openNewRideSharingRequest(@RequestBody IncomingPoolRequest request){
		
	}
	
	
}
