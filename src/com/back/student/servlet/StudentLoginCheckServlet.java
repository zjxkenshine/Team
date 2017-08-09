package com.back.student.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.student_service;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/StudentLoginCheck.do")
public class StudentLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证学生登录
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		Gson gson = new Gson();
		student_service stuse=new student_service();
		String rcord =(String)request.getSession().getAttribute("rCode");  //获取验证码
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(user +","+ password);
		
		try{
			 Map<String,Object> map=stuse.loginCheck(user, password);
			 map.put("rcode", rcord);
			 System.out.println(map);
			String json =gson.toJson(map);
    		out.write(json);
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
	}

}
