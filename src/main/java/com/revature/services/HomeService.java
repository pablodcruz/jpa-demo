package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Home;
import com.revature.repositories.HomeRepo;

@Service
public class HomeService {
	
	private HomeRepo homeRepo;

	@Autowired
	public HomeService(HomeRepo homeRepo) {
		this.homeRepo = homeRepo;
	}
	
	public List<Home> getAllHomes(){
		return homeRepo.findAll();
	}
	
	public Home getHomeById(int id) {
		Optional<Home> opt = homeRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Home getHomeByName(String name) {
		Optional<Home> opt = homeRepo.findByName(name);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Home addOrUpdate(Home home) {
		Home dbHome = homeRepo.save(home);
		return dbHome;
	}
	
	public void destroyHome(int id) {
		Home home = getHomeById(id);
		homeRepo.delete(home);
	}
	
	
}
