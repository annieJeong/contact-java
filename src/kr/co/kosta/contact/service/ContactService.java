package kr.co.kosta.contact.service;

import kr.co.kosta.contact.model.Contact;
import java.util.List;
/**
 * 클래스 설명
 * @author User
 * @version
 * 
 */
public interface ContactService {
	/**
	 * 메소드설명
	 * @param contact
	 * 
	 */
	void registContact(Contact contact);
	/**
	 * 
	 * @return
	 */
	List<Contact> listContact();
	/**
	 * 
	 * @param name
	 * @return
	 */
	Contact detailContact(String name);
	/**
	 * 
	 * @param name
	 */
	void removeContact(String name);
}
