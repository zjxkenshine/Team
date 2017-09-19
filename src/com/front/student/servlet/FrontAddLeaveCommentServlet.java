package com.front.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.model.TeaMessage;
import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class FrontAddLeaveCommentServlet
 */
@WebServlet("/FrontAddLeaveComment.so")
public class FrontAddLeaveCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontAddLeaveCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 学生留言
		try{
			//初始化
			teacher_service teas=new teacher_service();
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			TeaMessage team=new TeaMessage();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String id=request.getParameter("ID");
			String mesg=request.getParameter("mesg");
		
			//查询
			Teacher tea=teas.queryoneteacher(Integer.parseInt(id));
			
			//存值
			team.setDate(now);
			team.setMessage(mesg);
			team.setReplyID(0);
			team.setStatus("0");
			team.setStuID(stu.getID());
			team.setStuName(stu.getStudentName());
			team.setStuPicture(stu.getPicture());
			team.setStuSchool(stu.getSchool());
			team.setType("1");
			team.setTeacherName(tea.getTeacherName());
			team.setTecherID(tea.getID());
			
			//更新数据库
			teas.addLeaveMessage(team);
			
			//跳转
			response.sendRedirect("teacher_singleinfo.so?ID="+id);
			
			
		}catch(Exception e){
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
