package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Person;

public interface PersonDao {

	public List<Person> listAllPerson();
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public void deletePerson(int id);
	public Person findPersonById(int id);
	public List<Person> listAllDoctor();
}
