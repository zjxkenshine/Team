package com.back.teacher.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.TeaMessage;
import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class TeacherReplyLeaveMessageServlet
 */
@WebServlet("/TeacherReplyLeaveMessage.do")
public class TeacherReplyLeaveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherReplyLeaveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 老师回复学生
		try {
			//初始化
			teacher_service teas=new teacher_service();
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			
			
			
			//取值
			String TeacherName=(String) request.getSession().getAttribute("TeacherName");
			String id=request.getParameter("ID");
			String message=request.getParameter("message");
		//	System.out.println(id+"*******"+TeacherName+"********"+message);
			
			//查询
			Teacher te=teas.queryoneteacher(TeacherName);
			TeaMessage team1=teas.queryReply(Integer.parseInt(id));
			
			System.out.println(te);
			System.out.println(team1);
			
			//接值
			TeaMessage team=new TeaMessage();
			team.setDate(now);
			team.setMessage(message);
			team.setReplyID(Integer.parseInt(id));
			if(team1.getStatus().equals("0")){
				team.setStatus("1");
			}else{
				team.setStatus("2");
			}
			team.setStuID(team1.getStuID());
			team.setStuName(team1.getStuName());
			team.setStuPicture(team1.getStuPicture());
			team.setStuSchool(team1.getStuSchool());
			team.setType("2");   //老师回复学生
			team.setTeacherName(te.getTeacherName());
			team.setTecherID(te.getID());
			
			//更新数据库
			teas.addLeaveMessage(team);
					
			//跳转
			request.getRequestDispatcher("Back/T_teacher_replysuccess.jsp").forward(request, response);
			
		}catch (Exception e) {
	        request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
