package com.cttc.FirstSpringBoot.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.repository.RegisterRepository;
import com.cttc.FirstSpringBoot.repository.UserJPARepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private UserJPARepository userjpaRepository;

	@Autowired
	private EmailService emailService;

	@Value("${image.path}")
	String imagePath;

	public String show() {
		return "cttc";
	}

	// through spring jdbc
//	public Integer userSave(String name, String password, Integer age) {
//		return registerRepository.userRegister(name, password, age);
//
//	}

	// through spring JPA
	public UserEntity userSave(UserEntity userDetails, MultipartFile image) {
//		Random r = new Random();
//		int nextInt = r.nextInt(900000) + 100000;
		System.out.println(image.getOriginalFilename());
		Path copyLocation = Paths.get(imagePath + File.separator + StringUtils.cleanPath(image.getOriginalFilename()));

		try {
			Files.copy(image.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		userDetails.setImageName(image.getOriginalFilename());
		userjpaRepository.save(userDetails);
		UserEntity save = null;
//		emailService.sendSuccessMessage(userDetails.getUserMail(), userDetails.getUserName(), nextInt);
		return save;
	}

}
