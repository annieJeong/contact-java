package kr.co.kosta.contact.service;

import java.io.IOException;

import kr.co.kosta.contact.model.Contact;

public interface ContactService_DB {

	void insertUser(Contact contact) throws IOException;

	void AllUserDisplay();

	void ModifyUser(Contact contact) throws IOException;

	void DeleteUser() throws IOException;
}
