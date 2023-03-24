package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;

@WebServlet("/assinteachertosubject1")
public class AssignTeacherToSubject1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subjectid = req.getParameter("subjectid");
		String teacherid = req.getParameter("teacherid");

		System.out.println(subjectid);
		System.out.println(teacherid);

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String mapTeacherToSubject = adminDaoImp.mapTeacherToSubject(teacherid, subjectid);
		System.out.println(mapTeacherToSubject);

		resp.sendRedirect("Admin/AssignTeacherToSubject.jsp");

	}

}
