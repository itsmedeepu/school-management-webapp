package com.deepak.Admin;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.deepak.Student.Student;
import com.deepak.Teacher.Teacher;

public interface AdminDao {


	String saveAdmin(Admin a);

	String updateAdmin(Admin a);

	Admin getAdminById(int id);

	String addClass(String classname, String classdescripton);

	String addTeacher(Teacher t);

	String addStudent(Student s);

	String addSubject(String id, String name);

	List<HashMap<String, String>> getAllClasses();

	List<Teacher> getAllTeachersWhoNotMappped();

	Admin AdminLoggin(String username, String password);

	List<HashMap<String, String>> getAllSubjects();

	String mapTeacherToSubject(String teacherid, String subjectid);

	String assignTeacher(String teacherid, int classid);

	String assignStudentToClass(String studentid, String classid);

}
