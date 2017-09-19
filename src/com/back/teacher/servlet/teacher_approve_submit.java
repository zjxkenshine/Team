package com.back.teacher.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_approve
 */
@WebServlet("/teacher_approve_submit.do")
@MultipartConfig(maxFileSize=10485760,fileSizeThreshold=88666)
public class teacher_approve_submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_approve_submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part1=request.getPart("QualificationCard");//接受文件
		Part part2=request.getPart("WorkCard");
		System.out.println(part1);
		
		String path=request.getServletContext().getRealPath("/up_teacherPicture/approve");//上传文件路径
		
		File folder=new File(path);//在"xx"路径下建了一个folder
		if(!folder.exists()){
			folder.mkdirs();
		}
		System.out.println(path);
		/**
		 * Tomcat 8.0版本
		 * 
		 * 但要记得导包，因为FilenameUtils需要两个包，在lib里面。
		 */		
		String submittedfilname=part1.getSubmittedFileName();//接受到的文件名
		String submittedfilname2=part2.getSubmittedFileName();
		//因为怕文件上传重名覆盖原文件问题，所以要弄一个随机取名的方法。
		//利用截取方法 来让“随机生成的文件名”与 “原文件的格式”结合
		String name=UUID.randomUUID().toString().replaceAll("-", "");//随机生成名字
		String ext=FilenameUtils.getExtension(submittedfilname);//截取文件的后缀名。例如： jpg
		String name2=UUID.randomUUID().toString().replaceAll("-", "");
		String ext2=FilenameUtils.getExtension(submittedfilname2);
		
		part1.write(path+"/"+name+"."+ext);//把要传入的  文件  写入(图片用这个地址)
		part2.write(path+"/"+name2+"."+ext2);
		String realpath=request.getContextPath();
		
		String QualificationCard=realpath+"/up_teacherPicture/approve/"+name+"."+ext;
		String WorkCard=realpath+"/up_teacherPicture/approve/"+name2+"."+ext2;
		String TeacherName=request.getParameter("TeacherName");
		
		Teacher teacher=new Teacher();
		teacher.setTeacherName(TeacherName);
		teacher.setQualificationCard(QualificationCard);
		teacher.setWorkCard(WorkCard);
		
		teacher_service ts=new teacher_service();
		try {
			ts.teacher_approve(teacher);
			
			response.sendRedirect("Back/T_submit_ok.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/T_teacher_approve.jsp").forward(request, response);
		}
	}

}
