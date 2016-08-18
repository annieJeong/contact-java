package kr.co.kosta.contact.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.kosta.contact.model.Contact;
import kr.co.kosta.contact.service.ContactService_DB;

public class DBContactService implements ContactService_DB{

	@Override
	public void insertUser(Contact contact) throws IOException {
		
		String name 	= contact.getName();
		String email 	= contact.getEmail();
		int age 			= contact.getAge();
		String addr	= contact.getAddr();
		
			Connection conn = null;
			try{
				//1. establish connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost/world","root","1234");
				//2. Prepare query for mysql
				String sql = "insert into contact_user(User_Name,User_Email,User_Age,User_Addr) values(?,?,?,?);";
				PreparedStatement pstmt = conn.prepareStatement(sql);	//sql injection 공격을 막을 수 있다.
				
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setInt(3, age);
				pstmt.setString(4, addr);
				
				pstmt.executeUpdate();
				
				System.out.println("Insert Ok");
			}catch(SQLException se){
				se.printStackTrace();
				System.out.println("Insert Fail");

			}finally{
				try {
					if(conn != null) {conn.close(); }	
				} catch (SQLException e) {}
				System.out.println("Connection Close");
			}
		}	
	

	@Override
	public void AllUserDisplay() {
		Connection conn = null;
		try{
			//1. establish connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost/world","root","1234");
			//2. Prepare query for mysql
			String sql = "SELECT * FROM contact_user ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){	

				String name 		= rs.getString("User_Name");	
				String email		= rs.getString("User_Email");
				int age				= rs.getInt("User_Age");
				String addr		= rs.getString("User_Addr");
				
				System.out.println(name + " " + email + " " + age + " " + addr);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connecton Fail");
		}finally{
			try {
				if(conn != null) {conn.close(); }
			} catch (SQLException e) {e.printStackTrace();	}
			System.out.println("Connection Close");
		}
	}
	
	@Override
	public void ModifyUser(Contact contact) throws IOException{

		String name 	= contact.getName();
		String email 	= contact.getEmail();
		int age 			= contact.getAge();
		String addr	= contact.getAddr();
		
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/world","root","1234");
			String sql = "UPDATE contact_user SET User_Name = ?, User_Email = ?, User_Age = ?, User_Addr = ? WHERE User_Id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql injection 공격을 막을 수 있다.
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, age);
			pstmt.setString(4, addr);
			pstmt.setInt(5, getId());
			
			pstmt.executeUpdate();
			
			System.out.println("Modify Ok");
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("Modify Fail");

		}finally{
			try {
				if(conn != null) {conn.close(); }	
			} catch (SQLException e) {}
			System.out.println("Connection Close");
		}
	}
	
	public int getId() throws IOException{
		System.out.print("수정하고자 하는 유저의 ID를 입력해주세요 >");
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String input = br.readLine();
		int id = Integer.parseInt(input);
		return id;
	}
	
	@Override
	public void DeleteUser() throws IOException{
		Connection conn = null;
		try{
			//1. establish connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost/world","root","1234");
			//2. Prepare query for mysql
			String sql = "DELETE FROM contact_user where User_Id=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, getId());
			
			pstmt.executeUpdate();
			System.out.println("Delete Ok");

		}catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Delete Fail");
		}finally{
			try {
				if(conn != null) {conn.close(); }
			} catch (SQLException e) {e.printStackTrace();	}
			System.out.println("Connection Close");
		}
	}
}
