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
 * Servlet implementation class StudentUpdateSelfMessageCheckServlet
 */
@WebServlet("/StudentUpdateSelfMessageCheck.sdo")
public class StudentUpdateSelfMessageCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateSelfMessageCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 更新个人信息-信息验证
		try{
			//初始化
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter();
			student_service stus=new student_service();
			Map<String,String> map=new HashMap<String,String>();
			Gson gson = new Gson();
			
			//取值
			String value=request.getParameter("param");   //值
			String name=request.getParameter("name");	  //字段
			String stuname=request.getParameter("stuname");
			String tel=request.getParameter("tel");
			String idcard=request.getParameter("idcard");
			
			//验重
			if(name.equals("StudentName")&&!stus.checkStudentUpdateSelfMessage(name, value, stuname)){
				map.put("info","该用户名已有人使用");
				map.put("status","n");
			}else if(name.equals("Tel")&&!stus.checkStudentUpdateSelfMessage(name, value, tel)){
				map.put("info","该号码已有人使用");
				map.put("status","n");
			}else if(name.equals("ID_Card")&&!stus.checkStudentUpdateSelfMessage(name, value, idcard)){
				map.put("info","该省份证号已有人使用");
				map.put("status","n");
			}else if(name.equals("Age")){
				int age=Integer.parseInt(value);
				//	System.out.println(age);
					if(age>30||age<16){
						map.put("info","年龄应该在16-30岁之间,请重新填写身份证号");
						map.put("status","n");
				}
			}else{
				map.put("info","");
				map.put("status","y");
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
