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
import com.mysql.cj.Session;

@WebServlet("/adminupdateprofile")
public class AdminUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("adminlogin");
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		Admin adminById = adminDaoImp.getAdminById(admin.getId());
		session.setAttribute("adminlogin", adminById);
		resp.sendRedirect("Admin/updateprofile.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name").toUpperCase();
		String email = req.getParameter("email").toLowerCase();
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Admin admin = new Admin();

		admin.setId(id);
		admin.setName(name);
		admin.setEmail(email);
		admin.setPhone(phone);
		admin.setUsername(username);
		admin.setPassword(password);

		AdminDaoImp adminDaoImp = new AdminDaoImp();
		String updateAdmin = adminDaoImp.updateAdmin(admin);
		HttpSession session = req.getSession();
		
		Admin adminById = adminDaoImp.getAdminById(id);
		session.setAttribute("adminlogin", adminById);
		resp.sendRedirect("Admin/Dashboard.jsp");

	}

}
