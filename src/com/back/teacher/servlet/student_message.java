package com.back.teacher.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.TeaMessage;
import com.back.model.Teacher_Stu_Messages;
import com.back.service.teacher_service;

/**
 * Servlet implementation class student_message
 */
@WebServlet("/student_message.do")
public class student_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 学生消息加载
		String TeacherName=(String) request.getSession().getAttribute("TeacherName");
	  //  System.out.println(TeacherName+"***********+++");
		
		try {
			//初始化
			teacher_service ts=new teacher_service();
			
			//取值
			List<TeaMessage> ltea=ts.queryStudentMessage(TeacherName);
			
			List<TeaMessage> lt=new ArrayList<TeaMessage>();
			//System.out.println(ltea);
					
				for(TeaMessage tea:ltea){
					if(tea.getReplyID()!=0){
					TeaMessage tea1=ts.queryReply(tea.getReplyID());
					lt.add(tea1);
					}
				}
				
			System.out.println(ltea+"************"+lt);
			request.setAttribute("messagelist",ltea );
			request.setAttribute("replylist",lt );
			request.getRequestDispatcher("Back/T_student_message.jsp").forward(request, response);
		
		} catch (Exception e) {
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
