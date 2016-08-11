package kr.co.kosta.contact.model;

public class Contact {

	private String name;
	private String email;
	private String age;
	private String addr;

	public Contact() {

	}

	public Contact(String name, String email, String age, String addr) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", age=" + age + ", addr=" + addr + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
