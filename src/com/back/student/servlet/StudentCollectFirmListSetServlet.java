package com.back.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.StuCollect;
import com.back.model.Firm;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentCollectFirmListSetServlet
 */
@WebServlet("/StudentCollectFirmListSet.sdo")
public class StudentCollectFirmListSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCollectFirmListSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 公司收藏列表
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student)request.getSession().getAttribute("student");
			String id=String.valueOf(stu.getID());
			List<StuCollect> lco=stus.queryFirmCollect(id);
		//	System.out.println(lco);
			List<Integer> lid=new ArrayList<Integer>();
			for(StuCollect co:lco){
				lid.add(co.getFirmID());
			}
			List<Firm> lf=stus.queryFirmCollectDetils(lid);
		//	System.out.println(lf);
			
			//传值跳转
			request.setAttribute("FirmCollectList", lf);
			request.getRequestDispatcher("Back/student-firmCollectList.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
