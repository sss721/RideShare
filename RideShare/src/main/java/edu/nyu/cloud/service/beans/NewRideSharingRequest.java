/**
 * 
 */
package edu.nyu.cloud.service.beans;

import java.util.Date;

/**
 * This class represents a new request in search for ride. 
 * 
 * @author rahulkhanna
 * Date:05-Apr-2016
 */
public class NewRideSharingRequest {
	
	private final String userId;
	private final String source;
	private final String destination;
	private final Date date;
	
	public NewRideSharingRequest(){
		this(null,null,null,null);
	}
	
	/**
	 * Constructor 
	 * 
	 * @param userId
	 * @param source
	 * @param destination
	 * @param date
	 */
	public NewRideSharingRequest(String userId, String source, String destination, Date date) {
		super();
		this.userId = userId;
		this.source = source;
		this.destination = destination;
		this.date = date;
	}
	public String getUserId() {
		return userId;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public Date getDate() {
		return date;
	}
	
	
	
	
}
