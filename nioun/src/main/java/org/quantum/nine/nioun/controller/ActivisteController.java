package org.quantum.nine.nioun.controller;


import org.quantum.nine.nioun.entities.Activiste;
import org.quantum.nine.nioun.repos.ActivisteRepo;
import org.quantum.nine.nioun.service.ActivisteService;
import org.quantum.nine.nioun.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivisteController {
	
	@Autowired
	ActivisteService service;

	@Autowired
	ActivisteRepo repository;
	
	@Autowired
	EmailUtil emailUtil ;
	
	
	

	@RequestMapping("/createactiviste")
	public String showcreate() {
		return "createactiviste";
	}

	@RequestMapping("/saveActiviste")
	public String saveActiviste(@ModelAttribute("activiste") Activiste activiste, ModelMap modelMap) {
		Activiste activisteSaved = service.saveActiviste(activiste);
		String msg = "Activiste saved with id :" + activisteSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("mkebe1@yahoo.fr", "Activiste enregistré",
				"Activiste enregistré avec succès avec l ' id :" + activisteSaved.getId());
		return "createActiviste";
	}



}
