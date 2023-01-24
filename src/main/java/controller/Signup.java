package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
@WebServlet("/sign")
public class Signup  extends HttpServlet{
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	
	
		// TODO Auto-generated method stub
//		String name=req.getParameter("name");
//		long phno=Long.parseLong(req.getParameter("phno"));
//		String email=req.getParameter("email");
//		String pass=req.getParameter("password");
//		String gender=req.getParameter("gen");
//		String add=req.getParameter("address");s
		
//		System.out.println("Name:"+name);
//		System.out.println("P_Number:"+phno);
//		System.out.println("E-Mail:"+email);
//		System.out.println("Password:"+pass);
//		System.out.println("Gender:"+gender);
//		System.out.println("Address:"+add);
//		
//		res.getWriter().println("Name:"+name);
//		res.getWriter().println("P_Number:"+phno);
//        res.getWriter().println("E-Mail:"+email);
//        res.getWriter().println("Password:"+pass);
//        res.getWriter().println("Gender:"+gender);
//        res.getWriter().println("Address:"+add);
		
		User user=new User();
		user.setName(req.getParameter("name"));
		user.setPhno(Long.parseLong(req.getParameter("phno")));
		user.setEmail(req.getParameter("email"));
        user.setPass(req.getParameter("password"));
        user.setGender(req.getParameter("gen"));
        user.setAddress(req.getParameter("address"));
        
        UserDao userdao=new UserDao();
        try {
        userdao.save(user);
        res.getWriter().print("<h1> style=\"color: white;\"Account created successfully</h1>");
//      res.getWriter().print("<h1> Account Signed Up Successfully</h1><br><a href=\"Login.html\">Click here to Login</a>");
       req.getRequestDispatcher("Login.html").include(req, res);

        
        }
        catch(Exception e)
        {
        	 res.getWriter().print("<h1>Email already excepted</h1>");
//           res.getWriter().print("<h1> Account Signed Up Successfully</h1><br><a href=\"Login.html\">Click here to Login</a>");
            req.getRequestDispatcher("Signup.html").include(req, res);
        }
        
}

}
