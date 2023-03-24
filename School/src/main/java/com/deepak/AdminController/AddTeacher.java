package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;
import com.deepak.Teacher.Teacher;

@WebServlet("/addteacher")
public class AddTeacher extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Admin/AddTeacher.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = uniqiid();
		String name = req.getParameter("name").toUpperCase();
		String email = req.getParameter("email").toLowerCase();
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");

		Teacher t = new Teacher();

		t.setId(id);
		t.setName(name);
		t.setEmail(email);
		t.setPhone(phone);
		t.setGender(gender);

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String addTeacher = adminDaoImp.addTeacher(t);
		System.out.println(addTeacher);
		
		resp.sendRedirect("Admin/Dashboard.jsp");
		
		
		
	}

	private String uniqiid() {
		String prefix = "TEACH";
		int uniu = (int) ((Math.random() * (10000 - 1000)) + 1000);

		return prefix + uniu;

	}

}
