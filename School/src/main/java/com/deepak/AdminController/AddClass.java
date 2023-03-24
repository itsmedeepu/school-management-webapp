package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepak.Admin.AdminDaoImp;

@WebServlet("/addclass")
public class AddClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Admin/AddClass.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name").toUpperCase();
		String discription = req.getParameter("description");
		
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String addClass = adminDaoImp.addClass(name, discription);
		System.out.println(addClass);
		
		resp.sendRedirect("Admin/Dashboard.jsp");

	}

}
