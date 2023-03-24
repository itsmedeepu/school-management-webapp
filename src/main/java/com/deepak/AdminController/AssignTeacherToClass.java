package com.deepak.AdminController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deepak.Admin.AdminDaoImp;
import com.deepak.Teacher.Teacher;

@WebServlet("/assignteachertoclass")
public class AssignTeacherToClass extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		List<Teacher> allTeachers = adminDaoImp.getAllTeachersWhoNotMappped();
		List<HashMap<String, String>> allClasses = adminDaoImp.getAllClasses();

		HttpSession session = req.getSession();
		session.setAttribute("allclasses", allClasses);
		session.setAttribute("allteachers", allTeachers);

		resp.sendRedirect("Admin/AssignTeacherToClass.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherid = req.getParameter("teacherid");
		int classid = Integer.parseInt(req.getParameter("classid"));

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String assignTeacher = adminDaoImp.assignTeacher(teacherid, classid);
		System.out.println(assignTeacher);
//		resp.sendRedirect("Admin/AssignTeacherToClass.jsp");

	}

}
