package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;
@WebServlet("/addsubject")
public class AddSubject extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Admin/AddSubject.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name=req.getParameter("name").toUpperCase();
		
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String addSubject = adminDaoImp.addSubject(id, name);
		System.out.println(addSubject);
		
		resp.sendRedirect("Admin/Dashboard.jsp");
	}

}
