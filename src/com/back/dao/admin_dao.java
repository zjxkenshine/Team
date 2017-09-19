package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Item;
import com.back.model.School;
import com.back.util.DBUtil;

public class admin_dao {
	
	//查询所有学校校正信息
	public List<School> queryallschoolupdate(){
		String sql="select * from updateschoolmessage";
		List<Map<String,Object>> lmap=DBUtil.list(sql);
		List<School> lsh=new ArrayList<School>();
		if(lmap!=null){
			for(int i=0;i<lmap.size();i++){
				School sch=new School();
				sch.setID((int)lmap.get(i).get("ID"));
				sch.setCollege((String)lmap.get(i).get("College"));
				sch.setProvince((String)lmap.get(i).get("Province"));
				sch.setUniversity((String)lmap.get(i).get("University"));
				sch.setStuID((int)lmap.get(i).get("StuID"));
				lsh.add(sch);
			}
			return lsh;
		}else{
			return null;
		}
	}
	
	//删除校正信息
	public int deleteschoolupdate(String id){
		String sql="delete from updateschoolmessage where ID=?";
		int i=DBUtil.executeUpdate(sql,id);
		return i;
	}
	
	public School queryonemessagebyid(String id){
		String sql="select * from updateschoolmessage where ID=?";
		List<Map<String,Object>> lmap=DBUtil.list(sql,id);
		if(lmap.size()==1){
			School sch=new School();
			for(int i=0;i<lmap.size();i++){
				sch.setID((int)lmap.get(i).get("ID"));
				sch.setCollege((String)lmap.get(i).get("College"));
				sch.setProvince((String)lmap.get(i).get("Province"));
				sch.setUniversity((String)lmap.get(i).get("University"));
				sch.setStuID((int)lmap.get(i).get("StuID"));
				
			}
			return sch;
		}else{
			return null;
		}
	}
	
	//判断是否有值(学校)
	public String checkuniversity(School sch){
		String sql="select * from cms_university where university=?";
		List<Map<String,Object>> lmap =DBUtil.list(sql,sch.getUniversity());
		if(lmap!=null&&lmap.size()==1){
			return  String.valueOf((int)lmap.get(0).get("university_id"));
		}else{
			return null;
		}
	}
	
