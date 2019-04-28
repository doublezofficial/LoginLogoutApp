import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AS extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		PrintWriter out=null;
		res.setContentType("text/html");
		out=res.getWriter();
		try{
		String e=req.getParameter("email");
		String p=req.getParameter("password");
		String n=req.getParameter("name");
		String a=req.getParameter("age");
		String ph=req.getParameter("phone");
		String i=req.getParameter("interest");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","toor");
		Statement st=con.createStatement();
		int j=st.executeUpdate("INSERT into user_info values('"+e+"','"+p+"','"+n+"','"+a+"','"+ph+"','"+i+"')");
		if(j>0){
			res.sendRedirect("Success.html");
		}
		else
			res.sendRedirect("loginError.html");
	}catch(Exception ex){
		out.println(ex);
		}
	}
}
