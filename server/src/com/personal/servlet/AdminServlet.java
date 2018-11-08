package com.personal.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.business.User;
import user.dao.DaoUser;

@WebServlet(
		name = "AdminServlet", 
		description = "Controleur administration", 
		urlPatterns = {"/administration/*"}
		)
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher 	disp;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		System.out.println(path);
		req.setAttribute("AdminServlet", this.getServletConfig().getServletName());
		System.out.println(getServletName());
//		this.getServletContext().getRequestDispatcher("/Webapp_servlet-maven/WebContent/jsp/admin.jsp").forward(req, resp);
		
		if (path == "administration") doAdmin(req, resp);

		if (path == null || path.equals("/")) doAccueil(req, resp);
//		else if (path.equals("/addUser"))
//			try {
//				doAddUser(req, resp);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
	}

	
	private void doAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		disp = request.getRequestDispatcher("/admin.jsp");
		disp.forward(request,response);	
	}
	
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		disp = request.getRequestDispatcher("/jsp/index.jsp");
		disp.forward(request,response);	
	}

	protected void doAddUser(HttpServletRequest request, HttpServletResponse response) throws SQLException  {

		int user_id = 0;
		String user_name = request.getParameter("user_name");
		String user_first_name = request.getParameter("user_first_name");
		String user_mail = request.getParameter("user_mail");
		String user_password = "123";
		//		boolean user_active = request.getParameter("user_active") != null;
		//		boolean user_admin = request.getParameter("user_admin") != null;
		//		boolean user_online = request.getParameter("user_first_name");
		//		LocalDateTime user_last_connection = request.getParameter("user_last_connection");
		LocalDate user_creation_date = LocalDate.now();

		User user = new User (user_id, user_name, user_first_name, user_mail,user_password, user_creation_date);

		DaoUser daoUser = new DaoUser();
		daoUser.createUser(user);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}

