package com.back.service;

import java.util.List;

import com.back.dao.firm_dao;
import com.back.model.Firm;
import com.back.model.Item;
import com.back.model.JobFair;
import com.back.model.Preach;
import com.back.model.Recruit;
import com.back.model.Resume;
import com.back.model.Student;

public class firm_service {
	firm_dao fd=new firm_dao();
    /**
     * 企业后台登录
     * @param FirmName
     * @param PassWord
     * @return
     * @throws Exception
     */
	public Firm login(String FirmName,String PassWord) throws Exception{
		Firm firm=fd.login(FirmName, PassWord);
		if(firm!=null){
			return firm;
		}else{
			throw new Exception("企业登录账号或密码错误！");
		}
	}
	/**
	 * 企业注册
	 * @param firm
	 * @throws Exception
	 */
	public void firm_register(Firm firm) throws Exception{
		try {
			fd.firm_register(firm);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("企业注册失败，原因是 ："+e.getMessage());
		}
	}
	/**
	 * 统计企业名称相同的数目
	 * @param FirmName
	 * @return
	 * @throws Exception
	 */
	public int firm_check(String FirmName) throws Exception{
		try {
			return fd.firm_check(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计企业名称失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 忘记密码身份验证
	 * @param Email
	 * @param FirmName
	 * @return
	 * @throws Exception
	 */
	public String checkForgetPassword(String Email,String FirmName) throws Exception{
		try {
			return fd.firm_checkForgetPassword(Email, FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("忘记密码身份验证失败，原因是:"+e.getMessage());
		}
	}
	/**
	 * 根据登录名
     * 得企业邮箱和手机号
	 * @param FirmName
	 * @return
	 * @throws Exception
	 */
	public Firm firm_information(String FirmName) throws Exception{
		try {
			return fd.firm_information(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取企业邮箱和手机号失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 修改企业基本信息
	 * @param firm
	 * @throws Exception
	 */
	public void firm_information_update(Firm firm) throws Exception{
		try {
			fd.firm_information_update(firm);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改企业基本信息失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 获取企业验证信息
	 * @param FirmName
	 * @return
	 * @throws Exception
	 */
	 public Firm firm_identification(String FirmName) throws Exception{
		 try {
			return fd.firm_identification(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取企业验证信息失败，原因是："+e.getMessage());
		}
	 }
	/**
	 * 修改企业验证信息
	 * @param firm
	 * @throws Exception
	 */
	public void firm_indentification_update(Firm firm) throws Exception{
		try {
			fd.firm_indentification_update(firm);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改企业验证信息失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 获取企业验证状态
	 * @param FirmName
	 * @return
	 * @throws Exception
	 */
	 public Firm firm_status(String FirmName) throws Exception{
		 try {
			return fd.firm_status(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取企业的验证状态失败，原因是："+e.getMessage());
		}
	 }
	 /**
	  * 判断旧密码是否正确
	  * @param FirmName
	  * @param pwd
	  * @return
	  * @throws Exception
	  */
	 public int firm_checkPWD(String FirmName,String pwd) throws Exception{
		 try {
			return fd.firm_checkPWD(FirmName, pwd);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("判断失败，原因是："+e.getMessage());
		}
	 }
	 /**
	  * 安全设置：修改密码
	  * @param FirmName
	  * @param PassWord
	  * @throws Exception
	  */
	 public void firm_updatePWD(String FirmName,String PassWord) throws Exception{
		 try {
			fd.firm_updatePWD(FirmName, PassWord);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改密码失败，原因是："+e.getMessage());
		}
	 }
	  /**
      * 发布职位
      * @param recruit
      * @throws Exception
      */

     public void recruit_add(Recruit recruit) throws Exception{
    	 try {
			fd.firm_recruit_add(recruit);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("发布职位失败，原因是："+e.getMessage());
		}
     }
     /**
      * 查看自己企业的职位列表
      * @param FirmName
      * @return
      * @throws Exception
      */
     public List<Recruit> firm_recruit_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_recruit_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("查看职位列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 企业职位详情信息
      * @param id
      * @return
      * @throws Exception
      */
     public Recruit firm_recurit_job_des(String id) throws Exception{
    	 try {
			return fd.firm_recurit_job_des(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取职位详情信息失败，原因是："+e.getMessage());
		}
     }
     /**
      * 职位修改信息获取
      * @param id
      * @return
      * @throws Exception
      */
     public Recruit firm_recruit_update1(String id) throws Exception{
    	 try {
			return fd.firm_recruit_update1(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取职位修改信息失败，原因是："+e.getMessage());
		}
     }
     /**
      * 修改职位信息
      * @param recruit
      * @throws Exception
      */
     public void firm_recruit_update2(Recruit recruit) throws Exception{
    	 try {
			 fd.firm_recruit_update2(recruit);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改职位信息失败，原因是："+e.getMessage());
		}
     }
     /**
      * 删除职位信息
      * @param id
      * @throws Exception
      */
     public void firm_recruit_delete(int id) throws Exception{
    	 try {
			fd.firm_recruit_delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除职位失败，原因是："+e.getMessage());
		}
     }
     /**
      * 人才搜索
      * @param EducationBgd
      * @param Job
      * @param date1
      * @param date2
      * @return
      * @throws Exception
      */
     public List<Student> firm_intention_select(String EducationBgd,String Job,String date1,String date2) throws Exception{
    	 try {
			return fd.firm_intention_select(EducationBgd, Job, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("搜索人才失败，原因是："+e.getMessage());
		}
     }
     /**
      * 简历收藏
      * @param id
      * @param FirmName
      * @throws Exception
      */
     public void firm_resuem_collect(int id,String FirmName) throws Exception{
    	 try {
			fd.firm_resuem_collect(id, FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("简历收藏失败，原因是："+e.getMessage());
		}
     }
     /**
      * 简历收藏列表
      * @return
      * @throws Exception
      */
     public List<Resume> firm_resume_collect_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_resume_collect_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历简历收藏列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 删除收藏的简历
      * @param id
      * @throws Exception
      */
     public void firm_resume_collect_delete(int id) throws Exception{
    	 try {
			fd.firm_resume_collect_delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除收藏的简历失败，原因是："+e.getMessage());
		}
     }
     /**
      * 查询简历收藏
      * @param EducationBgd
      * @param Job
      * @param date1
      * @param date2
      * @return
      * @throws Exception
      */
     public List<Resume> firm_resume_collect_select(String EducationBgd,String Job,String date1,String date2) throws Exception{
    	 try {
			return fd.firm_resume_collect_select(EducationBgd, Job, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("查询简历收藏失败，原因是:"+e.getMessage());
		}
     }
     /**
      * 获取收到的简历列表
      * @return
      * @throws Exception
      */
     public List<Resume> firm_resume_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_resume_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取收到的简历列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 删除收到的简历列表
      * @param id
      * @throws Exception
      */
     public void firm_resume_delete(int id) throws Exception{
    	 try {
			fd.firm_resume_delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除收到的简历列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 批量收藏操作
      * @param id
      * @throws Exception
      */
     public void firm_resume_CandD(int id) throws Exception{
    	 try {
			fd.firm_resume_CandD(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("批量收藏操作失败，原因是："+e.getMessage());
		}
     }
     /**
      * 获取招聘会列表
      * @return
      * @throws Exception
      */
     public List<JobFair> firm_jobfair_list() throws Exception{
    	 try {
			return fd.firm_jobfair_list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取招聘会列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 企业参加招聘会
      * @param id
      * @throws Exception
      */
     public void firm_jobfair_attend(String FirmName,int jobfair_id) throws Exception{
    	 try {
			fd.firm_jobfair_attend(FirmName,jobfair_id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("企业参加招聘会失败，原因是："+e.getMessage());
		}
     }
     /**
      * 参加招聘会同时
      * 添加数据给job_fair_firm
      * @param FirmName
      * @param jobfair_id
      * @throws Exception
      */
     public void firm_jobfair_attend_copy(String FirmName,int jobfair_id) throws Exception{
    	 try {
			fd.firm_jobfair_attend_copy(FirmName, jobfair_id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("操作失败原因是："+e.getMessage());
		}
     }
     /**
      * 已参加的招聘会列表
      * @return
      * @throws Exception
      */
     public List<JobFair> firm_jobfair_attend_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_jobfair_attend_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历已参加的招聘会列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 发布职位操作
      * @param FairID
      * @param FirmName
      * @param idAll
      * @param num
      * @throws Exception
      */
     public void firm_jobfair_recruit_add(String FairID,String FirmName,String idAll,int num) throws Exception{
    	 try {
			fd.firm_jobfair_recruit_add(FairID, FirmName, idAll, num);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("发布职位操作失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台遍历公司信息
      * @return
      * @throws Exception
      */
     public List<Firm> firm__F_information() throws Exception{
    	 try {
			return fd.firm__F_information();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台遍历企业信息失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台名企介绍查询
      * @param FirmName
      * @param Area
      * @param Type
      * @return
      * @throws Exception
      */
     public List<Firm> firm_F_information_select(String FirmName,String Area,String Type) throws Exception{
    	 try {
			return fd.firm_F_information_select(FirmName, Area, Type);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台名企介绍查询功能失败，原因是："+e.getMessage());
		}
     }
     /**
      * 查看企业详情
      * @param ID
      * @return
      * @throws Exception
      */
     public Firm firm_F_information_detail(int ID,String FirmName) throws Exception{
    	 try {
			return fd.firm_F_information_detail(ID,FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台显示企业详情失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台看企业还在招的职位
      * @param FirmName
      * @return
      * @throws Exception
      */
     public List<Recruit> firm_F_recruit_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_F_recruit_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台看企业还在招职位失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台首页遍历招聘会列表
      * @return
      * @throws Exception
      */
     public List<JobFair> firm_F_jobfair_list() throws Exception{
    	 try {
			return fd.firm_F_jobfair_list();
		} catch (Exception e)  {
			// TODO: handle finally clause
			throw new Exception("前台首页遍历招聘会失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台显示招聘会详情
      * @param ID
      * @return
      * @throws Exception
      */
     public JobFair firm_F_jobfair_detail(int ID) throws Exception{
    	 try {
			return fd.firm_F_jobfair_detail(ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台显示招聘会详情失败，原因是："+e.getMessage());
		}
     }
     /**
      **前台显示该招聘会参加的公司们
      * @param ID
      * @return
      * @throws Exception
      */
     public List<JobFair> firm_F_jobfair_attend_list(int ID) throws Exception{
    	 try {
			return fd.firm_F_jobfair_attend_list(ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("显示参与该招聘会的公司们数据失败，原因是："+e.getMessage());
			
		}
     }
     /**
      * 前台单独的招聘会列表页面
      * @return
      * @throws Exception
      */
     public List<JobFair> firm_F_jobfair_list2() throws Exception{
    	 try {
			return fd.firm_F_jobfair_list2();
		} catch (Exception e)  {
			// TODO: handle finally clause
			throw new Exception("前台首页遍历招聘会失败，原因是："+e.getMessage());
		}
     }
     /**
      * 遍历学生项目
      * @return
      * @throws Exception
      */
     public List<Item> firm_item_list() throws Exception{
    	 try {
			return fd.firm_item_list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历学生项目失败，原因是："+e.getMessage());
		}
     }
     /**
      * 扶持项目
      * @param ID
      * @throws Exception
      */
     public void firm_item_help(int ID,String FirmName) throws Exception{
    	 try {
			fd.firm_item_help(ID,FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("扶持项目失败，原因是："+e.getMessage());
		}
     }
     
     /**
      * 添加宣讲会
      * @param preach
      * @throws Exception
      */
     public void firm_preach_add(Preach preach) throws Exception{
    	 try {
			fd.firm_preach_add(preach);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加宣讲会失败，原因是："+e.getMessage());
		}
     }
     /**
      * 遍历宣讲会列表
      * @param FirmName
      * @return
      * @throws Exception
      */
     public List<Preach> firm_preach_list(String FirmName) throws Exception{
    	 try {
			return fd.firm_preach_list(FirmName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取宣讲会列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 删除宣讲会
      * @param ID
      * @throws Exception
      */
     public void firm_preach_delete(int ID) throws Exception{
    	 try {
			 fd.firm_preach_delete(ID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除宣讲会失败，原因是："+e.getMessage());
		}
     }
     /**
      * 前台遍历宣讲会
      * @return
      * @throws Exception
      */
     public List<Preach> firm_F_preach_list() throws Exception{
    	 try {
		     return fd.firm_F_preach_list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台遍历宣讲会失败，原因是："+e.getMessage());
		}
     }
}
