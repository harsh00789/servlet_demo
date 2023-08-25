package com.ConfigObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigDemo2
 */
@WebServlet(urlPatterns = "/ConfigDemo2",

		initParams = { @WebInitParam(name = "lastname", value = "thaker"),
				@WebInitParam(name = "firstname", value = "harsh"),

				@WebInitParam(name = "collage", value = "atmiya")

		}

)
public class ConfigDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigDemo2() {
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
		
		
		ServletConfig config = getServletConfig();
		
		Enumeration<String> e = config.getInitParameterNames();
		
		System.out.println(e);
		String str = "";
		while(e.hasMoreElements()) {
			
			str =e.nextElement();
           out.print("<br>"+str);
           out.print(" : "+config.getInitParameter(str));
           
           
		}
		
		System.out.println(config.getInitParameter(str));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
