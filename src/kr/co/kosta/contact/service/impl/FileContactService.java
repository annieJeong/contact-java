package kr.co.kosta.contact.service.impl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import kr.co.kosta.contact.model.Contact;
import kr.co.kosta.contact.service.ContactService;

public class FileContactService implements ContactService {

	@Override
	public void registContact(Contact contact) {
		
		String name 	= contact.getName();
		String email 	= contact.getEmail();
		int age 			= contact.getAge();
		String addr	= contact.getAddr();
		
		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("contact.txt"), "UTF-8"))){
			bw.append((char) 0);
				bw.write(name+" "+ email + " " + age + " " + addr +" ");
				bw.newLine();
				
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> listContact() {
		return null;
	}

	@Override
	public Contact detailContact(String name) {
		return null;
	}

	@Override
	public void removeContact(String name) {

	}

}
