package com.back.student.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.model.StuApply;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentMyApplySetServlet
 */
@WebServlet("/StudentMyApplySet.sdo")
public class StudentMyApplySetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMyApplySetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 我的申请列表设置
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//执行查询
			List<StuApply> lapp=stus.queryMyApply(stu.getID());
			List<Item> lte=stus.queryAllItems();
			
			//存进Map
			Map<Integer,Item> ma=new HashMap<Integer,Item>();
			for(Item it:lte){
				ma.put(it.getID(),it);
			}
			
			//传值
			request.setAttribute("appList", lapp);
			request.setAttribute("item", ma);
			request.getRequestDispatcher("Back/student-myApply.jsp").forward(request, response);
			
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
