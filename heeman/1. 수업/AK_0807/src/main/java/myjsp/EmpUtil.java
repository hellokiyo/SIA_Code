package myjsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EmpUtil {
	public static List<String> getJobList() throws Exception{
		//자바 배열의 문제점 : 변경 할 수 없음
		List<String> list = new  ArrayList<String>();
		
		Connection connection = getConnection();
		String sql = "select distinct job_id from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs  = psmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		
		String[] result = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		connection.close();
		
		
		//result = list.toArray(new String[0]);
		return list;
	}
	
	
	
	public  List<String> getDeptList(String jobId) throws Exception {
		List<String> list = new  ArrayList<String>();
		
		Connection connection = getConnection();
		String sql = "select CONCAT(first_name, ' ', last_name) from employees where job_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, jobId);
		ResultSet rs  = psmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		
		String[] result = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return list;
				
	}
	
	public  List<String> getSerchBy(String select, String col) throws Exception {
		List<String> list = new  ArrayList<String>();
		
		Connection connection = getConnection();
		String sql = "select employee_id, first_name, salary, department_id from employees where "+ select+ " = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);		
		psmt.setString(1, col);
		ResultSet rs  = psmt.executeQuery();
		
		while(rs.next()) {
		    String id = rs.getString("employee_id");
		    String name = rs.getString("first_name");
		    String salary = rs.getString("salary");
		    String dept = rs.getString("department_id");

		    list.add(id + " / " + name + " / " + salary + " / " + dept);
		}

		
		return list;
				
	}
	
	
	
	private static Connection getConnection() throws Exception  {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
