package com.back.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.back.model.Collect;
import com.back.model.Firm;
import com.back.model.Recruit;
import com.back.model.Resume;
import com.back.model.Student;
import com.back.model.Student_Province;
import com.back.util.DBUtil;

public class student_dao {
	
	//登录验证
	public Map<String,Object> loginCheck(String user,String password){
		String sql="select * from student where (StudentName=? and PassWord=?) or (Tel=? and PassWord=?) or (Email=? and PassWord=?) or (ID_Card=? and PassWord=? and ID_Card!=null)";
	//	System.out.println(sql); 
		List<Map<String,Object>> stulist=DBUtil.list(sql,new Object[]{user,password,user,password,user,password,user,password});
		Map<String,Object> mesg=new HashMap<String,Object>();
		if(stulist.size()>1){
			mesg.put("flag",0);
			mesg.put("msg","登录失败，您的用户名密码与他人冲突，建议您修改密码或修改登录方式！" );
		}else if(stulist.size()==1){
			String stu=(String)stulist.get(0).get("Status");
			if (stu.equals("1")){
				mesg.put("flag", 1);
				mesg.put("msg","登陆成功！");
				mesg.put("stuid",(int) stulist.get(0).get("ID"));
			}else{
				mesg.put("flag",0);
				mesg.put("msg","登录失败,该账号已被冻结！");
			}
			
		}else if(stulist.size()<1){
			mesg.put("flag",0);
			mesg.put("msg","登录失败,账号或密码错误！");
		}
		return mesg;
		
	}
	
	//查询所有学生
	public List<Student> queryAllStudent(){
		Student stu= new Student();
		String sql ="select * from student";
		List<Map<String,Object>> lmap=DBUtil.list(sql);
		
		return null;
	}
	
	//根据ID查询学生信息
	public Student queryOneStudent(String stuid){
		Student stu= new Student();
		String sql ="select * from student where ID=?";
		Map<String,Object> map=DBUtil.query(sql, stuid);
		if(map!=null){
			//把值存进Student类
			stu.setAcademy((String)map.get("Academy"));
			stu.setAge((int)map.get("Age"));
			stu.setEducationBgd((String)map.get("EducationBgd"));
			stu.setEmail((String)map.get("Email"));
			stu.setHome((String)map.get("Home"));
			stu.setID((int)map.get("ID"));
			stu.setID_Card((String)map.get("ID_Card"));
			stu.setIntention((String)map.get("Intention"));
			stu.setMajor((String)map.get("Major"));
			stu.setMotto((String)map.get("Motto"));
			stu.setPassWord((String)map.get("PassWord"));
			stu.setPicture((String)map.get("Picture"));
			stu.setProvince((String)map.get("Province"));
			stu.setResume((String)map.get("Resume"));
			stu.setResumeTime((String)map.get("ResumeTime"));
			stu.setSchool((String)map.get("School"));
			stu.setSex((String)map.get("Sex"));
			stu.setStatus((String)map.get("Status"));
			stu.setStudentName((String)map.get("StudentName"));
			stu.setTel((String)map.get("Tel"));
			stu.setRegisterTime((String)map.get("RegisterTime"));
			stu.setRealName((String)map.get("RealName"));
			stu.setRegisterStatus((String)map.get("RegisterStatus"));
			stu.setLastLoginTime((String)map.get("LastLoginTime"));
			stu.setLoginNum((int)map.get("LoginNum"));
			stu.setCheckStatus((String)map.get("CheckStatus"));
			stu.setIdPic((String)map.get("IdPic"));
		}
		return stu;
	}
	
