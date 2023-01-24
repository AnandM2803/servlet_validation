package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/update")
public class Update  extends  HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		User user=new User();
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setName(req.getParameter("name"));
		user.setPhno(Long.parseLong(req.getParameter("phno")));
		user.setEmail(req.getParameter("email"));
        user.setPass(req.getParameter("password"));
        user.setGender(req.getParameter("gen"));
        user.setAddress(req.getParameter("address"));
        
        UserDao dao=new UserDao();
       dao.merge(user);
       
       List<User> list=dao.fetchAll();
       
       req.setAttribute("list", list);
	   req.getRequestDispatcher("Result.jsp").forward(req, res);
	}
}
