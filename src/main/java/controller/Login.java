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

@WebServlet("/login")
public class Login  extends   HttpServlet//GenericServlet//
{

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String email=req.getParameter("email");
//		String pass=req.getParameter("pass");
//		
//       UserDao userdao=new UserDao();
//       User user=userdao.find(email);
//       if(user==null)
//       {
//    	   res.getWriter().print("<h1> Invalid user name </h1>");  
//       }
//       else {
//       if(user.getPass().equals(pass))
//       {
//    	   res.getWriter().print("<h1> Login Successful </h1>");
//       }
//       else {
//    	   res.getWriter().print("<h1>Invalid password </h1>");
//       }
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email=req.getParameter("email");
        String pass=req.getParameter("pass");
		
       UserDao userdao=new UserDao();
       User user=userdao.find(email);
       if(user==null)
       {
    	   res.getWriter().print("<h1> style=\"color: white;\" Invalid user name </h1>");  
    	   req.getRequestDispatcher("Login.html").include(req, res);
       }
       else {
       if(user.getPass().equals(pass))
       {
    	   req.getSession().setAttribute("id","anand" );
    	   res.getWriter().print("<h1>style=\"color: white;\" Login Successful </h1>");
    	   
    	   
//    	   res.sendRedirect("https://www.youtube.com/");
    	   
    	   
    	   List<User> list=userdao.fetchAll();
    	   
//    	   for(User u1:list)
//    	   {
//    		   res.getWriter().print("<h1> User Name: "+u1.getName()+"</h1>");
//    		   res.getWriter().print("<h1> User Name: "+u1.getPhno()+"</h1>");
//    		   res.getWriter().print("<h1> User Name: "+u1.getEmail()+"</h1>");
//    		   res.getWriter().print("<h1> User Name: "+u1.getPass()+"</h1>");
//    		   res.getWriter().print("<h1> User Name: "+u1.getGender()+"</h1>");
//    		   res.getWriter().print("<h1> User Name: "+u1.getAddress()+"</h1>");
//    		   
//    		   res.getWriter().print("----------------------------------------------");
//    		   res.getWriter().print("----------------------------------------------");
//    		   
//  	   }
//    	   
//    	   res.getWriter().print("<table border=\"1\">"
//    	   +"<tr"
//    		+"<th> User Name</th>"	
//    		+"<th> User Phone No</th>"	
//    		+"<th> User Email</th>"	
//    		+"<th> User Password</th>"	
//    		+"<th> User Gender</th>"
//    		+"<th> User address</th>"
//    		+"</tr>" );
//    	   
//    	   for(User u1 :list)
//    	   {
//    		   
//    		   res.getWriter().print("<tr><th>"+u1.getName()+"</th><th>"+u1.getPhno()+"</th><th>"+u1.getEmail()+"</th><th>"+u1.getPass()+"</th><th>"+u1.getGender()+"</th><th>"+u1.getAddress()+"</th></tr>");
//    	   }  
    	   
    	   req.setAttribute("list", list);
    	   req.getRequestDispatcher("Result.jsp").forward(req, res);
    	   
       }
       else {
    	   res.getWriter().print("<h1> style=\"color: white;\"Invalid password </h1>");
    	   req.getRequestDispatcher("Login.html").include(req, res);
       }
	}
	}
	

}
