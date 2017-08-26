package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentUpdateSelfMessageServlet
 */
@WebServlet("/StudentUpdateSelfMessage.sdo")
public class StudentUpdateSelfMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateSelfMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//学生信息修改，执行
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu1=(Student) request.getSession().getAttribute("student");
			System.out.println(stu1);
			Student stu=new Student();
			String StudentName=request.getParameter("StudentName");
			String Tel=request.getParameter("Tel");
			String ID_Card=request.getParameter("ID_Card");
			String RealName=request.getParameter("RealName");
			String Age=request.getParameter("Age");
			String Sex=request.getParameter("sex");
			String Motto=request.getParameter("Motto");
			String Home=request.getParameter("Home");
			
			//往学生类存值
			stu.setID(stu1.getID());
			stu.setStudentName(StudentName);
			stu.setTel(Tel);
			stu.setID_Card(ID_Card);
			stu.setRealName(RealName);
			stu.setAge(Integer.parseInt(Age));
			stu.setSex(Sex);
			stu.setMotto(Motto);
			stu.setHome(Home);
			System.out.println(stu);
			
			//执行更新
			stus.updateStudentSelfMessage(stu);
			
			//跳转
			response.sendRedirect("StudentSelfMessageSet.sdo");
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
