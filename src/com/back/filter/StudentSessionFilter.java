package com.back.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(urlPatterns={"*.sdo"})
public class StudentSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StudentSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)resp;
		String realURI =request.getRequestURI();
		
		String path = request.getContextPath();
	//	System.out.println(realURI+"+=====+   "+path);
		if(request.getSession().getAttribute("student")!=null||realURI.endsWith("StudentLogin.sdo")||realURI.endsWith("StudentLoginCheck.sdo")
				||realURI.endsWith("StudentForgetEmailCheck.sdo")||realURI.endsWith("StudentForgetPassword.sdo")||realURI.endsWith("StudentRegisterCheck.sdo")
				||realURI.endsWith("StudentCodeCheck.sdo")||realURI.endsWith("StudentRegister.sdo")||realURI.endsWith("StudentRegisterSuccess.sdo")
				||realURI.endsWith("StudentResendRegisterCode.sdo")||realURI.endsWith("StudentResendSet.sdo")){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("Back/student-login.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
