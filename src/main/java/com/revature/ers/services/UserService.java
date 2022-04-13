package com.revature.ers.services;


import com.revature.ers.exceptions.UsernameOrPasswordIncorrectException;
import com.revature.ers.repositories.UserDAO;
import java.util.Optional;

import com.revature.ers.models.User;



/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {
	//public static Object Login;
	//never intialized refactored it
	public UserDAO ud;

	//working on authenticate user with database
	public UserService User;

	//private UserDAO ud;

//swap out with actual data base when ready
	public UserService(UserDAO ud) {

		this.ud = ud;
	}


	public User login(String username, String password) {
		// the .get() gets over the extra layer between ud.getByUsername() and .getPassword()
		if(ud.getByUsername(username).isPresent() && ud.getByUsername(username).get().getPassword().equals(password)) {

		} else {
			throw new UsernameOrPasswordIncorrectException();
		}
		return null;
		//return User.User(username, password);
	}


	public User register(String username, String password){

		User u = new User(username, password);
		//From the service, we would make our database call to actually store this user away
		ud.saveUser(u);
		if (ud == null) {
			throw new NullPointerException();
		}
		return u;
	}
	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}
/*
	public UserLogin() {

	}

 */
}
