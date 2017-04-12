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
import com.mpp.group.proj.model.Gender;
import com.mpp.group.proj.service.AnimalService;

@Controller
@RequestMapping(value="/animal")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listAnimal(){
		ModelAndView model = new ModelAndView("animal/animal");
		
		Animal animal = new Animal();
		List<Animal> list = animalService.listAllAnimal();
		model.addObject("animalForm",animal);
		model.addObject("listAnimal",list);
		model.addObject("listStatus",Gender.values());
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveAnimal(@ModelAttribute("id") Animal animal){
	
		if(animal != null && animal.getId() != 0){
			//update
			animalService.updateAnimal(animal);
		}else{
			animalService.addAnimal(animal);
		}
		return new ModelAndView("redirect:/animal/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		animalService.deleteAnimal(id);
		Animal animal = new Animal();
		List<Animal> list = animalService.listAllAnimal();
		model.addAttribute("animalForm",animal);
		model.addAttribute("listAnimal",list);
		
		return "animal/animal";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		
		List<Animal> list = animalService.listAllAnimal();
		model.addAttribute("animalForm", animalService.findAnimalById(id));
		model.addAttribute("listAnimal",list);
		
		return "animal/animal";
	}


}
