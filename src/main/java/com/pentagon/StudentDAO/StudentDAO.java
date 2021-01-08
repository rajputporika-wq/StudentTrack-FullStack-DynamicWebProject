package com.pentagon.StudentDAO;

import java.util.ArrayList;

import com.pentagon.StudentDTO.Student;

public interface StudentDAO {
	
	public boolean insertStudent(Student s);//DML Operations
	public boolean updateStudent(Student s);//DML Operations
	public boolean updateStudentD(Student s);
	public boolean deleteStudent(String email);//DML Operations
	public Student getStudent(String email, String password);
	public ArrayList<Student> getAllStudents();
	public Student getStudent(long phone, String email);
	

}
