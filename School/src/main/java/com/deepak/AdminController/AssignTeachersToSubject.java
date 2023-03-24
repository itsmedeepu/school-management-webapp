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

@WebServlet("/assignteachertosubject")
public class AssignTeachersToSubject extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		List<Teacher> allTeachersWhoNotMappped = adminDaoImp.getAllTeachersWhoNotMappped();
		List<HashMap<String, String>> allsubjects = adminDaoImp.getAllSubjects();

		HttpSession session = req.getSession();
		session.setAttribute("allteachers", allTeachersWhoNotMappped);
		session.setAttribute("allsubjects", allsubjects);

		resp.sendRedirect("Admin/AssignTeacherToSubject.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("im here");
	}

}