	//判断是否有值(学院)
	public boolean checkcollege(School sch,String id){
		String sql="select * from cms_college where college=? and university_id=?";
		List<Map<String,Object>> lmap =DBUtil.list(sql,new Object[]{sch.getCollege(),id});
		if(lmap!=null&&lmap.size()!=0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	//存学院值
	public int addcollege(School sch,String id){
		String sql="insert into cms_college(college,university_id) values(?,?)";
		int i=DBUtil.executeUpdate(sql,new Object[]{sch.getCollege(),id});
		return i;
	}
	
	//获取省份id
	public String queryoneprobyid(School sch){
		String sql="select * from cms_provinces where province=?";
		List<Map<String,Object>> lmap =DBUtil.list(sql,sch.getProvince());
		if(lmap!=null&&lmap.size()==1){
			return String.valueOf((int)lmap.get(0).get("province_id"));
		}else{
			return null;
		}
	}
	
	//更新学校
	public int adduniversity(School sch,String id){
		String sql="insert into cms_university(university,province_id) values(?,?)";
		int i=DBUtil.executeUpdate(sql,new Object[]{sch.getUniversity(),id});
		return i;
	}
	
	
	//删除更新表
	public int deleteupdateschool(String id){
		String sql="delete from updateschoolmessage where ID=?";
		int i=DBUtil.executeUpdate(sql, id);
		return i;
	}
	
	//查询项目列表
			public List<Item> queryAllItem(){
				String sql="select * from stu_start";
				List<Map<String,Object>> lmap=DBUtil.list(sql);
				List<Item> lte=new ArrayList<Item>();
				if(lmap!=null){
					for(int i=0;i<lmap.size();i++){
						Item ite=new Item();				
						ite.setAddresss((String)lmap.get(i).get("Addresss"));
						ite.setBusinessPlan((String)lmap.get(i).get("BusinessPlan"));
						ite.setCheckStatus((String)lmap.get(i).get("CheckStatus"));				
						ite.setDescripe((String)lmap.get(i).get("Descripe"));
						ite.setEmail((String)lmap.get(i).get("Email"));
						ite.setFirmID((int)lmap.get(i).get("FirmID"));
						ite.setFirmName((String)lmap.get(i).get("FirmName"));				
						ite.setID((int)lmap.get(i).get("ID"));				
						ite.setIntention((String)lmap.get(i).get("Intention"));
						ite.setItemName((String)lmap.get(i).get("ItemName"));
						ite.setNeedDiscripe((String)lmap.get(i).get("NeedDiscripe"));
						ite.setNumber((int)lmap.get(i).get("Number"));
						ite.setPatentNum((int)lmap.get(i).get("PatentNum"));
						ite.setQQ((String)lmap.get(i).get("QQ"));
						ite.setSchool((String)lmap.get(i).get("School"));
						ite.setStatus((String)lmap.get(i).get("Status"));
						ite.setStuID((int)lmap.get(i).get("StuID"));
						ite.setStuName((String)lmap.get(i).get("StuName"));
						ite.setTel((String)lmap.get(i).get("Tel"));
						ite.setNeedNumber((int)lmap.get(i).get("NeedNumber"));
						lte.add(ite);
					}
					return lte;
				}else{
					return null;
				}
			}
			
			//查询所有验证项目
			public List<Item> queryAllCheckItem(){
				String sql="select * from stu_start where Status='1' and CheckStatus='1'";
				List<Map<String,Object>> lmap=DBUtil.list(sql);
				List<Item> lte=new ArrayList<Item>();
				if(lmap!=null){
					for(int i=0;i<lmap.size();i++){
						Item ite=new Item();				
						ite.setAddresss((String)lmap.get(i).get("Addresss"));
						ite.setBusinessPlan((String)lmap.get(i).get("BusinessPlan"));
						ite.setCheckStatus((String)lmap.get(i).get("CheckStatus"));				
						ite.setDescripe((String)lmap.get(i).get("Descripe"));
						ite.setEmail((String)lmap.get(i).get("Email"));
						ite.setFirmID((int)lmap.get(i).get("FirmID"));
						ite.setFirmName((String)lmap.get(i).get("FirmName"));				
						ite.setID((int)lmap.get(i).get("ID"));				
						ite.setIntention((String)lmap.get(i).get("Intention"));
						ite.setItemName((String)lmap.get(i).get("ItemName"));
						ite.setNeedDiscripe((String)lmap.get(i).get("NeedDiscripe"));
						ite.setNumber((int)lmap.get(i).get("Number"));
						ite.setPatentNum((int)lmap.get(i).get("PatentNum"));
						ite.setQQ((String)lmap.get(i).get("QQ"));
						ite.setSchool((String)lmap.get(i).get("School"));
						ite.setStatus((String)lmap.get(i).get("Status"));
						ite.setStuID((int)lmap.get(i).get("StuID"));
						ite.setStuName((String)lmap.get(i).get("StuName"));
						ite.setTel((String)lmap.get(i).get("Tel"));
						ite.setNeedNumber((int)lmap.get(i).get("NeedNumber"));
						lte.add(ite);
					}
					return lte;
				}else{
					return null;
				}
			}
			
			//启动项目
			public int openItem(String id){
				String sql="update stu_start set Status='1' where ID=?";
				int i=DBUtil.executeUpdate(sql,id);
				return i;
			}
			
			//禁用项目
			public int stopItem(String id){
				String sql="update stu_start set Status='0' where ID=?";
				int i=DBUtil.executeUpdate(sql,id);
				return i;
			}
			
			//通过项目
			public int passItem(String id){
				String sql="update stu_start set CheckStatus='2' where ID=?";
				int i=DBUtil.executeUpdate(sql,id);
				return i;
			}
			
			//不通过项目
			public int failItem(String id){
				String sql="update stu_start set CheckStatus='0' where ID=?";
				int i=DBUtil.executeUpdate(sql,id);
				return i;
			}

}
