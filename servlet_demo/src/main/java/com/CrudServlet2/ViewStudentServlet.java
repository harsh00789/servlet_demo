package com.CrudServlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewStudentServlet
 */
@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentServlet() {
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
		
		List<StudentBean> student = StudentDao.view();
		for(StudentBean sb : student) {
			
			out.print("<html><body>");
			out.print("<table style='border: 1px solid black;padding:10px'>");
				out.print("<tr><th>Student Id</th><th>Roll NO</th><th>Student Name</th><th>Password</th></tr>"
					+ "<tr><td>"+sb.getId()+"</td><td>"+sb.getRoll_no()+"</td><td>"+sb.getName()+"</td><td>"+sb.getPassword()+"</td></tr>"
					
					+ "</table>");
			
				out.print("</body></html>");
			


		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
