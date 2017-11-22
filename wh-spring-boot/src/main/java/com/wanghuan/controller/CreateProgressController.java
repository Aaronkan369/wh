package com.wanghuan.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.service.ProgressService;

@RestController
public class CreateProgressController {
	
	Logger log = LoggerFactory.getLogger(CreateProgressController.class);
	
	@Resource(name="progressService")
	private ProgressService progressService;
	
	@PostMapping(value = "/progress")
	public String create(@RequestBody Map<String,Object> reqMap) {
		log.info(reqMap.toString());
		progressService.createTxt(Long.parseLong((String) reqMap.get("count")));
		return "SUCCESS";
	}
	
	@GetMapping(value = "/progress")
	public String getPercent() {
		return progressService.getPercent();
	}
	
	@DeleteMapping(value = "/progress")
	public String delPercentInRedis() {
		progressService.delPercentInRedis();
		return "SUCCESS";
	}
}
