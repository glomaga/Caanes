package com.mpp.group.proj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mpp.group.proj.model.Active;
import com.mpp.group.proj.model.Gender;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.PersonType;
import com.mpp.group.proj.model.Title;
import com.mpp.group.proj.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	private List<PersonType> personTypeList = new ArrayList<PersonType>(Arrays.asList(PersonType.values()));
	private List<Title> titleList = new ArrayList<Title>(Arrays.asList(Title.values()));
	private List<Gender> genderList = new ArrayList<Gender>(Arrays.asList(Gender.values()));
	private List<Active> activeList = new ArrayList<Active>(Arrays.asList(Active.values()));
	

    @RequestMapping(value="/person", method=RequestMethod.GET)
	public ModelAndView listPerson(){
		ModelAndView model = new ModelAndView("person/person");
		Person person = new Person();
		
		List<Person> personList = personService.listAllPerson();
		
		model.addObject("personForm",person);
		model.addObject("personType",personTypeList);
		model.addObject("titleList",titleList);
		model.addObject("genderList",genderList);
		model.addObject("personList",personList);
		model.addObject("statusList",activeList);
		
		return model;
	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		
		List<Person> personList = personService.listAllPerson();
		
		model.addAttribute("personForm", personService.findPersonById(id));
		model.addAttribute("personType",personTypeList);
		model.addAttribute("titleList",titleList);
		model.addAttribute("genderList",genderList);
		model.addAttribute("personList",personList);
		model.addAttribute("statusList",activeList);
		
		return "/person/person";
	}
	
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute("id") Person person){
		if(person != null && person.getId() != 0){
			personService.updatePerson(person);
		}else{
			personService.addPerson(person);
		}
		
		return new ModelAndView("redirect:/person/");
	}

}
