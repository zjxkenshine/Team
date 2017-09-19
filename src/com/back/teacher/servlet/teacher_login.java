package com.back.teacher.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_login
 */
@WebServlet("/teacher_login.do")
public class teacher_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String teac=(String) request.getSession().getAttribute("TeacherName");
			
			if(teac==null){
			String TeacherName = request.getParameter("TeacherName");
			String PassWord = request.getParameter("PassWord");
			String Code=request.getParameter("code");
			String rCode=(String) request.getSession().getAttribute("rCode");
			System.out.println(Code);
			
			if(("").equals(TeacherName.trim())||("").equals(PassWord.trim())){
				request.setAttribute("msg","账号或密码不能为空");
				request.getRequestDispatcher("Back/T_teacher_login.jsp").forward(request, response);
			}
			if(("").equals(Code.trim())){
	    		request.setAttribute("msg", "验证码不能为空");
	    		request.getRequestDispatcher("Back/T_teacher_login.jsp").forward(request, response);
	    	}
			if((Code.toUpperCase().equals(rCode))){//解决验证码大小写问题
			     teacher_service ts=new teacher_service();
			     try {
					ts.login(TeacherName, PassWord);
					
					request.getSession().setAttribute("TeacherName", TeacherName);
					request.getRequestDispatcher("Back/T_teacher_index.jsp").forward(request, response);				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("msg",e.getMessage());
					request.getRequestDispatcher("Back/T_teacher_login.jsp").forward(request, response);
				}
			     
			}else{
				request.setAttribute("msg","验证码错误");
				request.getRequestDispatcher("Back/T_teacher_login.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("Back/T_teacher_index.jsp").forward(request, response);
		}

	}

}
