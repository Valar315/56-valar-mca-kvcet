package jdbcapp;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class JdbcApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/kvcet1";
		String username = "root";
		String password = "root123";

		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			// executeQuery -> select,
			// executeUpdate -> insert, update, delete
			// execute -> nested queries
			ResultSet rs = stmt.executeQuery("select * from student");
			System.out.println("studId  studName  marks skill");
			while (rs.next()) {
				int stud_id = rs.getInt(1);
				String stud_name = rs.getString(2);
				int marks = rs.getInt(3);
				String skills = rs.getString(4);
				System.out.println(stud_id + "  " + stud_name + "\t " + marks + " " + skills);
			}
			rs.close();
			stmt.close();
			con.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	}


