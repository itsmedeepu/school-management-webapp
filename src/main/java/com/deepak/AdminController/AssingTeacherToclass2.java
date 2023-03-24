package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;

@WebServlet("/assinteachertoclass1")
public class AssingTeacherToclass2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherid = req.getParameter("teacherid");
		int classid = Integer.parseInt(req.getParameter("classid"));

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String assignTeacher = adminDaoImp.assignTeacher(teacherid, classid);
		System.out.println(assignTeacher);
		resp.sendRedirect("Admin/AssignTeacherToClass.jsp");
		
	}
	

}
