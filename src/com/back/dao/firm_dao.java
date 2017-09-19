package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Firm;
import com.back.model.Item;
import com.back.model.JobFair;
import com.back.model.Preach;
import com.back.model.Recruit;
import com.back.model.Resume;
import com.back.model.Student;
import com.back.util.DBUtil;

public class firm_dao {
	/**
	 * 企业后台登录
	 * @param FirmCode
	 * @param PassWord
	 * @return
	 */
	public Firm login(String FirmName,String PassWord){
		String sql="select * from firm where FirmName=? and PassWord=?";
		Map<String, Object> map=DBUtil.query(sql,new Object[]{FirmName,PassWord});
		if(map!=null&&map.size()!=0){
			Firm firm=new Firm();
			firm.setFirmName((String) map.get("FirmName"));
			firm.setPassWord((String) map.get("PassWord"));
			
			return firm;
		}else{
			return null;
		}
	}
	/**
	 * 企业注册
	 * @param firm
	 */
    public void firm_register(Firm firm){
    	String sql="insert into firm(FirmName,Tel,Email,PassWord)values(?,?,?,?)";
    	DBUtil.executeUpdate(sql, new Object[]{firm.getFirmName(),firm.getTel(),firm.getEmail(),firm.getPassWord()});
    }
    /**
     * 判断企业名称是否重复
     * @param FirmName
     * @return
     */
    public int firm_check(String FirmName){
    	String sql="select count(*) as num from firm where FirmName=?";
    	Map<String, Object> map=DBUtil.query(sql, FirmName);
    	int num=Integer.parseInt(map.get("num").toString());
    	return num;   	
    }
    
