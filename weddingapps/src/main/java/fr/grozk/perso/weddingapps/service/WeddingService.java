package fr.grozk.perso.weddingapps.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grozk.perso.weddingapps.entity.WeddingEntity;
import fr.grozk.perso.weddingapps.entity.repository.WeddingRepository;
import fr.grozk.perso.weddingapps.model.Wedding;

@Service
public class WeddingService {

	@Autowired
	WeddingRepository weddingRepository;

	@Autowired
	FileUtilService fileUtilService;

	@Autowired
	RandomTokenService randomTokenService;

	public void manageWedding(Wedding wedding) throws IOException {

		// generate token
		wedding.setIdPublic(randomTokenService.generateUniqueRandomToken());
		
		// Creation Wedding in DB
		WeddingEntity weddingEntity = new WeddingEntity(wedding);
		weddingRepository.save(weddingEntity);
		
		// Repository for pictures
		fileUtilService.createDirectory("F:\\image_wedding_app\\"+weddingEntity.getId());
		
	}

}
