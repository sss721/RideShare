package edu.nyu.cloud.beans;

/**
 * This class is used to capture user information which will be captured during sign-up.
 * 
 * @author rahul.khanna
 * Date:28-Mar-2016
 */
public class UserProfile {

	
	private final int id;
	private final String userName;
	private final String userPassword;
	private final String userAddress;
	private final String firstName;
	private final String lastName;
	private final String phoneNumber;

	/**
	 * Constructor
	 *  
	 * @param userName
	 * @param userPassword
	 * @param userAddress
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public UserProfile(int id,String userName, String userPassword, String userAddress, String firstName, String lastName,
			String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
