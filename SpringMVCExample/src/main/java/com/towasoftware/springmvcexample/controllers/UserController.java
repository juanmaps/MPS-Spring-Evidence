package com.towasoftware.springmvcexample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.towasoftware.springmvcexample.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(Model model, User user) {
		model.addAttribute("mensaje", "Usuario creado exitosamente");
		return "user/ok";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(Model model, User user, @PathVariable Integer id) {

		model.addAttribute("mensaje", "Usuario con id: " + id + " actualizado exitosamente");

		return "user/ok";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("mensaje", "son 10 usuarios");
		model.addAttribute("usuarios", this.generateList(10));
		return "user/ok";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUserById(Model model, @PathVariable Integer id) {

		User u = null;
		for (User user : this.generateList(50)) {
			if (user.getId() == id) {
				u = user;
				break;
			}
		}

		if (u != null) {
			model.addAttribute("mensaje", "Usuario con id: " + id);
			model.addAttribute("usuario", u);
		} else {
			model.addAttribute("mensaje", "Usuario con id: " + id + " No encontrado");
		}

		return "user/ok";
	}

	// Utilería
	private List<User> generateList(int limite) {

		List<User> list = new ArrayList<User>();

		for (int i = 1; i <= limite; i++) {

			User u = new User(i, "name " + i, "lastname " + i, "address " + i);

			list.add(u);

		}

		return list;

	}

}
