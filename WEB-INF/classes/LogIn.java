import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LogIn extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		PrintWriter out=null;
		res.setContentType("text/html");
		out=res.getWriter();
		try{
		String u=req.getParameter("email");
		String p=req.getParameter("password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","toor");
		PreparedStatement st=con.prepareStatement("Select * from user_info where email=? AND password=?");
		st.setString(1,u);
		st.setString(2,p);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			out.println("<style>html{background: radial-gradient(#999, #222);min-height:100%;font-family: "Roboto",");
			out.println(" sans-serif;}.wrap{	 max-width: 600px;margin: 50px auto;}");
			out.println(".bodies{	 position: relative;}".header{	width: 100%;	background: white;	border-bottom:1px solid rgba(0,0,0,.5););
			out.println("padding: 10px 0px;	text-align: center;	border-top-left-radius:3px;	");
			out.println("border-top-right-radius:3px;color:rgba(0,0,0,0.7);}");
			out.println(".body{	background: white;	padding: 40px 100px;");
			out.println("position: absolute;	box-shadow: 0px 50px 30px -30px rgba(0, 0, 0, 0.3);");
			out.println("box-sizing: border-box; 	width: 100%;	border-bottom-left-radius: 3px;");
			out.println("border-bottom-right-radius:3px;}");
			out.println(".description {  text-align: center;  color: #666;  margin-bottom: 30px;}");
			out.println("input[type="email"],input[type="text"],input[type="password"]{	padding:10px 20px;");
			out.println("	display:block;	margin-bottom:20px;	border-radius: 3px;	box-sizing: border-box;");
			out.println("border:1px solid #999;	width:100%;}");
			out.println("input[type="password"]:focus,input[type="text"]:focus,");
			out.println("input[type="email"]:focus {  border-color: #000;}");
			out.println(".button{	padding: 10px 20px;	background: #888;	color: white;");
			out.println("text-transform: uppercase;	width:100%;	display:block;	cursor: pointer;}");
			out.println(".text-center{	text-align:center;color: #666;}");
			out.println(".button:hover{  background: #666;  color: white;}");
			out.println(".login-error{	color:red;	margin-bottom: 10px;	padding: 10px 0;	width:100%;}");
			out.println("");
			out.println("<head><title>FormDZ</title><link rel='stylesheet'	type='text/css' href='style.css'>");
			out.println("</head><body><div class='wrap'><div class='header'>VIrtual Desktop Project 1</div>");
			out.println("<div class='bodies'><div class='body'>");
			out.println("<div class='description'>Your <i><b>details</b></i> are shown down below.</div>");
			out.println(rs.getString(3)+" is now active.");
			out.println("<form action='index.html' method='post'>");
			out.println("<input type='submit' class='button' name='LogOut' value='LogOut'>");
			out.println("</form></div></div>");
			out.println("</div><script type='text/javascript' src='code-jquery.js'></script>");
			out.println("<script type='text.javascript' src='jquery-3.1.1.min.js'></script></body>");
		}
		else
			res.sendRedirect("loginError.html");
		out.close();
	}catch(Exception ex){
		out.println(ex);
		}
	}
}
