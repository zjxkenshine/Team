package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentDeleteMenberServlet
 */
@WebServlet("/StudentDeleteMenber.sdo")
public class StudentDeleteMenberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteMenberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 项目踢人
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String ID=request.getParameter("ID");
			Item ite=(Item) request.getSession().getAttribute("Item");
			
			//执行
			stus.ignoreApply(ID);
			int num1=ite.getNumber()-1;
			int num2=ite.getNeedNumber()+1;
			stus.updateNumber(num1,num2,ite.getID());
			
			
			//跳转
			request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
