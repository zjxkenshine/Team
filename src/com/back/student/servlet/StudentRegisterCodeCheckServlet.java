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

import com.google.gson.Gson;

/**
 * Servlet implementation class StudentRegisterCodeCheckServlet
 */
@WebServlet("/StudentCodeCheck.sdo")
public class StudentRegisterCodeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterCodeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 邮箱验证码验证
		try{
			//初始化
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter();
			Map<String,String> map=new HashMap<String,String>();
			Gson gson = new Gson();
			
			//取值
			String value=request.getParameter("param");   
			int rcode=(Integer)request.getSession().getAttribute("Code");
			String code=String.valueOf(rcode);
			
			
			//验证码验证
			if(value.equals(code)){
				map.put("info","");
				map.put("status","y");
			}else{
				map.put("info","验证码错误");
				map.put("status","n");
			}
			//返回值
			String json=gson.toJson(map);
			out.print(json);
			
			
	 
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
