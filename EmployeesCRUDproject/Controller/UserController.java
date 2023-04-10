package EmployeeManageMentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EmployeeManageMentSystem.entity.UsersInfo;
import EmployeeManageMentSystem.model.AuthToken;
import EmployeeManageMentSystem.service.JwtService;
import EmployeeManageMentSystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/addUser")
	public String addUser(@RequestBody UsersInfo userInfo) {
		return userService.addUser(userInfo);

	}

	@PostMapping("/getTokens")
	public String getToken(@RequestBody AuthToken authToken) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authToken.getUsername(), authToken.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authToken.getUsername());

		} else {
			throw new UsernameNotFoundException("Invalid Request !");
		}

	}

}
