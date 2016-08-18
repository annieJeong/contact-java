package kr.co.kosta.contact;

import java.io.*;

import kr.co.kosta.contact.model.Contact;
import kr.co.kosta.contact.service.ContactService_DB;
import kr.co.kosta.contact.service.impl.DBContactService;
//import kr.co.kosta.contact.service.impl.FileContactService;
//import kr.co.kosta.contact.service.ContactService;

public class ContactManagerMain {

	public static void main(String[] args) throws IOException {
		//1. 사용자에게 화면보여주기. (View)
		/**
		 * ====================
		 * 1. 연락처 등록
		 * 2. 연락처 전체보기
		 * Q. 종료
		 * ====================
		 * >> 선택
		 * 
		 * EX >
		 * 1. 선택 ->
		 * 사용자이름 이메일 나이 주소를 각각 입력해주세요.
		 * 각각 입력해 주세요. 구분자는 스페이스입니다.
		 * 
		 */
		String choice = "";
		do {
			view();
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			
			choice = br.readLine();
			ContactService_DB ss = new DBContactService();
			
			if (choice.startsWith("1")) {
				System.out.println(">> 1. 사용자 생성");
				Contact contact = makeContactFromUserInput();
				
				ss.insertUser(contact);
				//ContactService service = new FileContactService();
				//service.registContact(contact);		//file
			}
			else if (choice.startsWith("2")) {
				System.out.println(">> 2. 사용자 목록보기");
				ss.AllUserDisplay();
				//readUser();
			}else if (choice.startsWith("3")) {
				System.out.println(">> 3. 사용자 수정하기");
				System.out.println("먼저 수정 내용을 입력해 주세요.");
				Contact contact = makeContactFromUserInput();
				ss.ModifyUser(contact);
				//readUser();
			}else if (choice.startsWith("4")){
				System.out.println(">> 4. 사용자 삭제하기");
				ss.DeleteUser();
			}else if (choice.trim().toUpperCase().startsWith("Q")){
				System.out.println("종료하셨습니다...");
				break;
			}else {
				System.out.println("잘못누르셨습니다.");
			}
			
		} while (true);
		
		
	}

	public static void view() {
		System.out.println("====================");
		System.out.println("1. 연락처등록");
		System.out.println("2. 연락처 전체보기");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("Q. 종료");
		System.out.println("====================");
		System.out.print("Press>>");

	}
	
	private static Contact makeContactFromUserInput() throws IOException{
		System.out.println("이름 이메일 나이 주소를 각각 슬래시(/)로 구분해서 입력해 주세요.");
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String inputFromUser = br.readLine();
		String[] result = inputFromUser.split("/",4);
		//데이터를 가지고 Contact객체를 생성.
		Contact contact = new Contact();
		contact.setName(result[0]);
		contact.setEmail(result[1]);
		contact.setAge(Integer.parseInt(result[2]));
		contact.setAddr(result[3]);
		
		return contact;
	}
	
	
	/*
	public static void createUser() throws IOException{
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		try{
		BufferedWriter bW;
		FileWriter fw;
		fw = new FileWriter("test.txt", false);
		bW = new BufferedWriter(fw);
		
		System.out.println("사용자이름 이메일 나이 주소를 각각 입력해주세요. 구분자는 스페이스입니다.");
		String user= reader2.readLine();
		String[] result = user.split(" ",4);
		
		bW.write("사용자이름 : "+result[0]+" 이메일 :"+result[1]+" 나이 :"+result[2]+" 주소 :"+result[3]);
		bW.newLine();	//줄바꿈
		bW.close();
		}catch(IOException io){
			System.out.println("error");   v
		}
	}
	public static void readUser() throws IOException{
		try{
			BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		
			String txt = "";

			while((txt = reader.readLine()) != null) 
			{
				System.out.println(txt);
			}

			reader.close();
		}catch(IOException io){
			System.out.println("error");
		}
	}
	*/
}