package SpringSecurityInJwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringSecurityInJwt.entity.UserInfo;
import SpringSecurityInJwt.model.AuthTokenclass;
import SpringSecurityInJwt.service.JwtService;
import SpringSecurityInJwt.service.UserInfoService;

@RestController
public class UseInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/addUser")
	public String addUsers(@RequestBody UserInfo userInfo) {
		return userInfoService.addUsers(userInfo);
	}

	@PostMapping("/authenticates")
	public String authenGetToken(@RequestBody AuthTokenclass authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassWord()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid User !");
		}

	}

}
