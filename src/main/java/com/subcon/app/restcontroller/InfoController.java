package com.subcon.app.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@GetMapping("/info")
	public String getInfo() {
		return "Estoy vivo !! ver 1.1";
	}
}
