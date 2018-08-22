package fr.grozk.perso.weddingapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/index", produces = "application/html")
public class IndexController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value="/wedding", method = RequestMethod.GET)
	public String joinWedding() {
		return "wedding";
	}
	
	@RequestMapping(value="/message", method = RequestMethod.GET)
	public String createMessage() {
		return "message";
	}
	
}
