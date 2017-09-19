package com.back.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentUpdateApplyServlet
 */
@WebServlet("/StudentUpdateApply.sdo")
public class StudentUpdateApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 更新申请
		try{
			//初始化
			student_service stus=new student_service();
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			
			//取值
			String ItemID=request.getParameter("ItemID");
			Student stu=(Student) request.getSession().getAttribute("student");
			String Descripe=request.getParameter("Descripe");
			
			
			//判断是否已加入项目或有项目
			boolean a =stus.checkItem(stu.getID());
			boolean b=stus.checkApplyJoin(stu.getID());
			
			//执行
			if(a||!b){
				request.getRequestDispatcher("Back/student-collectFailed.jsp").forward(request, response);
			}else{
				if(stus.checkApplyDouble(ItemID,stu.getID())){
					stus.insertApply(stu, ItemID, Descripe, now);
				}
				request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
				
			}
			
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
