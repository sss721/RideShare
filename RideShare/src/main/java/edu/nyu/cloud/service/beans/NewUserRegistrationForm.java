package edu.nyu.cloud.service.beans;

/**
 * @author rahulkhanna Date:04-Apr-2016
 */
public class NewUserRegistrationForm {

	private final int age;
	private final String firstName;
	private final String lastName;
	private final String userId;
	private final String password;
	private final String phoneNumber;

	/**
	 * Default constructor is need for Jackson to create an instance of the
	 * class.
	 */
	public NewUserRegistrationForm() {
		this(0, null, null, null, null, null);
	}

	/**
	 * Constructor
	 * 
	 * @param age
	 * @param firstName
	 * @param lastName
	 * @param userId
	 * @param password
	 * @param phoneNumber
	 */
	public NewUserRegistrationForm(int age, String firstName, String lastName, String userId, String password,
			String phoneNumber) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
