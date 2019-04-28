import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SignUp extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		PrintWriter out=null;
		res.setContentType("text/html");
		out=res.getWriter();
		try{
		String u=req.getParameter("email");
		String p=req.getParameter("pass");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","toor");
		Statement st=con.createStatement();
		int i=st.executeUpdate("INSERT INTO user_info VALUES('"+u+"','"+p+"'')");
		if(i>0){
			res.sendRedirect("AboutYou");
		}
		else
			res.sendRedirect("loginError.html");
	}catch(Exception ex){
		out.println(ex);
		}
		}
}
