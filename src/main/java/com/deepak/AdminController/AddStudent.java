package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;
import com.deepak.Student.Student;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Admin/AddStudent.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = uniuid();
		String name = req.getParameter("name").toUpperCase();
		String email = req.getParameter("email").toLowerCase();
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPhone(phone);
		s.setGender(gender);
		s.setDob(dob);
		s.setAddress(address);

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String addStudent = adminDaoImp.addStudent(s);
		System.out.println(addStudent);
		resp.sendRedirect("Admin/Dashboard.jsp");

	}

	private String uniuid() {

		String prefix = "STU";
		int uniu = (int) ((Math.random() * (10000 - 1000)) + 1000);
		return prefix + uniu;
	}

}
