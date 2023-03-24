package com.deepak.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deepak.Admin.Admin;
import com.deepak.Admin.AdminDaoImp;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		Admin adminLoggin = adminDaoImp.AdminLoggin(username, password);
		HttpSession session = req.getSession();
		session.setAttribute("adminlogin", adminLoggin);
		resp.sendRedirect("Admin/Dashboard.jsp");

	}

}
