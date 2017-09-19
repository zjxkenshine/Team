package com.back.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.model.TeaMessage;
import com.back.service.teacher_service;

/**
 * Servlet implementation class StudentTeacherMessageSetServlet
 */
@WebServlet("/StudentTeacherMessageSet.sdo")
public class StudentTeacherMessageSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentTeacherMessageSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 教师消息初始化
		try {
			//初始化
			teacher_service ts=new teacher_service();
			
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			List<TeaMessage> ltea=ts.queryTeacherMessage(stu.getID());
			
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
			request.getRequestDispatcher("Back/student-teacherMessage.jsp").forward(request, response);
		
		} catch (Exception e) {
	
	        request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
