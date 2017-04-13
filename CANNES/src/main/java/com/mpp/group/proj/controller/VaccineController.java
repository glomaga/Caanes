package com.mpp.group.proj.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mpp.group.proj.model.Animal;
import com.mpp.group.proj.model.Categories;
import com.mpp.group.proj.model.Vaccine;
import com.mpp.group.proj.service.AnimalService;
import com.mpp.group.proj.service.VaccineService;

@Controller
@RequestMapping(value="/vaccine")
public class VaccineController {
	@Autowired
	VaccineService VaccineService;
	
	@Autowired
	AnimalService AnimalService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listVaccine(){
		ModelAndView model = new ModelAndView("vaccine/vaccine");
		Vaccine vaccine = new Vaccine();

		List<Animal> animals = AnimalService.listAllAnimal();
		List<Vaccine> list = VaccineService.listAllVaccine();
		model.addObject("vaccineForm",vaccine);
		model.addObject("listvaccine",list);
		model.addObject("AnimalList",animals);
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	
	public ModelAndView saveVaccine(@ModelAttribute("id") Vaccine Vaccine){

		 System.out.println(">TaskController doCreateTask " + Vaccine);
		    
		if(Vaccine != null && Vaccine.getId() != 0){
			//update
			VaccineService.updateVaccine(Vaccine);
		}else{
			VaccineService.addVaccine(Vaccine);
		}
		return new ModelAndView("redirect:/vaccine/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteVaccine(ModelMap model, @RequestParam int id) {
		
		VaccineService.deleteVaccine(id);
		Vaccine vaccine = new Vaccine();
		List<Vaccine> list = VaccineService.listAllVaccine();

		model.addAttribute("vaccineForm",vaccine);
		model.addAttribute("listvaccine",list);
		
		return "vaccine/vaccine";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateVaccine(ModelMap model, @RequestParam int id) {
		
		List<Vaccine> list = VaccineService.listAllVaccine();
		List<Animal> animals = AnimalService.listAllAnimal();
		
		model.addAttribute("vaccineForm", VaccineService.findVaccineById(id));
		model.addAttribute("listvaccine",list);
		model.addAttribute("AnimalList",animals);
		
		return "vaccine/vaccine";
	}
	
}
