package InternetBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import InternetBank.entity.UsersInfo;
import InternetBank.model.UserInfoDetails;
import InternetBank.repository.UserInfoRepository;

@Service
public class UsersInfoService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersInfo> userInfo = userInfoRepository.findByClientname(username);
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found" + username));
	}

	public String addUser(UsersInfo usersInfo) {
		usersInfo.setPassword(passwordEncoder.encode(usersInfo.getPassword()));
		usersInfo.setClientname(usersInfo.getClientname());
		userInfoRepository.save(usersInfo);
		return "User Add";
	}

}
