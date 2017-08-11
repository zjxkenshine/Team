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
 * Servlet implementation class StudentRegisterCheckServlet
 */
@WebServlet("/StudentRegisterCheck.do")
public class StudentRegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//学生注册验证
		try{
			//初始化
			System.out.println("执行注册验证");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out1 =response.getWriter();
			student_service stus=new student_service();
			Map<String,String> map=new HashMap<String,String>();
			Gson gson = new Gson();
			
			//取值
			String value=request.getParameter("param");   //值
			String name=request.getParameter("name");	  //字段
			
			//验重
			if(name.equals("StudentName")&&!stus.checkStudentRegister(name, value)){
				map.put("info","该用户名已有人使用");
				map.put("status","n");
			}else if(name.equals("Tel")&&!stus.checkStudentRegister(name, value)){
				map.put("info","该号码已有人使用");
				map.put("status","n");
			}else if(name.equals("Email")&&!stus.checkStudentRegister(name, value)){
				map.put("info","该邮箱已有人使用");
				map.put("status","n");
			}else{
				map.put("info","");
				map.put("status","y");
			}
			
			//返回值
			String json=gson.toJson(map);
			out1.print(json);
			
			out1.close();  
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
