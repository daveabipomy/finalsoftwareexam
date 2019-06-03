package edu.mum.cs.cs425.srs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@RequestMapping(value="/srs/home", method=RequestMethod.GET)
	public String homepage() {
		return "homepage/index";
	}
}
