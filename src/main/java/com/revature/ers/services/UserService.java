package com.revature.ers.services;


import com.revature.ers.exceptions.UsernameOrPasswordIncorrectException;
import com.revature.ers.repositories.UserDAO;

import java.util.HashMap;
import java.util.Map;
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
	//public UserService User;

	//private UserDAO ud;

//swap out with actual data base when ready
	public UserService(UserDAO ud) {

		this.ud = ud;
	}


	public User login(User u) {
		return ud.getUserByUserName(u.getUsername());
		// the .get() gets over the extra layer between ud.getByUsername() and .getPassword()

		//if (ud.getByUsername(username).isPresent() && ud.getByUsername(username).get().getPassword().equals(password)) {

			/*
			User u = new User(username, password);
			ud.userAuth(username, password);
			//From the service, we would make our database call to actually store this user away
			//ud.userAuth(username, password);
			if (ud == null) {
				throw new UsernameOrPasswordIncorrectException();
			}
*/
		}


	public static class GlobalUsernameStore {
		private Map<String, Object> globalStore;

		private GlobalUsernameStore(){
			//private constructor -
			// use getStore();
		}

		public Map<String, Object> getStore() {
			if(globalStore == null) {
				globalStore = new HashMap<String, Object>();
			}

			return globalStore;
		}


		//potentially where could go wrong on storing the username
		public void add(String username, Object obj) {
			globalStore.put(username, obj);
		}

		public Object getObject(String username) {
			return globalStore.get(username);
		}
	}

	public User register(User u){
		/*
		User u = new User(username, password);
		//From the service, we would make our database call to actually store this user away
		ud.saveUser(u);
		if (ud == null) {
			throw new NullPointerException();
		}
		 */
		return ud.createUser(u);
	}
	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */

	public User update(User u) {
		return ud.updateUser(u);
	}

	public void delete(User u) {
		ud.deleteUser(u);
	}


}
