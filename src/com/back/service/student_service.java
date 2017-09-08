package com.back.service;

import java.util.List;
import java.util.Map;

import com.back.dao.student_dao;
import com.back.model.StuCollect;
import com.back.model.Firm;
import com.back.model.Item;
import com.back.model.Recruit;
import com.back.model.Resume;
import com.back.model.Student;
import com.back.model.Student_Province;

public class student_service {
	student_dao sda=new student_dao();
	Student stu=new Student();

	public Map<String,Object> loginCheck(String user,String password) throws Exception{
		try{
			return sda.loginCheck(user, password);
		}catch(Exception e){
			throw new Exception("查询学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public Student queryOneStudent(String stuid) throws Exception{
		try{
			return sda.queryOneStudent(stuid);
		}catch(Exception e){
			throw new Exception("查询学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public boolean checkStudentRegister(String name,String value) throws Exception{
		try{
			return sda.checkStudentRegister(name,value);
		}catch(Exception e){
			throw new Exception("验证学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public int addRegisterStudent(Student stu) throws Exception{
		try{
			int i= sda.addRegisterStudent(stu);
			if(i>0){
				return i;
			}else{
				throw new Exception("插入信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("添加学生信息失败，原因是："+e.getMessage());
		}
	}
	
	
	public int studentRegisterUpdate(String Email) throws Exception{
		try{
			int i= sda.studentRegisterUpdate(Email);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生账号信息失败，原因是："+e.getMessage());
		}
	}
	
	
	public boolean checkForgetPasswordEmail(String Email) throws Exception{
		try{
			return sda.checkForgetPasswordEmail(Email);
		}catch(Exception e){
			throw new Exception("忘记密码验证邮箱失败，原因是："+e.getMessage());
		}
	}
	
	
	public String checkForgetPassword(String Email,String StudentName,String Tel) throws Exception{
		try{
			return sda.checkForgetPassword(Email,StudentName,Tel);
		}catch(Exception e){
			throw new Exception("忘记密码身份验证失败，原因是："+e.getMessage());
		}
	}

	public int updateStudentLoginMessage(String now,int num,String id) throws Exception{
		try{
			int i= sda.updateStudentLoginMessage(now,num,id);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生登录信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生登录信息失败，原因是："+e.getMessage());
		}
	}
	
	public int updateStudentPassword(String stuid,String password) throws Exception{
		try{
			int i= sda.updateStudentPassword(stuid,password);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生密码条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生密码失败，原因是："+e.getMessage());
		}
	}
	
	public List<Student_Province> queryProvinceAll() throws Exception{
		try{
			return sda.queryProvinceAll();
		}catch(Exception e){
			throw new Exception("查询省份信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Map<String,Object>> queryUniversity(String province) throws Exception{
		try{
			return sda.queryUniversity(province);
		}catch(Exception e){
			throw new Exception("查询学校信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Map<String,Object>> queryAcademy(String school) throws Exception{
		try{
			return sda.queryAcademy(school);
		}catch(Exception e){
			throw new Exception("查询学院信息失败，原因是："+e.getMessage());
		}
	}
	
	public int updateStudentSchool(String province,String school,String academy,String major,int stuid) throws Exception{
		try{
			int i= sda.updateStudentSchool(province,school,academy,major,stuid);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生学校信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生学校信息失败，原因是："+e.getMessage());
		}
	}
	
	public boolean checkStudentUpdateSelfMessage(String name,String value,String value2) throws Exception{
		try{
			return sda.checkStudentUpdateSelfMessage(name,value,value2);
		}catch(Exception e){
			throw new Exception("验证学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public int updateStudentSelfMessage(Student stu) throws Exception{
		try{
			int i= sda.updateStudentSelfMessage(stu);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生个人信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生个人信息失败，原因是："+e.getMessage());
		}
	}
	
	
	
	public int uploadResume(String url,String time,String id) throws Exception{
		try{
			int i= sda.uploadResume(url,time,id);
			if(i>0){
				return i;
			}else{
				throw new Exception("上传简历条数为0");
			}
		}catch(Exception e){
			throw new Exception("上传简历失败，原因是："+e.getMessage());
		}
	}
	
	public int updatecreaCheck(String ID_Card,String CreaPic,String IdPic,String id) throws Exception{
		try{
			int i= sda.updatecreaCheck( ID_Card, CreaPic, IdPic, id);
			if(i>0){
				return i;
			}else{
				throw new Exception("创业信息验证条数为0");
			}
		}catch(Exception e){
			throw new Exception("创业信息验证失败，原因是："+e.getMessage());
		}
	}
	
	public int updateSelfMessageCheck(String RealName,String ID_Card,String IdPic,String Picture,String id) throws Exception{
		try{
			int i= sda.updateSelfMessageCheck( RealName, ID_Card, IdPic, Picture, id);
			if(i>0){
				return i;
			}else{
				throw new Exception("真实信息验证条数为0");
			}
		}catch(Exception e){
			throw new Exception("真实信息验证失败，原因是："+e.getMessage());
		}
	}
	
	public List<StuCollect> queryRecruitCollect(String id) throws Exception{
		try{
			return sda.queryRecruitCollect(id);
		}catch(Exception e){
			throw new Exception("查询职位收藏信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<StuCollect> queryFirmCollect(String id) throws Exception{
		try{
			return sda.queryFirmCollect(id);
		}catch(Exception e){
			throw new Exception("查询公司收藏信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Firm> queryFirmCollectDetils(List<Integer> lid) throws Exception{
		try{
			return sda.queryFirmCollectDetils(lid);
		}catch(Exception e){
			throw new Exception("查询公司收藏信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Recruit> queryRecruitCollectDetils(List<Integer> lid) throws Exception{
		try{
			return sda.queryRecruitCollectDetils(lid);
		}catch(Exception e){
			throw new Exception("查询职位收藏信息失败，原因是："+e.getMessage());
		}
	}
	
	//删除收藏公司信息
		public int deleteCollectFirm(String lid,int id) throws Exception{
			try{
				int i= sda.deleteCollectFirm(lid,id);
				if(i>0){
					return i;
				}else{
					throw new Exception("删除条数为0");
				}
			}catch(Exception e){
				throw new Exception("删除收藏失败，原因是："+e.getMessage());
			}
		}
		
		//删除收藏职位信息
				public int deleteCollectRecruit(String lid,int id) throws Exception{
					try{
						int i= sda.deleteCollectRecruit(lid, id);
						if(i>0){
							return i;
						}else{
							throw new Exception("删除条数为0");
						}
					}catch(Exception e){
						throw new Exception("删除收藏失败，原因是："+e.getMessage());
					}
				}
				
			//更新求职意向
			public int updateIntention(String in,int id) throws Exception{
				try{
					int i= sda.updateIntention(in, id);
					if(i>0){
						return i;
					}else{
						throw new Exception("更新条数为0");
					}
				}catch(Exception e){
					throw new Exception("更新求职意向失败，原因是："+e.getMessage());
				}
			}
			
			//更新学院信息校正表
			public int updateSchoolMessage(String province,String school,String college,int id) throws Exception{
				try{
					int i= sda.updateSchoolMessage(province,school,college,id);
					if(i>0){
						return i;
					}else{
						throw new Exception("更新条数为0");
					}
				}catch(Exception e){
					throw new Exception("更新求职意向失败，原因是："+e.getMessage());
				}
			}
			
			
			public List<Firm> queryAllSchool() throws Exception{
				try{
					return sda.queryAllSchool();
				}catch(Exception e){
					throw new Exception("查询公司列表失败，原因是："+e.getMessage());
				}
			}
			
			public Firm queryFirm(String id) throws Exception{
				try{
					return sda.queryFirm(id);
				}catch(Exception e){
					throw new Exception("查询公司失败，原因是："+e.getMessage());
				}
			}
			
			public Recruit queryRecruit(String id) throws Exception{
				try{
					return sda.queryRecruit(id);
				}catch(Exception e){
					throw new Exception("查询职位失败，原因是："+e.getMessage());
				}
			}
			
			public int addResume(Recruit rec,Student stu) throws Exception{
				try{
					return sda.addResume(rec,stu);
				}catch(Exception e){
					throw new Exception("投递失败，原因是："+e.getMessage());
				}
			}
			
			public boolean checkSendResume(int id1,int i) throws Exception{
				try{
					//System.out.println(111);
					return sda.checkSendResume(id1,i);
				}catch(Exception e){
					throw new Exception("投递失败，原因是："+e.getMessage());
				}
			}
			
			public List<Resume> queryallresumesend(int id) throws Exception{
				try{
					return sda.queryallresumesend(id);
				}catch(Exception e){
					throw new Exception("查询所有投递的简历失败，原因是："+e.getMessage());
				}
			}
			
			public boolean checkCollectFirm(String a,int id) throws Exception{
				try{
					return sda.checkCollectFirm(a,id);
				}catch(Exception e){
					throw new Exception("验证收藏失败，原因是："+e.getMessage());
				}
			}
			
			public boolean checkCollectRecruit(String a,int id) throws Exception{
				try{
					return sda.checkCollectRecruit(a,id);
				}catch(Exception e){
					throw new Exception("验证收藏失败，原因是："+e.getMessage());
				}
			}
			
			public int addCollectFirm(String a,int id,String now) throws Exception{
				try{
					return sda.addCollectFirm(a,id,now);
				}catch(Exception e){
					throw new Exception("收藏公司失败，原因是："+e.getMessage());
				}
			}
			
			public int addCollectRecruit(String a,int id,String now) throws Exception{
				try{
					return sda.addCollectRecruit(a,id,now);
				}catch(Exception e){
					throw new Exception("收藏职位失败失败，原因是："+e.getMessage());
				}
			}
			
			public int deleteResume(String id) throws Exception{
				try{
					int i= sda.deleteResume(id);
					if(i>0){
						return i;
					}else{
						throw new Exception("删除条数为0");
					}
				}catch(Exception e){
					throw new Exception("删除简历投递失败，原因是："+e.getMessage());
				}
			}
			
		
			public List<Recruit> queryAllRecruit() throws Exception{
				try{
					return sda.queryAllRecruit();
				}catch(Exception e){
					throw new Exception("查询所有投递的简历失败，原因是："+e.getMessage());
				}
			}
			
			public List<Item> queryAllItems() throws Exception{
				try{
					return sda.queryAllItems();
				}catch(Exception e){
					throw new Exception("查询所有项目失败，原因是："+e.getMessage());
				}
			}
			
			 public Item queryItemById(String id) throws Exception{
				 try{
						return sda.queryItemById(id);
					}catch(Exception e){
						throw new Exception("查询我的项目失败，原因是："+e.getMessage());
					}
			 }
			 
			 public boolean checkItem(int id) throws Exception{
				 try{
						return sda.checkItem(id);
					}catch(Exception e){
						throw new Exception("验证项目失败，原因是："+e.getMessage());
					}
			 }
			 
			 public int addItemById(Student stu) throws Exception{
				 try{
						int i= sda.addItemById(stu);
						if(i>0){
							return i;
						}else{
							throw new Exception("添加条数为0");
						}
					}catch(Exception e){
						throw new Exception("默认添加创业项目失败，原因是："+e.getMessage());
					}
			 }
		
			
				
}
