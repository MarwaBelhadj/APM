package com.sip.ams.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.repositories.RoleRepository;
import com.sip.ams.repositories.UserRepository;

@Service("userService")
public class UserService {
	
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
  //Injection des dépendances
    @Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
    public User findUserByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    public void saveUser(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setActive(0);
    	Role userRole= roleRepository.findByRole("USER");
    	user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    	userRepository.save(user);
    }

	

}
