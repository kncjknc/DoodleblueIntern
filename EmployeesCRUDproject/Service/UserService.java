package EmployeeManageMentSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import EmployeeManageMentSystem.entity.UsersInfo;
import EmployeeManageMentSystem.model.UserInfoDetails;
import EmployeeManageMentSystem.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersInfo> usersInfo = userRepository.findByusername(username);
		return usersInfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Use" + username));
	}

	public String addUser(UsersInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepository.save(userInfo);
		return "User Added Successfully !";

	}

}
