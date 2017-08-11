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
 * Servlet implementation class StudentForgetEmailCheckServlet
 */
@WebServlet("/StudentForgetEmailCheck.sdo")
public class StudentForgetEmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentForgetEmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//忘记密码邮箱验证
		try{
			//初始化
			System.out.println("执行邮箱验证");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter();
			student_service stus=new student_service();
			Map<String,String> map=new HashMap<String,String>();
			Gson gson = new Gson();
			
			//取值
			String Email=request.getParameter("param");  //取得Email值
			
			//验证
			boolean bol=stus.checkForgetPasswordEmail(Email);
			if(bol){
				map.put("info","");
				map.put("status","y");
			}else{
				map.put("info","该邮箱不存在");
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
