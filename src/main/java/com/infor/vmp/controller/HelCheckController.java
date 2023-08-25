package com.infor.vmp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelCheckController {
	private static final Logger log = LogManager.getLogger(HelCheckController.class);

	@RequestMapping("/helCheck")
	String home() {
		log.info("BEGIN API CHECK");
		return "I'm fine";
	}

}