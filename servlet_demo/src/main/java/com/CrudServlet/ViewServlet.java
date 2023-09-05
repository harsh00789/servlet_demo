package com.CrudServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		
List<EmpPojo> employee = EmpDao.view();
		
		
		out.print("<table style='border:1px solid black'>");
		out.print("<tr><th>id</th><th>name</th><th>password</th><th>email</th><th>country</th><th>Edit</th><th>Delete</th></tr>");
		
		for(EmpPojo em : employee) {
		
		out.print("<tr><td>"+em.getId()+"</td><td>"+em.getName()+"</td><td>"+em.getPassword()+"</td><td>"+em.getEmail()+"</td><td>"+em.getCountry()+"</td><td><br><form action='EditBridge'><input type='hidden' name='name' value="+em.getName()+"><input type='hidden' name='password' value="+em.getPassword()+"><input type='hidden' name='email' value="+em.getEmail()+"><input type='hidden' name='country' value="+em.getCountry()+"><input type='hidden' name='i' value="+em.getId()+"><input type='submit' value='edit'></form></td><td><br><form action='DeleteServlet' ><input type='hidden' name='id' value="+em.getId()+"><input type='submit' value='delete'></form></td></tr>");
		
		}
		out.print("</table>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
