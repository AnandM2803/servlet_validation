package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Logout")
public class Logout extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getSession().invalidate();
		resp.getWriter().print("<h1style=\"color: white;\"> Logout Seccessfull</h1>");
		req.getRequestDispatcher("Lohin.html").include(req, resp);
	}
}
