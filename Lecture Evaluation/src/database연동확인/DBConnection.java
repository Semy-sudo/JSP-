package database����Ȯ��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DBConnection {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnection() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","1234");
				
		}catch(Exception e) {
			System.out.println("������ ���̽� ���� ����:"+ e.getMessage());
		}
		
	}
	
	public boolean isAdmin(String adminID, String adminPassword) {
		try
		{
			String SQL = "SELECT * FROM ADMIN WHERE adminID = '" + adminID + "' and adminPassword = '" + adminPassword + "'";
			rs = st.executeQuery(SQL);
			if(rs.next())
			{
				return true;
			}
		} 
		catch(Exception e) {
			System.out.println("������ ���̽� �˻�����:"+e.getMessage());
		}
		return false;
	}
	
}
