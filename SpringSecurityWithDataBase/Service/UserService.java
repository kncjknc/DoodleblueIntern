package CrudQueryWithSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import CrudQueryWithSecurity.entity.UserInfo;
import CrudQueryWithSecurity.model.UserInfoDetails;
import CrudQueryWithSecurity.repository.UserInfoRepository;



@Service
public  class UserInfoService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
       Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
		
       return userInfo.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
                
	}


	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		 userInfoRepository.save(userInfo);
		 return "New User Added SuccessFully!";
	}

}