	/**
	 * 忘记密码身份验证
	 * @param Email
	 * @param FirmName
	 * @return
	 */
	public String firm_checkForgetPassword(String Email,String FirmName){
		String sql="select PassWord from firm where Email=? and FirmName=? ";
		List<Map<String,Object>> listfirm=DBUtil.list(sql,new Object[]{Email,FirmName});
		if(listfirm.size()==1){
			return (String) listfirm.get(0).get("PassWord");
		}else{
			return null;
		}
	}
    /**
     * 根据登录名
     * 得用户基本信息
     * @param FirmName
     * @return
     */
    public Firm firm_information(String FirmName){
    	String sql="select * from firm where FirmName=?";
    	Map<String, Object> map=DBUtil.query(sql, FirmName);
    	if(map!=null&&map.size()!=0){
    		Firm firm=new Firm();
    		
    		firm.setFirmName((String) map.get("FirmName"));
    		firm.setEmail((String) map.get("Email"));
    		firm.setTel((String) map.get("Tel"));
    		firm.setAdress((String) map.get("Adress"));
    		firm.setArea((String) map.get("Area"));
    		firm.setDes((String) map.get("Des"));
    		firm.setLinkMan((String) map.get("LinkMan"));
    		firm.setLogo((String) map.get("Logo"));
    		firm.setPeopleNumber((String) map.get("PeopleNumber"));
    		firm.setType((String) map.get("Type"));    		
    		return firm;
    	}else{
    		return null;
    	}
    }
    /**
     * 修改企业的基本信息
     * @param firm
     */
    public void firm_information_update(Firm firm){
    	String sql="update firm set Type=?,Area=?,Adress=?,LinkMan=?,Tel=?,Email=?,PeopleNumber=?,Des=?,Logo=? where FirmName=?";
    	DBUtil.executeUpdate(sql,new Object[]{firm.getType(),firm.getArea(),firm.getAdress(),firm.getLinkMan(),firm.getTel(),firm.getEmail(),firm.getPeopleNumber(),firm.getDes(),firm.getLogo(),firm.getFirmName()});   	
    }
    /**
     * 企业验证信息
     * @param FirmName
     * @return
     */
    public Firm firm_identification(String FirmName){
    	String sql="select * from firm where FirmName=?";
    	Map<String, Object> map=DBUtil.query(sql, FirmName);
    	if(map!=null&&map.size()!=0){
    		Firm firm=new Firm();
    		
    		firm.setStatus((String) map.get("Status"));
    		firm.setFirmName((String) map.get("FirmName"));
    		firm.setFirmID((String) map.get("FirmID"));
    		firm.setCardStart((String) map.get("CardStart"));
    		return firm;
    	}else{
    		return null;
    	}
    }
    /**
     * 修改企业验证信息
     * @param firm
     */
    public void firm_indentification_update(Firm firm){
    	String sql="update firm set FirmID=?,CardStart=?,Picture=? where FirmName=?";
    	DBUtil.executeUpdate(sql, new Object[]{firm.getFirmID(),firm.getCardStart(),firm.getPicture(),firm.getFirmName()});
    }
    /**
     * 获取企业验证的状态：Yes还是No还是ing
     * @param FirmName
     * @return
     */
    public Firm firm_status(String FirmName){
    	String sql="select * from firm where FirmName=?";
    	Map<String, Object> map=DBUtil.query(sql, FirmName);
    	if(map!=null&&map.size()!=0){
    		Firm firm=new Firm();
    		
    		firm.setFirmName((String) map.get("FirmName"));
    	    firm.setStatus((String) map.get("Status"));
    		return firm;
    	}else{
    		return null;
    	}
    }
    /**
     * 判断旧密码是否正确
     * @param FirmName
     * @param pwd
     * @return
     */
    public int firm_checkPWD(String FirmName,String pwd){
    	String sql="select count(*) as num from firm where FirmName=? and PassWord=?";
    	Map<String, Object> map=DBUtil.query(sql, new Object[]{FirmName,pwd});
    	int num=Integer.parseInt(map.get("num").toString());
    	return num;
    }
    /**
     * 安全设置：修改密码
     * @param FirmName
     * @param PassWord
     */
    public void firm_updatePWD(String FirmName,String PassWord){
    	String sql="update firm set PassWord=? where FirmName=?";
    	DBUtil.executeUpdate(sql,new Object[]{PassWord,FirmName});
    }
	/**
	 * 职位发布（添加）
	 * 和汇总职位数目
	 * @param recruit
	 */
     public void firm_recruit_add(Recruit recruit){
    	 String sql="insert into recruit (FirmName,Job,Department,Pay,Welfare,EducationBgd,JobNature,Job_Des,Date)values(?,?,?,?,?,?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{recruit.getFirmName(),recruit.getJob(),recruit.getDepartment(),recruit.getPay(),recruit.getWelfare(),recruit.getEducationBgd(),recruit.getJobNature(),recruit.getJob_Des(),recruit.getDate()});
         
    	 String sql2="select count(ID) as RecruitSum from recruit where FirmName=?";
    	 Map<String, Object> map=DBUtil.query(sql2,recruit.getFirmName());
    	 
    	 String sql3="update firm set RecruitSum=? where FirmName=?";
    	 DBUtil.executeUpdate(sql3, new Object[]{map.get("RecruitSum"),recruit.getFirmName()});
     }
     /**
      * 遍历自己企业的职位
      * @param FirmName
      * @return
      */
     public List<Recruit> firm_recruit_list(String FirmName){
    	 String sql="select * from recruit where FirmName=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql, FirmName);
    	 if(list!=null&&list.size()!=0){
    		 List<Recruit> listrecruit=new ArrayList<Recruit>();
    		 for(Map<String,Object> map:list){
    			 Recruit recruit=new Recruit();
    			 
    			 recruit.setDate((String) map.get("Date"));
    			 recruit.setDepartment((String) map.get("Department"));
    			 recruit.setEducationBgd((String) map.get("EducationBgd"));
    			 recruit.setFirmName((String) map.get("FirmName"));
    			 recruit.setID((int) map.get("ID"));
    			 recruit.setJob((String) map.get("Job"));
    			 recruit.setJob_Des((String) map.get("Job_Des"));
    			 recruit.setJobNature((String) map.get("JobNature"));
    			 recruit.setPay((String) map.get("Pay"));
    			 recruit.setWelfare((String) map.get("Welfare"));
    			 
    			 listrecruit.add(recruit);
    		 }
    		 return listrecruit;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 获得企业发布的职位
      * 详情信息
      * @param id
      * @return
      */
     public Recruit firm_recurit_job_des(String id){
    	 String sql="select * from recruit where id=?";
    	 Map<String, Object> map=DBUtil.query(sql, id);
    	 if(map!=null&&map.size()!=0){
    		 Recruit recruit=new Recruit();
    		 
    		 recruit.setJob((String) map.get("Job"));
    		 recruit.setJob_Des((String) map.get("Job_Des"));
    		 return recruit;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 职位修改信息获取
      * @param id
      * @return
      */
     public Recruit firm_recruit_update1(String id){
    	 String sql="select * from recruit where id=?";
    	 Map<String, Object> map=DBUtil.query(sql, id);
    	 if(map!=null&&map.size()!=0){
    		 Recruit recruit=new Recruit();
    		 
			 recruit.setDate((String) map.get("Date"));
			 recruit.setDepartment((String) map.get("Department"));
			 recruit.setEducationBgd((String) map.get("EducationBgd"));
			 recruit.setFirmName((String) map.get("FirmName"));
			 recruit.setID((int) map.get("ID"));
			 recruit.setJob((String) map.get("Job"));
			 recruit.setJob_Des((String) map.get("Job_Des"));
			 recruit.setJobNature((String) map.get("JobNature"));
			 recruit.setPay((String) map.get("Pay"));
			 recruit.setWelfare((String) map.get("Welfare"));
    		
    		 return recruit;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 职位详情修改
      * @param recruit
      */
     public void firm_recruit_update2(Recruit recruit){
    	 String sql="update recruit set Job=?,Department=?,Pay=?,Welfare=?,EducationBgd=?,JobNature=?,Job_Des=? where ID=?";
    	 DBUtil.executeUpdate(sql,new Object[]{recruit.getJob(),recruit.getDepartment(),recruit.getPay(),recruit.getWelfare(),recruit.getEducationBgd(),recruit.getJobNature(),recruit.getJob_Des(),recruit.getID()});
     }
     /**
      * 删除职位
      * @param id
      */
     public void firm_recruit_delete(int id){
    	 String sql="delete from recruit where id=?";
    	 DBUtil.executeUpdate(sql, id);
     }
     /**
      * 人才搜索
      * @param EducationBgd
      * @param Job
      * @param date1
      * @param date2
      * @return
      */
     public List<Student> firm_intention_select(String EducationBgd,String Job,String date1,String date2){
    	 String sql="select * from student where resume is not null and status ='1'";
    	 if(date1!=null&&(!date1.trim().equals(""))){
    		 sql=sql+" and ResumeTime between '"+date1+"' and '"+date2+"'";
    	 }
     	if(EducationBgd!=null&&(!EducationBgd.trim().equals(""))){
    		sql=sql+" and EducationBgd like '%"+EducationBgd+"%'";
    	}
     	if(Job!=null&&(!Job.trim().equals(""))){
    		sql=sql+" and Intention like '%"+Job+"%'";
    	}
     	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	if(list!=null&&list.size()!=0){
     		List<Student> liststudent=new ArrayList<Student>();
     		for(Map<String,Object> map:list){
     			Student student=new Student();
     			
     			student.setID((int) map.get("ID"));
     			student.setMajor((String) map.get("Major"));
     			student.setEducationBgd((String) map.get("EducationBgd"));
     			student.setIntention((String) map.get("Intention"));
     			student.setRealName((String) map.get("RealName"));
     			student.setResume((String) map.get("Resume"));
     			student.setResumeTime((String) map.get("ResumeTime"));
     			liststudent.add(student);
     		}
     		return liststudent;
     	}else{
     		return null;   		
     	}	
     }
     /**
      * 简历收藏
      * @param id
      * @param FirmName
      */
     public void firm_resuem_collect(int id,String FirmName){
    	 String sql="select * from student where id=?";
    	 Map<String, Object> map=DBUtil.query(sql,id);
    	 if(map!=null&&map.size()!=0){
    		 Student student=new Student();
    		 
    		 student.setID((int) map.get("ID"));
    		 student.setMajor((String) map.get("Major"));
    		 student.setResume((String) map.get("Resume"));
    		 student.setResumeTime((String) map.get("ResumeTime"));
    		 student.setRealName((String) map.get("RealName"));
    		 student.setEducationBgd((String) map.get("EducationBgd"));
    		 student.setIntention((String) map.get("Intention"));
    		 
    		 String sql2="insert into resume_collect (Stu_ID,FirmName,Resume,Major,RealName,EducationBgd,Intention,ResumeTime)values(?,?,?,?,?,?,?,?)";
        	 DBUtil.executeUpdate(sql2,new Object[]{id,FirmName,student.getResume(),student.getMajor(),student.getRealName(),student.getEducationBgd(),student.getIntention(),student.getResumeTime()});
    	 }   	
    	  	 
     }     
     /**
      * 简历收藏列表
      * @return
      */
     public List<Resume> firm_resume_collect_list(String FirmName){
    	 String sql="select * from resume_collect where firmname=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql,FirmName);
    	 if(list!=null&&list.size()!=0){
    		 List<Resume> listresume=new ArrayList<Resume>();
    		 for(Map<String,Object> map:list){
    			 Resume resume=new Resume();
    			 
    			 resume.setID((int) map.get("ID"));
    			 resume.setEducationBgd((String) map.get("EducationBgd"));
    			 resume.setFirmName((String) map.get("FirmName"));
    			 resume.setIntention((String) map.get("Intention"));
    			 resume.setMajor((String) map.get("Major"));
    			 resume.setRealName((String) map.get("RealName"));
    			 resume.setResume((String) map.get("Resume"));
    			 resume.setResumeTime((String) map.get("ResumeTime"));
    			 resume.setStu_ID((int) map.get("Stu_ID"));
    			 listresume.add(resume);
    		 }
    		 return listresume;
    	 }else{
    		 return null;
    	 }   	 
     }
     /**
      * 删除简历收藏
      * @param id
      */
     public void firm_resume_collect_delete(int id){
    	 String sql="delete from resume_collect where id=?";
    	 DBUtil.executeUpdate(sql,id);		 
     }
     /**
      * 简历收藏 查询
      * @param EducationBgd
      * @param Job
      * @param date1
      * @param date2
      * @return
      */
     public List<Resume> firm_resume_collect_select(String EducationBgd,String Job,String date1,String date2){
    	 String sql="select * from resume_collect where 1=1";
    	 if(date1!=null&&(!date1.trim().equals(""))){
    		 sql=sql+" and ResumeTime between '"+date1+"' and '"+date2+"'";
    	 }
     	if(EducationBgd!=null&&(!EducationBgd.trim().equals(""))){
    		sql=sql+" and EducationBgd like '%"+EducationBgd+"%'";
    	}
     	if(Job!=null&&(!Job.trim().equals(""))){
    		sql=sql+" and Intention like '%"+Job+"%'";
    	}
     	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	if(list!=null&&list.size()!=0){
     		List<Resume> listresume=new ArrayList<Resume>();
     		for(Map<String,Object> map:list){
     			Resume resume=new Resume();
     			
     			resume.setID((int) map.get("ID"));
     			resume.setMajor((String) map.get("Major"));
     			resume.setEducationBgd((String) map.get("EducationBgd"));
     			resume.setIntention((String) map.get("Intention"));
     			resume.setRealName((String) map.get("RealName"));
     			resume.setResume((String) map.get("Resume"));
     			resume.setResumeTime((String) map.get("ResumeTime"));
     			listresume.add(resume);
     		}
     		return listresume;
     	}else{
     		return null;   		
     	}	
     }
     /**
      * 收到的简历列表
      * @return
      */
     public List<Resume> firm_resume_list(String FirmName){
    	 String sql="select * from resume_list where firmname=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql,FirmName);
      	 if(list!=null&&list.size()!=0){
      		List<Resume> listresume=new ArrayList<Resume>();
      		for(Map<String,Object> map:list){
      			Resume resume=new Resume();
      			
      			resume.setID((int) map.get("ID"));
      			resume.setMajor((String) map.get("Major"));
      			resume.setEducationBgd((String) map.get("EducationBgd"));
      			resume.setIntention((String) map.get("Intention"));
      			resume.setRealName((String) map.get("RealName"));
      			resume.setResume((String) map.get("Resume"));
      			resume.setResumeTime((String) map.get("ResumeTime"));
      			listresume.add(resume);
      		}
      		return listresume;
      	}else{
      		return null;   		
      	}	
     }
     /**
      * 删除收到的简历列表
      * @param id
      */
     public void firm_resume_delete(int id){
    	 String sql="delete from resume_list where id=?";
    	 DBUtil.executeUpdate(sql,id);
     }
     /**
      * 批量收藏操作
      * @param id
      */
     public void firm_resume_CandD(int id){
    	 String sql="select * from resume_list where id=?";
    	 Map<String, Object> map=DBUtil.query(sql, id);
    	 if(map!=null&&map.size()!=0){
    		 Resume resume=new Resume();
    		 
    		 resume.setEducationBgd((String) map.get("EducationBgd"));
    		 resume.setFirmName((String) map.get("FirmName"));
    		 resume.setID((int) map.get("ID"));
    		 resume.setIntention((String) map.get("Intention"));
    		 resume.setMajor((String) map.get("Major"));
    		 resume.setRealName((String) map.get("RealName"));
    		 resume.setResume((String) map.get("Resume"));
    		 resume.setResumeTime((String) map.get("ResumeTime"));
    		 resume.setStu_ID((int) map.get("Stu_ID"));
    		 
    		 String sql2="insert into resume_collect (Stu_ID,FirmName,Resume,Major,RealName,EducationBgd,Intention,ResumeTime)values(?,?,?,?,?,?,?,?)";
    	     DBUtil.executeUpdate(sql2, new Object[]{resume.getStu_ID(),resume.getFirmName(),resume.getResume(),resume.getMajor(),resume.getRealName(),resume.getEducationBgd(),resume.getIntention(),resume.getResumeTime()});  	     
    	 }
     }
     /**
      * 遍历招聘会列表
      * @return
      */
     public List<JobFair> firm_jobfair_list(){
    	 String sql="select * from job_fair";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<JobFair> listjobfair=new ArrayList<JobFair>();
    		 for(Map<String, Object> map:list){
    			 JobFair jobfair=new JobFair();
    			 
    			 jobfair.setAddress((String) map.get("Address"));
    			 jobfair.setDate((String) map.get("Date"));
    			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    			 jobfair.setID((int) map.get("ID"));
    			 jobfair.setPostNumber((int) map.get("PostNumber"));
    			 jobfair.setTitle((String) map.get("Title"));
    			 
    			 listjobfair.add(jobfair);
    		 }
    		return  listjobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 企业参加招聘会
      * @param id
      */
     public void firm_jobfair_attend(String FirmName,int jobfair_id){
    	 String sqll="select * from firm where firmname=?"; //根据企业名的到 firm表中企业ID
    	 Map<String, Object> map= DBUtil.query(sqll, FirmName);
    	 if(map!=null&&map.size()!=0){
    		 Firm firm=new Firm();
    		 firm.setID((int) map.get("ID"));
    		 
    		 String sql="select * from job_fair where id=?"; //得到job_fair表中企业的数据库中已有的FirmIDs
        	 Map<String, Object> mapp=DBUtil.query(sql, jobfair_id);
        	 if(mapp!=null&&mapp.size()!=0){
        		 JobFair jobfair=new JobFair();
        		 jobfair.setFirmIDs((String) mapp.get("FirmIDs"));
        		 
        		 String sql2="update  job_fair set FirmIDs=?, FirmNumber=FirmNumber+1 where id=?";//更改FirmIDs字段。
            	 DBUtil.executeUpdate(sql2,new Object[]{jobfair.getFirmIDs()+firm.getID()+",",jobfair_id});
        	 }
    	 }
   	 
     }
     /**
      * 参加招聘会同时
      * 添加数据给job_fair_firm
      * @param FirmName
      * @param jobfair_id
      */
     public void firm_jobfair_attend_copy(String FirmName,int jobfair_id){
    	 String sql="select * from job_fair where id=?";
    	 Map<String, Object> map=DBUtil.query(sql, jobfair_id);
    	 if(map!=null&&map.size()!=0){
    		 JobFair jobfair=new JobFair();
    		 
    		 jobfair.setAddress((String) map.get("Address"));
    		 jobfair.setDate((String) map.get("Date"));
    		 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    		 jobfair.setID((int) map.get("ID"));
    		 jobfair.setPostNumber((int) map.get("PostNumber"));
    		 jobfair.setTitle((String) map.get("Title"));
    		 
    		 String sql2="insert into job_fair_firm (FairID,FirmName,Title,Address,FirmNumber,PostNumber,Date)values(?,?,?,?,?,?,?)";
    		 DBUtil.executeUpdate(sql2, new Object[]{jobfair.getID(),FirmName,jobfair.getTitle(),jobfair.getAddress(),jobfair.getFirmNumber(),jobfair.getPostNumber(),jobfair.getDate()});
    	 }
     }
     /**
      * 遍历已参加的招聘会列表
      * @return
      */
     public List<JobFair> firm_jobfair_attend_list(String FirmName){
    	 String sql="select * from job_fair_firm where firmname=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql,FirmName);
    	 if(list!=null&&list.size()!=0){
    		 List<JobFair> listjobfair=new ArrayList<JobFair>();
    		 for(Map<String, Object> map:list){
    			 JobFair jobfair=new JobFair();
    			 
    			 jobfair.setFairID((int) map.get("FairID"));
    			 jobfair.setAddress((String) map.get("Address"));
    			 jobfair.setDate((String) map.get("Date"));    			
    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    			 jobfair.setID((int) map.get("ID"));
    			 jobfair.setPostNumber((int) map.get("PostNumber"));
    			 jobfair.setTitle((String) map.get("Title"));
    			 jobfair.setSelfPostNumber((int) map.get("SelfPostNumber"));
    			 
    			 listjobfair.add(jobfair);
    		 }
    		return  listjobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 发布职位操作
      * @param FairID
      * @param FirmName
      * @param idAll
      * @param num
      */
     public void firm_jobfair_recruit_add(String FairID,String FirmName,String idAll,int num){
    	 String sql="select * from job_fair_firm where FairID=? and FirmName=?";
    	 Map<String, Object> map=DBUtil.query(sql, new Object[]{FairID,FirmName});
    	 if(map!=null&&map.size()!=0){
    		 JobFair jobfair=new JobFair();
    		 
    		 jobfair.setID((int) map.get("ID"));
    		 jobfair.setPostNumber((int) map.get("PostNumber"));
    		 jobfair.setSelfPostNumber((int) map.get("SelfPostNumber"));
    		 jobfair.setRecruitIDs((String) map.get("RecruitIDs"));
    		 
    		 String sql2="update job_fair_firm set RecruitIDs=?,PostNumber=?,SelfPostNumber=? where ID=?";
    		 DBUtil.executeUpdate(sql2, new Object[]{jobfair.getRecruitIDs()+idAll,jobfair.getPostNumber()+num,jobfair.getSelfPostNumber()+num,jobfair.getID()});
    		 
    		 String sql3="update job_fair set PostNumber=? where ID=?";
    		 DBUtil.executeUpdate(sql3, new Object[]{jobfair.getPostNumber()+num,FairID});
    	 }   	 
     }
     /**
      * 前台遍历公司信息
      * @return
      */
     public List<Firm> firm__F_information(){
    	 String sql="select * from firm limit 0,12";
    	 List<Map<String, Object>> list= DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<Firm> listfirm=new ArrayList<Firm>();
    		 for(Map<String,Object> map:list){
    			 Firm firm=new Firm();
    			 
    			 firm.setID((int) map.get("ID"));
    			 firm.setFirmName((String) map.get("FirmName"));
    			 firm.setRecruitSum((String) map.get("RecruitSum"));
    			 firm.setLogo((String) map.get("Logo"));
    			 
    			 listfirm.add(firm);
    		 }
    		 return listfirm;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 前台名企介绍的查询
      * @param FirmName
      * @param Area
      * @param Type
      * @return
      */
     public List<Firm> firm_F_information_select(String FirmName,String Area,String Type){
    	 String sql="select * from firm where 1=1";
    
     	if(FirmName!=null&&(!FirmName.trim().equals(""))){
    		sql=sql+" and FirmName like '%"+FirmName+"%'";
    	}
     	if(Area!=null&&(!Area.trim().equals(""))){
    		sql=sql+" and Area like '%"+Area+"%'";
    	}
     	if(Type!=null&&(!Type.trim().equals(""))){
    		sql=sql+" and Type like '%"+Type+"%'";
    	}     	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	if(list!=null&&list.size()!=0){
     		List<Firm> listfirm=new ArrayList<Firm>();
     		for(Map<String,Object> map:list){
   			 Firm firm=new Firm();
			 
   			 firm.setID((int) map.get("ID"));
   			 firm.setFirmName((String) map.get("FirmName"));
   			 firm.setRecruitSum((String) map.get("RecruitSum"));
   			 firm.setLogo((String) map.get("Logo"));
   			 
   			 listfirm.add(firm);   			
     		}
     		return listfirm;
     	}else{
     		return null;   		
     	}	
     }
     /**
      * 查看企业详情
      * @param ID
      * @return
      */
     public Firm firm_F_information_detail(int ID,String FirmName){
    	 System.out.println("至此");
    	 String sql="select * from firm where ID=? or FirmName=?";
    	 Map<String, Object> map= DBUtil.query(sql,new Object[]{ID,FirmName});
    	 if(map!=null&&map.size()!=0){
    		 Firm firm=new Firm();
    		 firm.setID((int)map.get("ID"));
    		 firm.setLogo((String) map.get("Logo"));
    		 firm.setFirmName((String) map.get("FirmName"));
    		 firm.setArea((String) map.get("Area"));
    		 firm.setAdress((String) map.get("Adress"));
    		 firm.setType((String) map.get("Type"));
    		 firm.setPeopleNumber((String) map.get("PeopleNumber"));
    		 firm.setDes((String) map.get("Des"));
    		 firm.setLinkMan((String) map.get("LinkMan"));
    		 firm.setEmail((String) map.get("Email"));
    		 firm.setTel((String) map.get("Tel"));
    		 
    		 return firm;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 前台看企业还在招的职位
      * @param FirmName
      * @return
      */
     public List<Recruit> firm_F_recruit_list(String FirmName){
    	 String sql="select * from recruit where FirmName=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql, FirmName);
    	 if(list!=null&&list.size()!=0){
    		 List<Recruit> listrecruit=new ArrayList<Recruit>();
    		 for(Map<String,Object> map:list){
    			 Recruit recruit=new Recruit();
    			 
    			 recruit.setDate((String) map.get("Date"));
    			 recruit.setDepartment((String) map.get("Department"));
    			 recruit.setEducationBgd((String) map.get("EducationBgd"));
    			 recruit.setFirmName((String) map.get("FirmName"));
    			 recruit.setID((int) map.get("ID"));
    			 recruit.setJob((String) map.get("Job"));
    			 recruit.setJob_Des((String) map.get("Job_Des"));
    			 recruit.setJobNature((String) map.get("JobNature"));
    			 recruit.setPay((String) map.get("Pay"));
    			 recruit.setWelfare((String) map.get("Welfare"));
    			 
    			 listrecruit.add(recruit);
    		 }
    		 return listrecruit;
    	 }else{
    		 return null;
    	 }
     }
     
     /**
      * 前台首页遍历招聘会列表
      * @return
      */
     public List<JobFair> firm_F_jobfair_list(){
    	 String sql="select * from job_fair limit 0,4";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<JobFair> listjobfair=new ArrayList<JobFair>();
    		 for(Map<String, Object> map:list){
    			 JobFair jobfair=new JobFair();
    			 
    			 jobfair.setAddress((String) map.get("Address"));
    			 jobfair.setDate((String) map.get("Date"));
    			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    			 jobfair.setID((int) map.get("ID"));
    			 jobfair.setPostNumber((int) map.get("PostNumber"));
    			 jobfair.setTitle((String) map.get("Title"));
    			 jobfair.setContent((String) map.get("Content"));
    			 
    			 listjobfair.add(jobfair);
    		 }
    		return  listjobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 前台显示招聘会详情
      * @param ID
      * @return
      */
     public JobFair firm_F_jobfair_detail(int ID){
    	 String sql="select * from job_fair where id=?";
    	 Map<String, Object>  map=DBUtil.query(sql, ID);
    	 if(map!=null&&map.size()!=0){
    		 JobFair jobfair=new JobFair();
    		 
			 jobfair.setAddress((String) map.get("Address"));
			 jobfair.setDate((String) map.get("Date"));
			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
			 jobfair.setID((int) map.get("ID"));
			 jobfair.setPostNumber((int) map.get("PostNumber"));
			 jobfair.setTitle((String) map.get("Title"));
			 jobfair.setContent((String) map.get("Content"));
			 
			 return jobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 前台显示该招聘会参加的公司们
      * @param ID
      * @return
      */
     public List<JobFair> firm_F_jobfair_attend_list(int ID){
    	 String sql="select * from job_fair_firm where FairID=?";
    	 List<Map<String, Object>> list= DBUtil.list(sql, ID);
    	 if(list!=null&&list.size()!=0){
    		 List<JobFair> listjobfair=new ArrayList<JobFair>();
    		 for(Map<String,Object> map:list){
    			 JobFair jobfair=new JobFair();
    			 
    			 jobfair.setFirmName((String) map.get("FirmName"));
    			 jobfair.setFairID((int) map.get("FairID"));
    			 jobfair.setAddress((String) map.get("Address"));
    			 jobfair.setDate((String) map.get("Date"));    			
    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    			 jobfair.setID((int) map.get("ID"));
    			 jobfair.setPostNumber((int) map.get("PostNumber"));
    			 jobfair.setTitle((String) map.get("Title"));
    			 jobfair.setSelfPostNumber((int) map.get("SelfPostNumber"));
    			 
    			 listjobfair.add(jobfair);
    		 }
    		 return listjobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 前台单独的招聘会列表页面
      * @return
      */
     public List<JobFair> firm_F_jobfair_list2(){
    	 String sql="select * from job_fair ";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<JobFair> listjobfair=new ArrayList<JobFair>();
    		 for(Map<String, Object> map:list){
    			 JobFair jobfair=new JobFair();
    			 
    			 jobfair.setAddress((String) map.get("Address"));
    			 jobfair.setDate((String) map.get("Date"));
    			 jobfair.setFirmIDs((String) map.get("FirmIDs"));
    			 jobfair.setFirmNumber((int) map.get("FirmNumber"));
    			 jobfair.setID((int) map.get("ID"));
    			 jobfair.setPostNumber((int) map.get("PostNumber"));
    			 jobfair.setTitle((String) map.get("Title"));
    			 jobfair.setContent((String) map.get("Content"));
    			 
    			 listjobfair.add(jobfair);
    		 }
    		return  listjobfair;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 遍历学生项目
      * @return
      */
     public List<Item> firm_item_list(){
    	 String sql="select * from stu_start where CheckStatus='2' and Status='1'";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<Item> listitem=new ArrayList<Item>();
    		 for(Map<String,Object> map:list){
    			 Item item=new Item();
    			 
    			 item.setID((int) map.get("ID"));
    			 item.setStuID((int) map.get("StuID"));
    			 item.setFirmID((int) map.get("FirmID"));
    			 item.setFirmID((int) map.get("FirmID"));
    			 item.setFirmName((String) map.get("FirmName"));
    			 item.setStuName((String) map.get("StuName"));
    			 item.setItemName((String) map.get("ItemName"));
    			 item.setSchool((String) map.get("School"));
    			 item.setIntention((String) map.get("Intention"));
    			 item.setBusinessPlan((String) map.get("BusinessPlan"));
    			 item.setDescripe((String) map.get("Descripe"));
    			 
    			 listitem.add(item);
    		 }
    		 return listitem;
    		 
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 扶持项目
      * @param ID
      */
     public void firm_item_help(int ID,String FirmName){
    	 String sql="select * from firm where FirmName=?";
    	 Map<String, Object> map=DBUtil.query(sql, FirmName);
    	 if(map!=null&&map.size()!=0){
    		 Firm firm=new Firm();
    		 firm.setID((int) map.get("ID"));
    		 
    		 String sql2="update stu_start set FirmID=?,FirmName=? where id=?";
        	 DBUtil.executeUpdate(sql2, new Object[]{firm.getID(),FirmName,ID});
    	 }    	    	 
     }
     /**
      * 添加宣讲会
      * @param preach
      */
     public void firm_preach_add(Preach preach){
    	 String sql="insert into preach(Title,Address,Content,Date,FirmName)values(?,?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{preach.getTitle(),preach.getAddress(),preach.getContent(),preach.getDate(),preach.getFirmName()});
     }
     /**
      * 遍历宣讲会列表
      * @param FirmName
      * @return
      */
     public List<Preach> firm_preach_list(String FirmName){
    	 String sql="select * from preach where FirmName=?";
    	 List<Map<String, Object>> list=DBUtil.list(sql, FirmName);
    	 if(list!=null&&list.size()!=0){
    		 List<Preach> listpreach=new ArrayList<Preach>();
    		 for(Map<String,Object> map:list){
    			 Preach preach=new Preach();
    			 
    			 preach.setAddress((String) map.get("Address"));
    			 preach.setContent((String) map.get("Content"));
    			 preach.setDate((String) map.get("Date"));
    			 preach.setFirmName((String) map.get("FirmName"));
    			 preach.setID((int) map.get("ID"));
    			 preach.setTitle((String) map.get("Title"));
    			 
    			 listpreach.add(preach);
    		 }
    		 return listpreach;
    	 }else{
    		 return null;
    	 }   	 
     }
     /**
      * 删除宣讲会
      * @param ID
      */
     public void firm_preach_delete(int ID){
    	 String sql="delete from preach where id=?";
    	 DBUtil.executeUpdate(sql, ID);
     }
     /**
      * 前台遍历宣讲会
      * @return
      */
     public List<Preach> firm_F_preach_list(){
    	 String sql="select * from preach";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<Preach> listpreach=new ArrayList<Preach>();
    		 for(Map<String,Object> map:list){
    			 Preach preach=new Preach();
    			 
    			 preach.setAddress((String) map.get("Address"));
    			 preach.setContent((String) map.get("Content"));
    			 preach.setDate((String) map.get("Date"));
    			 preach.setFirmName((String) map.get("FirmName"));
    			 preach.setID((int) map.get("ID"));
    			 preach.setTitle((String) map.get("Title"));
    			 
    			 listpreach.add(preach);
    		 }
    		 return listpreach;
    	 }else{
    		 return null;
    	 }   	 
     }
}
