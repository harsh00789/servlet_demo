package com.CrudServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBridge
 */
@WebServlet("/EditBridge")
public class EditBridge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBridge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmpPojo e = new EmpPojo();
		String i = request.getParameter("i");
		int id = Integer.parseInt(i);
	//	out.print(id);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		out.print("<form action='EditServlet'><table>\r\n"
				+ "	<tr><td><input type=\"hidden\" value="+id+" name=\"uid\"></td></tr>\r\n"
				+ "	<tr><td>Name:</td><td><input type=\"text\" value="+name+"  name=\"uname\"></td></tr>\r\n"
				+ "	<tr><td>Password:</td><td><input type=\"password\" value="+password+" name=\"pass\"></td></tr>\r\n"
				+ "	<tr><td>Email:</td><td><input type=\"email\" value="+email+" name=\"email\"></td></tr>\r\n"
				+ "	<tr><td>Country:</td><td>\r\n"
				+ "		<select name=\"country\" value="+country+" style=\"width: 150px;\">\r\n"
				+ "			<option>India</option>\r\n"
				+ "			<option>America</option>\r\n"
				+ "			<option>Canada</option>\r\n"
				+ "			<option>Australia</option>\r\n"
				+ "		</select>\r\n"
				+ "		\r\n"
				+ "	</td></tr>\r\n"
				+ "	<tr><td><input type=\"submit\" value=\"save employee\"></td></tr>\r\n"
				+ "</table></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
