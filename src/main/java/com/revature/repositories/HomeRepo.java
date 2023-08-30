package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Home;

public interface HomeRepo extends JpaRepository<Home, Integer>{
	
	Optional<Home> findByName(String name);

}
