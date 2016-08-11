package kr.co.kosta.contact;

import java.awt.Choice;
import java.io.*;

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
			
			if (choice.startsWith("1")) {
				System.out.println(">> 1. 사용자 생성");
				createUser();
			}
			else if (choice.startsWith("2")) {
				System.out.println(">> 2. 사용자 목록보기");
				readUser();
			}
			else {
				
			}
			
		} while (!choice.trim().toUpperCase().startsWith("Q"));
		System.out.println("종료하셨습니다...");
		
		
		/*사용자안내메시지
		System.out.print("성함을 말씀하세요:");
		String name= reader.readLine();
		
		System.out.print("이메일을 입력하세요:");
		String email = reader.readLine();
		
		System.out.print("나이를 입력하세요:");
		String age = reader.readLine();
		
		System.out.print("지역을 입력하세요:");
		String locate = reader.readLine();
		Contact contact = new Contact(name,email,age,locate);
		File file1 = new File("C:\\Users\\User\\workspace\\input\\user.txt");
		
		try(BufferedWriter writer = new BufferedWriter(
			new OutputStreamWriter(new FileOutputStream(file1),"UTF-8"){
				writer.write();
			}
		))catch(IOException exception){
			
		}
			
		System.out.println(contact);
		*/
	}

	public static void view() {
		System.out.println("====================");
		System.out.println("1. 연락처등록");
		System.out.println("2. 연락처 전체보기");
		System.out.println("Q. 종료");
		System.out.println("====================");

	}
	
	@SuppressWarnings("resource")
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
			System.out.println("error");
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
}