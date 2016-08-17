package kr.co.kosta.contact.service;

import kr.co.kosta.contact.model.Contact;
import java.util.List;
/**
 * 
 * @author User
 * @version
 * 
 */
public interface ContactService {
	/**
	 * �޼ҵ弳��
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
