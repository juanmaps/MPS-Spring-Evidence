package com.towasoftware.springmvcexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.towasoftware.springmvcexample.model.User;
import com.towasoftware.springmvcexample.services.UserService;

@Controller
@RequestMapping(value = "/mobile/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MobileUserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {

		this.userService.save(user);

		return user;

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {

		List<User> lstUsers = this.userService.getAll();

		return lstUsers;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable Long id) {

		User user = this.userService.findById(id);

		return user;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable Integer id) {

		user.setId(id);
		this.userService.update(user);

		return user;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteUser(@PathVariable Long id) {

		User user = this.userService.findById(id);

		if (user != null) {
			
			this.userService.delete(user);

			return true;
			
		} else {
			
			return false;
			
		}

	}
	
	public static void main(String[] args) {
		
	}

}
