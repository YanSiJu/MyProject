package com.ascent.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.dao.UserDao;
import com.ascent.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = new UserDao();
		String userName = request.getParameter("name");
		String pwd = request.getParameter("password");
		User user = dao.login(userName, pwd);
		if (user != null) {
			request.getSession().setAttribute("userInfo", user);
		} else {
			response.sendRedirect("/login.html");
		}
	}

	public void dealWithVisitCountWithSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer visitCount = (Integer) session.getAttribute("visitCount");
		if (visitCount == null) {
			session.setAttribute("visitCount", Integer.valueOf(1));
		} else {
			session.setAttribute("visitCount", ++visitCount);
		}
	}

	public void dealWithVisitCountWithCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("visitCount".equals(cookie.getName())) {
					Integer count = Integer.valueOf(cookie.getValue());
					cookie.setValue(String.valueOf(++count));
					return;
				}
			}
		}
		Cookie cookie = new Cookie("visitCount", String.valueOf(1));
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
		response.setContentType("text/html;charset=UTF-8");
	}

}
