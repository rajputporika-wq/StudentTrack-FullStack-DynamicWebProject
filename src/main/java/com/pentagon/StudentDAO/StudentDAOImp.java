package com.pentagon.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pentagon.Conn.Connectors;
import com.pentagon.StudentDTO.Student;

public class StudentDAOImp implements StudentDAO{
	
	Connection con=null;
	public StudentDAOImp() {
		this.con=Connectors.getConnection();
	}

	@Override
	public boolean insertStudent(Student s) {
		String query = "INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		int res=0;
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPh());
			ps.setString(3,s.getEmail());
			ps.setString(4, s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());			
			res= ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean updateStudent(Student s) {
		String query = "UPDATE student SET name=?, phone=?, branch=?, location=?, password=? WHERE email=?";

	    int res = 0;

	    try (Connection con = Connectors.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setString(1, s.getName());
	        ps.setLong(2, s.getPh());
	        ps.setString(3, s.getBranch());
	        ps.setString(4, s.getLoc());
	        ps.setString(5, s.getPassword());
	        ps.setString(6, s.getEmail());

	        res = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}



	@Override
	public Student getStudent(String email, String password) {
		String query = "SELECT * FROM STUDENT WHERE EMAIL = ? AND PASSWORD=?";
		ResultSet rs=null;
		Student s=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2,password);
			ps.executeQuery();
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("SID"));
				s.setName(rs.getString("name"));
				s.setPh(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(s!=null) {
			return s;
		}
		
		else {
			return null;
		}
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> li = new ArrayList<Student>();
		String query="SELECT * FROM STUDENT WHERE SID!=1";
		ResultSet rs=null;
		Student s=null;
		
	    try {
			PreparedStatement ps = con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("SID"));
				s.setName(rs.getString("name"));
				s.setPh(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				li.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return li;
	}

	@Override
	public boolean deleteStudent(String email) {
	    String query = "DELETE FROM student WHERE email = ?";
	    int res = 0;

	    try (Connection con = Connectors.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setString(1, email);
	        res = ps.executeUpdate();

	        if (res > 0) {
	            return true;
	        } else {
	             return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public Student getStudent(long phone, String email) {
		String query = "SELECT * FROM STUDENT WHERE PHONE = ? AND EMAIL=?";
		Student s=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2,email);
			ps.executeQuery();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("SID"));
				s.setName(rs.getString("name"));
				s.setPh(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public boolean updateStudentD(Student s) {
		String query = "UPDATE student SET name=?, phone=?, email=?, branch=?, location=? WHERE id=?";

	    int res = 0;

	    try {
	    	
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, s.getName());
	        ps.setLong(2, s.getPh());
	        ps.setString(3, s.getEmail());
	        ps.setString(4, s.getBranch());
	        ps.setString(5, s.getLoc());
	        ps.setInt(6, s.getId());

	        res = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
