package com.back.model;

public class PageBean {
	private int nowPage=1;//初始当前页面
	private int pageSize=16;//每页显示数据数量
	private int totalpage;//总页数
	private int totalcount;//总数据数量
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	@Override
	public String toString() {
		return "PageBean [nowPage=" + nowPage + ", pageSize=" + pageSize
				+ ", totalpage=" + totalpage + ", totalcount=" + totalcount
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
