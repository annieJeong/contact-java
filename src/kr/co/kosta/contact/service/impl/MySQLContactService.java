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
import kr.co.kosta.contact.util.ConnectionUtil;

public class MySQLContactService implements ContactService_DB {

	@Override
	public void insertUser(Contact contact) throws IOException {

		String name = contact.getName();
		String email = contact.getEmail();
		int age = contact.getAge();
		String addr = contact.getAddr();

		try {
			// 1. establish connection
			// conn = DriverManager.getConnection("jdbc:mysql://localhost/kosta10","root","1234");
			Connection conn = ConnectionUtil.getConnection("dev");
			// 2. Prepare query for mysql
			String sql = "insert into contacts(name,email,age,addr) values(?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql
																	// injection
																	// 공격을 막을 수
																	// 있다.

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, age);
			pstmt.setString(4, addr);
			// 3. start to query
			pstmt.executeUpdate();
			// 4. return to connection
			ConnectionUtil.releaseConnection(conn);

			System.out.println("Insert Ok");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Insert Fail");

		}
		/*
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
			System.out.println("Connection Close");
		}
		*/
	}

	@Override
	public void AllUserDisplay() {
		
		try {
			// 1. establish connection
			Connection conn = ConnectionUtil.getConnection("dev");
			// 2. Prepare query for mysql
			String sql = "SELECT * FROM contacts ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");

				System.out.println(name + " " + email + " " + age + " " + addr);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connecton Fail");
		}
		/*
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection Close");
		}
		*/
	}

	@Override
	public void ModifyUser(Contact contact) throws IOException {

		String name = contact.getName();
		String email = contact.getEmail();
		int age = contact.getAge();
		String addr = contact.getAddr();

		try {
			Connection conn = ConnectionUtil.getConnection("dev");
			String sql = "UPDATE contacts SET name = ?, email = ?, age = ?, addr = ? WHERE id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql
																	// injection
																	// 공격을 막을 수
																	// 있다.

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, age);
			pstmt.setString(4, addr);
			pstmt.setInt(5, getId());

			pstmt.executeUpdate();

			System.out.println("Modify Ok");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Modify Fail");

		}
		/* finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
			System.out.println("Connection Close");
		}
		*/
	}

	public int getId() throws IOException {
		System.out.print("수정하고자 하는 유저의 ID를 입력해주세요 >");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int id = Integer.parseInt(input);
		return id;
	}

	@Override
	public void DeleteUser() throws IOException {
		try {
			// 1. establish connection
			Connection conn = ConnectionUtil.getConnection("dev");
			// 2. Prepare query for mysql

			int id = getId();
			String sql = "SELECT * FROM contacts where id=" + id;
			String sql2 = "DELETE FROM contacts where id=" + id;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			String name = rs.getString("name");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");

			System.out.println(name + " " + email + " " + age + " " + addr);

			PreparedStatement pstmt2 = conn.prepareStatement(sql2);

			pstmt2.executeUpdate();
			System.out.println("Delete Ok");

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Delete Fail");
		}
		/*
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection Close");
		}
		*/
	}
}
