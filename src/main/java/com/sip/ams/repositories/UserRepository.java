package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sip.ams.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	User findByName(String name);
}
