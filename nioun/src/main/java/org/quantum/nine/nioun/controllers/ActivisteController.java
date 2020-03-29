package org.quantum.nine.nioun.controllers;

import org.quantum.nine.nioun.entities.Activiste;
import org.quantum.nine.nioun.repos.ActivisteRepo;
import org.quantum.nine.nioun.service.ActivisteService;
import org.quantum.nine.nioun.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/activiste")
public class ActivisteController {

	@Autowired
	ActivisteService service;

	@Autowired
	ActivisteRepo repository;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	BCryptPasswordEncoder encoder ;
	
	@RequestMapping(value="/showcreate" , method=RequestMethod.GET)
	public String showcreate() {
		return "createactiviste";
	}

	
	@RequestMapping(value = "/saveactiviste", method = RequestMethod.POST)
	public String saveactiviste(@ModelAttribute("activiste") Activiste activiste, ModelMap modelMap) {
		
		Activiste activisteSaved = service.saveActiviste(activiste);
		String msg = "Activiste saved with id :" + activisteSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("mkebe1@yahoo.fr", "Activiste enregistré",
				"Activiste enregistré avec succès avec l ' id :" + activisteSaved.getId());
		return "createactiviste";
	}

	
	@RequestMapping(value="/showmarket" , method=RequestMethod.GET)
	public String showmarket() {
		return "market";
	}
	
	@RequestMapping(path="/showCoreCorantic" , method=RequestMethod.GET)
	public String showCoreCorantic() {
		return "coreCorantic";
	}
	
	@RequestMapping(path="/connectactiviste" , method=RequestMethod.GET)
	public String connectactiviste() {
		return "coreCorantic";
	}
}