	//学生注册验证
	public boolean checkStudentRegister(String name,String value){
		String sql="select * from student where "+name+"=?";
	//  System.out.println(sql);
		Map<String,Object> map =DBUtil.query(sql, value);
		if(map.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//添加注册学生
	public int addRegisterStudent(Student stu){
		String sql ="insert into student(StudentName,PassWord,Tel,Email,RegisterStatus,Status,RegisterTime) values(?,?,?,?,?,?,?)";
		int i=DBUtil.executeUpdate(sql, new Object[]{stu.getStudentName(),stu.getPassWord(),stu.getTel(),stu.getEmail(),stu.getRegisterStatus(),stu.getStatus(),stu.getRegisterTime()});
		return i;
	}
	
	//注册成功解封账号
	public int studentRegisterUpdate(String Email){
		String sql="update student set Status='1',RegisterStatus='1' where Email=? and RegisterStatus='0'";
		int i=DBUtil.executeUpdate(sql,Email);
		return i;
	}
	
	//忘记密码邮箱验证
	public boolean checkForgetPasswordEmail(String Email){
		String sql="select ID from student where Email=?";
		List<Map<String,Object>> stulist=DBUtil.list(sql,Email);
		if(stulist.size()==1){
			return true;
		}else{
			return false;
		}
	}
	
	//忘记密码身份验证
	public String checkForgetPassword(String Email,String StudentName,String Tel){
		String sql="select PassWord from student where (Email=? and Tel=?) or (Email=? and StudentName=?)";
		List<Map<String,Object>> stulist=DBUtil.list(sql,new Object[]{Email,Tel,Email,StudentName});
		if(stulist.size()==1){
			return (String) stulist.get(0).get("PassWord");
		}else{
			return null;
		}
	}
	
	//更新学生登录信息
	public int updateStudentLoginMessage(String now,int num,String id){
		String sql="update student set LoginNum=?,LastLoginTime=? where ID=?";
		System.out.println(sql);
		int i =DBUtil.executeUpdate(sql, new Object[]{num,now,id});
		return i;
	}
	
	//更新学生密码
	public int updateStudentPassword(String stuid,String password){
		String sql="update student set PassWord=? where ID=?";
	//	System.out.println(sql);
		int i=DBUtil.executeUpdate(sql,new Object[]{password,stuid});
		return i;
	}
	
	//查询省份信息
	public List<Student_Province> queryProvinceAll(){
		String sql="select * from cms_provinces";
		List<Map<String,Object>> lmp=DBUtil.list(sql);
		if(lmp.size()>0){
			List<Student_Province> lpro=new ArrayList<Student_Province>();
			for(int i=0;i<lmp.size();i++){
				Student_Province pro=new Student_Province();
				pro.setProvince_id((int)lmp.get(i).get("province_id"));
				pro.setProvince((String)lmp.get(i).get("province"));
				lpro.add(pro);
			}
			return lpro;
		}else{
			return null;
		}
	}
	
	//查询学校信息
	public List<Map<String,Object>> queryUniversity(String province){
		String sql="select university from cms_provinces as pro,cms_university as sch where pro.province_id=sch.province_id and pro.province=?";
	//	System.out.println(sql);
		List<Map<String,Object>> lmp=DBUtil.list(sql,province);
		if(lmp.size()>0){
			return lmp;
		}else{
			return null;
		}
	}
	
	//查询学院信息
	public List<Map<String,Object>> queryAcademy(String school){
		String sql="select college from cms_university as sch,cms_college as aca where sch.university_id=aca.university_id and sch.university=?";
		List<Map<String,Object>> lmp=DBUtil.list(sql,school);
	//	System.out.println(lmp);
		if(lmp.size()>0){
			return lmp;
		}else{
			return null;
		}
	}
	
	//更新学生学校信息
	public int updateStudentSchool(String province,String school,String academy,String major,int stuid){
		String sql="update student set Province=?,School=?,Academy=?,Major=? where ID=?";
		int i=DBUtil.executeUpdate(sql,new Object[]{province,school,academy,major,stuid});
		return i;
	}
	
	//个人信息修改验证
	public boolean checkStudentUpdateSelfMessage(String name,String value,String value2){
	//	System.out.println(name+","+value+","+value2);
		String sql="select * from student where "+name+"=? and "+name+"!=?";
	//  System.out.println(sql);
		Map<String,Object> map =DBUtil.query(sql,new Object[]{value,value2});
		if(map.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//更新学生个人信息
	public int updateStudentSelfMessage(Student stu){
		String sql="update student set StudentName=?,Tel=?,ID_Card=?,Home=?,Motto=?,Age=?,Sex=?,RealName=? where ID=?";
		int i = DBUtil.executeUpdate(sql, new Object[]{stu.getStudentName(),stu.getTel(),stu.getID_Card(),stu.getHome(),stu.getMotto(),stu.getAge(),stu.getSex(),stu.getRealName(),stu.getID()});
		return i;
	}
	
	//上传简历
	public int uploadResume(String url,String time,String id){
		String sql="update student set Resume=?,ResumeTime=? where ID=?";
		int i = DBUtil.executeUpdate(sql, new Object[]{url,time,id});
		return i;
	}
	
	//真实信息验证
	public int updateSelfMessageCheck(String RealName,String EducationBgd,String IdPic,String Picture,String id){
		String sql="update student set RealName=?,EducationBgd=?,IdPic=?,Picture=?,CheckStatus='1' where ID=?";
		int i=DBUtil.executeUpdate(sql,new Object[]{RealName,EducationBgd,IdPic,Picture,id});
		return i;
	}
	
	//收藏招聘信息
	public List<Collect> queryRecruitCollect(String id){
		String sql="select * from stu_collect where StuID=? and RecruitID is not null and FirmID is null";
		List<Map<String,Object>> lmap=DBUtil.list(sql,id);
		List<Collect> lco=new ArrayList<Collect>();
		System.out.println(lco);
		if(lmap!=null){
			for(int i=0;i<lmap.size();i++){
				Collect col=new Collect();
				col.setStuID((int)lmap.get(i).get("StuID"));
				col.setCollectID((int)lmap.get(i).get("CollectID"));
				col.setRecruitID((int)lmap.get(i).get("RecruitID"));
				col.setCollectTime((String)lmap.get(i).get("CollectTime"));
				lco.add(col);
			}
			return lco;
		}else{
			return null;
		}
		
	}
	
	//收藏公司信息
	public List<Collect> queryFirmCollect(String id){
		String sql="select * from stu_collect where StuID=? and FirmID is not null and RecruitID is null";
		List<Map<String,Object>> lmap=DBUtil.list(sql,id);
		List<Collect> lco=new ArrayList<Collect>();
		if(lmap!=null){
			for(int i=0;i<lmap.size();i++){
				Collect col=new Collect();
				col.setStuID((int)lmap.get(i).get("StuID"));
				col.setCollectID((int)lmap.get(i).get("CollectID"));
				col.setFirmID((int)lmap.get(i).get("FirmID"));
				col.setCollectTime((String)lmap.get(i).get("CollectTime"));
				lco.add(col);
			}
			return lco;
		}else{
			return null;
		}
		
	}
	
	//获取收藏公司列表
	public List<Firm> queryFirmCollectDetils(List<Integer> lid){
		//System.out.println(lid);
		String sql="select * from firm where Status='Yes'";
		List<Map<String,Object>> lmap=DBUtil.list(sql);
		List<Firm> lf=new ArrayList<Firm>();
		
		if(lmap!=null){
			for(int i=0;i<lmap.size();i++){
				for(int j=0;j<lid.size();j++){
					if((int)lmap.get(i).get("ID")==lid.get(j)){
						Firm fir=new Firm();
						fir.setAdress((String)lmap.get(i).get("Adress"));
						fir.setArea((String)lmap.get(i).get("Area"));
						fir.setCardStart((String)lmap.get(i).get("CardStart"));
						fir.setDes((String)lmap.get(i).get("Des"));
						fir.setEmail((String)lmap.get(i).get("Email"));
						fir.setFirmID((String)lmap.get(i).get("FirmID"));
						fir.setFirmName((String)lmap.get(i).get("FirmName"));
						fir.setID((int)lmap.get(i).get("ID"));
						fir.setLinkMan((String)lmap.get(i).get("LinkMan"));
						fir.setLogo((String)lmap.get(i).get("Logo"));
						fir.setPeopleNumber((String)lmap.get(i).get("PeopleNumber"));
						fir.setPicture((String)lmap.get(i).get("Picture"));
						fir.setStatus((String)lmap.get(i).get("Status"));
						fir.setTel((String)lmap.get(i).get("Tel"));
						fir.setType((String)lmap.get(i).get("Type"));
						lf.add(fir);
					}
				}
				
			}
			return lf;
		}else{
		return null;
		}
	}
	
	//获取收藏职位信息
	public List<Recruit> queryRecruitCollectDetils(List<Integer> lid){
		String sql="select * from recruit";
		List<Map<String,Object>> lmap=DBUtil.list(sql);
		List<Recruit> lr=new ArrayList<Recruit>();
		if(lmap!=null){
			for(int i=0;i<lmap.size();i++){
				for(int j=0;j<lid.size();j++){
					if((int)lmap.get(i).get("ID")==lid.get(j)){
						Recruit rec=new Recruit();
						rec.setDate((String)lmap.get(i).get("Date"));
						rec.setDepartment((String)lmap.get(i).get("Department"));
						rec.setEducationBgd((String)lmap.get(i).get("EducationBgd"));
						rec.setFirmName((String)lmap.get(i).get("FirmName"));
						rec.setID((int)lmap.get(i).get("ID"));
						rec.setJob((String)lmap.get(i).get("Job"));
						rec.setJob_Des((String)lmap.get(i).get("Job_Des"));
						rec.setJobNature((String)lmap.get(i).get("JobNature"));
						rec.setPay((String)lmap.get(i).get("Pay"));
						rec.setWelfare((String)lmap.get(i).get("Welfare"));
						lr.add(rec);
					}
				}
			}
			return lr;
		}else{
		return null;
		}
	}
	
	//删除收藏公司信息
	public int deleteCollectFirm(String id1,int id){
		String sql="delete from stu_collect where FirmID=? and StuID=?";
		int i=DBUtil.executeUpdate(sql,new Object[]{id1,id});
		return i;
	}
	
	//删除收藏职位信息
		public int deleteCollectRecruit(String id1,int id){
			String sql="delete from stu_collect where RecruitID=? and StuID=?";
			int i=DBUtil.executeUpdate(sql,new Object[]{id1,id});
			return i;
		}
		
		//更新求职意向
		public int updateIntention(String in,int id){
			String sql="update student set Intention=? where ID=?";
			int i=DBUtil.executeUpdate(sql,new Object[]{in,id});
			return i;
		}
		
		//更新学院信息校正表
		public int updateSchoolMessage(String province,String school,String college,int id){
			String sql="insert into updateschoolmessage (Province,University,College,StuID) values(?,?,?,?)";
			int i=DBUtil.executeUpdate(sql,new Object[]{province,school,college,id});
			return i;
		}
		
		//查询所有学校信息（已认证）
		public List<Firm> queryAllSchool(){
			String sql="select * from firm where Status='Yes'";
			List<Map<String,Object>> lmap=DBUtil.list(sql);
			//System.out.println(lmap);
			List<Firm> lf=new ArrayList<Firm>();
			if(lmap!=null){
				for(int i=0;i<lmap.size();i++){
							Firm fir=new Firm();
							fir.setAdress((String)lmap.get(i).get("Adress"));
							fir.setArea((String)lmap.get(i).get("Area"));
							fir.setCardStart((String)lmap.get(i).get("CardStart"));
							fir.setDes((String)lmap.get(i).get("Des"));
							fir.setEmail((String)lmap.get(i).get("Email"));
							fir.setFirmID((String)lmap.get(i).get("FirmID"));
							fir.setFirmName((String)lmap.get(i).get("FirmName"));
							fir.setID((int)lmap.get(i).get("ID"));
							fir.setLinkMan((String)lmap.get(i).get("LinkMan"));
							fir.setLogo((String)lmap.get(i).get("Logo"));
							fir.setPeopleNumber((String)lmap.get(i).get("PeopleNumber"));
							fir.setPicture((String)lmap.get(i).get("Picture"));
							fir.setStatus((String)lmap.get(i).get("Status"));
							fir.setTel((String)lmap.get(i).get("Tel"));
							fir.setType((String)lmap.get(i).get("Type"));
							lf.add(fir);	
				}
				return lf;
			}else{
			return null;
			}
		}
		
		//查询学校信息（已认证）
				public Firm queryFirm(String id){
					String sql="select * from firm where Status='Yes' and ID=?";
					List<Map<String,Object>> lmap=DBUtil.list(sql,id);
					//System.out.println(lmap);
					if(lmap.size()==1){
						Firm fir=new Firm();
						for(int i=0;i<lmap.size();i++){
									fir.setAdress((String)lmap.get(i).get("Adress"));
									fir.setArea((String)lmap.get(i).get("Area"));
									fir.setCardStart((String)lmap.get(i).get("CardStart"));
									fir.setDes((String)lmap.get(i).get("Des"));
									fir.setEmail((String)lmap.get(i).get("Email"));
									fir.setFirmID((String)lmap.get(i).get("FirmID"));
									fir.setFirmName((String)lmap.get(i).get("FirmName"));
									fir.setID((int)lmap.get(i).get("ID"));
									fir.setLinkMan((String)lmap.get(i).get("LinkMan"));
									fir.setLogo((String)lmap.get(i).get("Logo"));
									fir.setPeopleNumber((String)lmap.get(i).get("PeopleNumber"));
									fir.setPicture((String)lmap.get(i).get("Picture"));
									fir.setStatus((String)lmap.get(i).get("Status"));
									fir.setTel((String)lmap.get(i).get("Tel"));
									fir.setType((String)lmap.get(i).get("Type"));	
						}
						return fir;
					}else{
						return null;
					}
				}
				
		//查询是否已投简历
		public boolean checkSendResume(String firmname,int id){
			//System.out.println("11111111111111111111111");
			String sql="select * from resume_list where FirmName=? and Stu_ID=?";
			List<Map<String,Object>> lmap=DBUtil.list(sql,new Object[]{firmname,id});
			if (lmap.size()==0) {
				return true;
			}else{
				return false;
			}
		}
		
		//投递简历
		public int addResume(String firmname,Student stu){
			String sql="insert into resume_list(Stu_ID,FirmName,Resume,Major,RealName,EducationBgd,Intention,ResumeTime) values(?,?,?,?,?,?,?,?)";
			int i=DBUtil.executeUpdate(sql,new Object[]{stu.getID(),firmname,stu.getResume(),stu.getMajor(),stu.getRealName(),stu.getEducationBgd(),stu.getIntention()
					,stu.getResumeTime()});
			return i;
		}
		
		//查询所有投递的简历
		public List<Resume> queryallresumesend(int id){
			String sql="select * from resume_list where StuID=?";
			List<Map<String,Object>> lmap=DBUtil.list(sql,id);
			List<Resume> lre=new ArrayList<Resume>();
			if(lmap!=null){
				for(int i=0;i<lre.size();i++){
					Resume re=new Resume();
					re.setID((int) lmap.get(i).get("ID"));
					re.setEducationBgd((String) lmap.get(i).get("EducationBgd"));
					re.setFirmName((String) lmap.get(i).get("FirmName"));
					re.setIntention((String) lmap.get(i).get("Intention"));
					re.setMajor((String) lmap.get(i).get("Major"));
					re.setRealName((String) lmap.get(i).get("RealName"));
					re.setResume((String) lmap.get(i).get("Resume"));
					re.setResumeTime((String) lmap.get(i).get("ResumeTime"));
					lre.add(re);
				}
				return lre;
			}else{
				return null;
			}
			
		}
		
		//判断收藏表
		public boolean checkCollectFirm(String a,int id){
			String sql="select * from stu_collect where FirmID=? and StuID=?";
			List<Map<String,Object>> lmap=DBUtil.list(sql,new Object[]{a,id});
			if(lmap.size()>=1){
				return false;
			}else{
				return true;
			}
		}
		
		
		//添加收藏公司
		public int addCollectFirm(String a,int id,String now){
			String sql="insert into stu_collect(StuID,FirmID,CollectTime) values(?,?,?)";
			int i=DBUtil.executeUpdate(sql,new Object[]{id,a,now});
			return i;
		}
	
}
