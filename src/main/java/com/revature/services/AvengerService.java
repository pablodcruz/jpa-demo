package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerRepo;
import com.revature.repositories.HomeRepo;

@Service
public class AvengerService {
	
	private AvengerRepo avengerRepo;
	private HomeService homeService;

	@Autowired
	public AvengerService(AvengerRepo AvengerRepo, HomeService homeService) {
		this.avengerRepo = AvengerRepo;
		this.homeService=homeService;
	}
	
	public List<Avenger> getAllAvengers(){
		return avengerRepo.findAll();
	}
	
	public Avenger getAvengerById(int id) {
		Optional<Avenger> opt = avengerRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Avenger addOrUpdate(Avenger avenger) {
		if(avenger.getHome()!=null&&avenger.getHome().getId()!=0) {
			avenger.setHome(homeService.getHomeById(avenger.getHome().getId()));
		}
		Avenger dbAvenger = avengerRepo.save(avenger);
		return dbAvenger;
	}
	
	public void destroyAvenger(int id) {
		Avenger avenger = getAvengerById(id);
		avengerRepo.delete(avenger);
	}

}
