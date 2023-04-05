package CrudQueryWithSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CrudQueryWithSecurity.entity.UserInfo;
import CrudQueryWithSecurity.service.UserInfoService;

@RestController
public class UseInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo);
	}
	
}
