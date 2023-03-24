package com.deepak.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deepak.School.util.AppConstants;
import com.deepak.School.util.Connectionutil;
import com.deepak.Student.Student;
import com.deepak.Teacher.Teacher;
import com.mysql.cj.jdbc.Driver;

public class AdminDaoImp implements AdminDao {

	@Override
	public String saveAdmin(Admin a) {

		Connection connection = Connectionutil.getConnection();

		String query = "insert into admin(name, email, phone, username, password) values(?,?,?,?,?)";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			String name = a.getName();
			String email = a.getEmail();
			String phone = a.getPhone();
			String username = a.getUsername();
			String password = a.getPassword();
			pt.setString(1, username);
			pt.setString(2, email);
			pt.setString(3, phone);
			pt.setString(4, username);
			pt.setString(5, password);
			int ex = pt.executeUpdate();
			connection.close();
			return ex + "rows inserted 👍👍";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAdmin(Admin a) {

		Connection connection = Connectionutil.getConnection();

		String query = "update  admin set name=?, email=?, phone=?, username=?, password=? where id=?";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			int id = a.getId();
			String name = a.getName();
			String email = a.getEmail();
			String phone = a.getPhone();
			String username = a.getUsername();
			String password = a.getPassword();

			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, phone);
			pt.setString(4, username);
			pt.setString(5, password);
			pt.setInt(6, id);
			int ex = pt.executeUpdate();
			connection.close();
			return ex + "rows updated 👍👍";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin AdminLoggin(String username, String password) {
		Admin a = null;
		Connection connection = Connectionutil.getConnection();
		String query = "select * from admin where username=? and password=?";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, username);
			pt.setString(2, password);
			ResultSet ex = pt.executeQuery();
			if (ex.next()) {
				a = new Admin();
				int id = ex.getInt(1);
				String name = ex.getString(2);
				String email = ex.getString(3);
				String phone = ex.getString(4);
				a.setId(id);
				a.setName(name);
				a.setEmail(email);
				a.setPhone(phone);

			}
			connection.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin getAdminById(int adminid) {

		Connection connection = Connectionutil.getConnection();

		String query = "select * from admin where id=?";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setInt(1, adminid);
			ResultSet ex = pt.executeQuery();

			if (ex.next()) {
				Admin a = new Admin();
				int id = ex.getInt(1);
				String name = ex.getString(2);
				String email = ex.getString(3);
				String phone = ex.getString(4);
				String username = ex.getString(5);
				String password = ex.getString(6);
				a.setId(id);
				a.setName(name);
				a.setPhone(phone);
				a.setEmail(email);
				a.setUsername(username);
				a.setPassword(password);
				connection.close();
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addClass(String classname, String classdescripton) {
		Connection connection = Connectionutil.getConnection();

		String query = "insert into class(classname, classdescripton) values(?,?)";

		PreparedStatement pt;
		try {
			pt = connection.prepareStatement(query);
			pt.setString(1, classname);
			pt.setString(2, classdescripton);
			int ex = pt.executeUpdate();
			connection.close();
			return ex + "rows inserted 👍👍";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addTeacher(Teacher t) {
		Connection connection = Connectionutil.getConnection();
		String query = "insert into teacher(id, name, email, phone, gender) values(?,?,?,?,?)";

		try {
			PreparedStatement pt = connection.prepareStatement(query);

			String id = t.getId();
			String name = t.getName();
			String email = t.getEmail();
			String phone = t.getPhone();
			String gender = t.getGender();

			pt.setString(1, id);
			pt.setString(2, name);
			pt.setString(3, email);
			pt.setString(4, phone);
			pt.setString(5, gender);

			int ex = pt.executeUpdate();
			connection.close();

			return ex + " teachers added";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String addSubject(String id, String name) {

		Connection connection = Connectionutil.getConnection();
		String query = "insert into subject (id,name) values(?,?)";

		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, id);
			pt.setString(2, name);

			int ex = pt.executeUpdate();
			connection.close();
			return ex + " rows inserted ";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String addStudent(Student s) {
		Connection connection = Connectionutil.getConnection();
		String query = "insert into student(id, name, email, phone, gender,dob,address) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement pt = connection.prepareStatement(query);

			String id = s.getId();
			String name = s.getName();
			String email = s.getEmail();
			String phone = s.getPhone();
			String gender = s.getGender();
			String dob = s.getDob();
			String address = s.getAddress();

			pt.setString(1, id);
			pt.setString(2, name);
			pt.setString(3, email);
			pt.setString(4, phone);
			pt.setString(5, gender);
			pt.setString(6, dob);
			pt.setString(7, address);

			int ex = pt.executeUpdate();
			connection.close();

			return ex + " students added";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<HashMap<String, String>> getAllClasses() {

		Connection connection = Connectionutil.getConnection();
		String query = "select classid,classname from class";

		try {
			PreparedStatement pt = connection.prepareStatement(query);
			ResultSet ex = pt.executeQuery();
			List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			while (ex.next()) {

				HashMap<String, String> hash = new HashMap<String, String>();

				int id = ex.getInt(1);
				String name = ex.getString(2);

				hash.put("classid", id + "");
				hash.put("classname", name);

				list.add(hash);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getAllTeachersWhoNotMappped() {

		Connection connection = Connectionutil.getConnection();
		String query = "select * from teacher";

		try {
			PreparedStatement pt = connection.prepareStatement(query);
			ResultSet ex = pt.executeQuery();
			List<Teacher> list = new ArrayList<Teacher>();
			while (ex.next()) {

				String id = ex.getString(1);
				String name = ex.getString(2);
				String email = ex.getString(3);
				String phone = ex.getString(4);
				String gender = ex.getString(5);

				Teacher t = new Teacher();
				t.setId(id);
				t.setName(name);
				t.setEmail(email);
				t.setGender(gender);
				t.setPhone(phone);

				list.add(t);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public String assignTeacher(String teacherid, int classid) {
		Connection connection = Connectionutil.getConnection();
		String query = "insert into teacher_class(teacherid,classid)values(?,?)";

		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, teacherid);
			pt.setInt(2, classid);
			int ex = pt.executeUpdate();
			connection.close();

			return ex + " teacher added to class";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<HashMap<String, String>> getAllSubjects() {

		Connection connection = Connectionutil.getConnection();
		String query = "select id,name from subject";

		try {
			PreparedStatement pt = connection.prepareStatement(query);
			ResultSet ex = pt.executeQuery();
			List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			while (ex.next()) {

				HashMap<String, String> hash = new HashMap<String, String>();

				String id = ex.getString(1);
				String name = ex.getString(2);

				hash.put("subjectid", id);
				hash.put("subjectname", name);

				list.add(hash);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public String mapTeacherToSubject(String teacherid, String subjectid) {
		Connection connection = Connectionutil.getConnection();
		String query = "insert into teaches(teacherid,subjectid) values(?,?)";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, teacherid);
			pt.setString(2, subjectid);

			int executeUpdate = pt.executeUpdate();
			connection.close();
			return executeUpdate + "rows inserted";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

//	public String getallStudent() {
//		
//	}

	@Override
	public String assignStudentToClass(String studentid, String classid) {
		Connection connection = Connectionutil.getConnection();
		String query = "insert into enroll(studentid,classid) values(?,?)";
		try {
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, studentid);
			pt.setString(2, classid);

			int executeUpdate = pt.executeUpdate();
			connection.close();
			return executeUpdate + "rows inserted";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
