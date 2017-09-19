package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class StudentPassApplyServlet
 */
@WebServlet("/StudentPassApply.sdo")
public class StudentPassApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPassApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 申请通过
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String idString=request.getParameter("CollectID");
			Item ite=(Item) request.getSession().getAttribute("Item");
			
			//预处理
		//	System.out.println(idString);
			String [] lid=idString.split(",");
			int i=0;
			
			//执行通过
			for(String a:lid){
				if(i==ite.getNeedNumber()){
					break;
				}
				stus.passApply(a);
				
				//获取该学生ID
				List<StuApply> lte=stus.queryApplyById(a);
				int stuid=lte.get(0).getStuID();	
				
				//删除该学生其余申请
		//		System.out.println(stuid);
				stus.deleteApplyWhenJoin(stuid);
				
				i++;
			}
			
			int num1=0;
			int num2=0;
			if(ite.getNeedNumber()>lid.length){
				 num1=ite.getNumber()+lid.length;
				 num2=ite.getNeedNumber()-lid.length;
			}else{
				 num1=ite.getNumber()+ite.getNeedNumber();
				 num2=0;
			}
			
			stus.updateNumber(num1, num2,ite.getID());
		
			
			//跳转
			request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
