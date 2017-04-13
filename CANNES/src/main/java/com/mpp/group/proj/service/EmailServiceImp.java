package com.mpp.group.proj.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpp.group.proj.dao.EmailDao;
import com.mpp.group.proj.model.Email;

@Service
public class EmailServiceImp implements EmailService {
	
    EmailDao EmailDao;
	
	@Autowired
	public void setEmailDao(EmailDao EmailDao){
		this.EmailDao = EmailDao;
	}

	@Override
	public List<Email> listAllEmail() {
		return EmailDao.listAllEmail();
	}

	@Override
	public void addEmail(Email Email) {
		EmailDao.addEmail(Email);
	}

	@Override
	public void updateEmail(Email Email) {
		EmailDao.updateEmail(Email);
	}

	@Override
	public void deleteEmail(int id) {
		EmailDao.deleteEmail(id);
	}

	@Override
	public Email findEmailById(int id) {
		return EmailDao.findEmailById(id);
	}


}
