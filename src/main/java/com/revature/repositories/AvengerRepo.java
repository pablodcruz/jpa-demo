package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Avenger;

public interface AvengerRepo extends JpaRepository<Avenger, Integer>{

}
