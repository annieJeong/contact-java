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
	 * 연락처 추가하기.
	 * @param contact
	 * 
	 */
	void registContact(Contact contact);
	/**
	 * 연락처 전체보기
	 * @return
	 */
	List<Contact> listContact();
	/**
	 * 연락처 상세보기
	 * @param name
	 * @return
	 */
	Contact detailContact(String name);
	/**
	 * 연락처 삭제
	 * @param name
	 */
	void removeContact(String name);
}
