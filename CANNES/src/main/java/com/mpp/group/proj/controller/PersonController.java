package com.mpp.group.proj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mpp.group.proj.model.Gender;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.PersonType;
import com.mpp.group.proj.model.Title;
import com.mpp.group.proj.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	//private Map<Integer, String> personType = new HashMap<Integer, String>();
	private Map<String, String> statusList = new HashMap<String, String>();
	
	
	private Title titleList;
	private Gender genderList;
	private PersonType personType;

    
    private Title getTitleList() {
        return titleList;
    }
    
    private Gender getGenderList(){
    	return genderList;
    }
    
    private PersonType getPersonTypeList(){
    	return personType;
    }
    

    @RequestMapping(value="/person", method=RequestMethod.GET)
	public ModelAndView listPerson(){
		ModelAndView model = new ModelAndView("person/person");
		Person person = new Person();
		
		populateDefault();
		
		List<Person> personList = personService.listAllPerson();
		
		model.addObject("personForm",person);
		model.addObject("personType",getPersonTypeList());
		model.addObject("titleList",getTitleList());
		model.addObject("genderList",getGenderList());
		model.addObject("personList",personList);
		model.addObject("statusList",statusList);
		
		return model;
	}
	
	/*@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {

		populateDefault();
		
		List<Person> personList = personService.listAllPerson();
		
		model.addAttribute("personForm", personService.findPersonById(id));
		model.addAttribute("personType",personType);
		model.addAttribute("titleList",getTitleList());
		model.addAttribute("genderList",getGenderList());
		model.addAttribute("personList",personList);
		model.addAttribute("statusList",statusList);
		
		return "person/";
	}*/
	
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute("id") Person person){
		System.out.println("PPPPPPPPPPPPPPPPPPPP");
		System.out.println(person);
		/*if(person != null && person.getId() != 0){
			//update
			personService.updatePerson(person);
		}else{
			personService.addPerson(person);
		}*/
		
		return new ModelAndView("redirect:/person/");
	}
	
	
	
	private void populateDefault(){

				
				//Map<String, String> statusList = new HashMap<String, String>();
				statusList.put("Y", "Active");
				statusList.put("N", "Inactive");
				
	}
}
