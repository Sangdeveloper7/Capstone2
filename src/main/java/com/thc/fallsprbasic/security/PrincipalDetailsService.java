package com.thc.fallsprbasic.security;

import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.repository.UserRepository;
import com.thc.fallsprbasic.exception.NoMatchingDataException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public PrincipalDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
    /**
	 *  principalDetails 생성을 위한 함수.
	 *  username으로 user 조회, principalDetails 생성
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new NoMatchingDataException("username : " + email);
		}
		return new PrincipalDetails(user);
	}
	
}