package kr.co.kosta.contact;

import java.io.*;

public class ContactManagerMain {

	public static void main(String[] args) throws IOException {
		//1. ����ڿ��� ȭ�麸���ֱ�. (View)
		/**
		 * ====================
		 * 1. ����ó ���
		 * 2. ����ó ��ü����
		 * Q. ����
		 * ====================
		 * >> ����
		 * 
		 * EX >
		 * 1. ���� ->
		 * ������̸� �̸��� ���� �ּҸ� ���� �Է����ּ���.
		 * ���� �Է��� �ּ���. �����ڴ� �����̽��Դϴ�.
		 * 
		 */
		
		view();
		String choice;
		//�ܼ��� ���� ����� �Է��� ���� �� �ִ� ��Ʈ�� ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		choice = reader.readLine();
		switch(choice){
		case "1":
			//����ó ���
			createUser();
			break;
		case "2":
			//����ó ��ü����
			break;
		case "Q":
			//����
			break;
		}
		/*����ھȳ��޽���
		System.out.print("������ �����ϼ���:");
		String name= reader.readLine();
		
		System.out.print("�̸����� �Է��ϼ���:");
		String email = reader.readLine();
		
		System.out.print("���̸� �Է��ϼ���:");
		String age = reader.readLine();
		
		System.out.print("������ �Է��ϼ���:");
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
		System.out.println("1. ����ó���");
		System.out.println("2. ����ó ��ü����");
		System.out.println("Q. ����");
		System.out.println("====================");

	}
	
	public static void createUser() throws IOException{
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������̸� �̸��� ���� �ּҸ� ���� �Է����ּ���. �����ڴ� �����̽��Դϴ�.");
		String user= reader2.readLine();
		String[] result = user.split(" ",4);
		String all = "������̸� : "+result[0]+"\n�̸��� :"+result[1]+"\n���� :"+result[2]+"\n�ּ� :"+result[3];

		File file1 = new File("C:\\Users\\User\\workspace\\input\\user.txt");
		
		try(BufferedWriter writer=new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(file1),"UTF-8") {
			//���Ͽ� ���ڿ����
			writer.write(all);
			writer.newLine();
		}));
		
	}
}
