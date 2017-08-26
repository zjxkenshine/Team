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

import com.back.model.Student;
import com.back.service.student_service;
import com.google.gson.Gson;

/**
 * Servlet implementation class StudentPasswordCheckServlet
 */
@WebServlet("/StudentPasswordCheck.sdo")
public class StudentPasswordCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPasswordCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 密码验证
		try{
			//初始化
		//	System.out.println("执行注册验证");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter();
			Map<String,String> map=new HashMap<String,String>();
			Gson gson = new Gson();
			
			//取值
			Student stu=(Student)request.getSession().getAttribute("student");
			String password=request.getParameter("param");   //值
			
			//验证密码
			if(password.equals(stu.getPassWord())){
				map.put("info","");
				map.put("status","y");
			}else{
				map.put("info","原密码不正确");
				map.put("status","n");
			}
			
			//返回值
			String json=gson.toJson(map);
			out.print(json);
			out.close();  
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
