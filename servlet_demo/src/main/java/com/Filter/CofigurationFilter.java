package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CofigurationFilter
 */
@WebFilter(urlPatterns = {
		"/ConfigurationServlet"},
		

initParams = { @WebInitParam(name = "lastname", value = "thaker"),
		@WebInitParam(name = "firstname", value = "harsh"),

		@WebInitParam(name = "collage", value = "atmiya")

}
		
		)
public class CofigurationFilter extends HttpFilter implements Filter {
	FilterConfig fConfig;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CofigurationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    
    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
    	
    	this.fConfig = fConfig;
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
      //fconfig = getFilterConfig();
       
       
        String s = fConfig.getInitParameter("collage");
       
        
        if(s.equals("atmiya")) {
        	 chain.doFilter(request, response);
        	  
   }else {
	   
	   out.print("collage is not found");
	
	   
   }
        
		
		// pass the request along the filter chain
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	}
