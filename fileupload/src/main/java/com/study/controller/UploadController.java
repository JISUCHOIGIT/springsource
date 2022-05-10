package com.study.controller;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import oracle.sql.DATE;

@Slf4j
@Controller
public class UploadController {
	
	@GetMapping("/uploadform")
	public void uploadForm() {
		log.info("upload 폼 요청");
	}
	
	
	// type=file에 들어가있는 값 가져오기
	// uploadform.jps uploadFile 맞추기
	@PostMapping("/uploadform")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		
		String uploadPath = "d:\\upload";
		
		for(MultipartFile f : uploadFile) {
			log.info("파일명 : " +f.getOriginalFilename());
			log.info("파일크기 :" +f.getSize()); 
			
			
			try {
				File save = new File(uploadPath,f.getOriginalFilename());
				//파일저장
				f.transferTo(save);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		}
	}
