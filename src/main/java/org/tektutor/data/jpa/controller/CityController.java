package org.tektutor.data.jpa.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class CityController {
	@RequestMapping(value = "/")
	public String getAllActionGroups() {
		return "hotels";
	}

}
