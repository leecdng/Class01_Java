package com.seoul.myapp.board;

public class PagingVO {
	private int onePageRecord=5; // 한 페이지당 글 수
	private int totalRecord; // 총 글 수
	private int totalPage; // 총 페이지 수
	private int nowPage=1; // 현재 페이지
	private int oneGroupPage=5; // 한 번에 보일 페이지 수
	private int groupStartPage=1; // 한 페이지 그룹의 첫 페이지
	
	
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 총 페이지 수
		this.totalPage = totalRecord / onePageRecord;
		if(totalRecord % onePageRecord != 0) { totalPage += 1; }
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		if(nowPage > 0) { groupStartPage = (nowPage-1) / oneGroupPage * oneGroupPage + 1; }
	}
	public int getOneGroupPage() {
		return oneGroupPage;
	}
	public void setOneGroupPage(int oneGroupPage) {
		this.oneGroupPage = oneGroupPage;
	}
	public int getGroupStartPage() {
		return groupStartPage;
	}
	public void setGroupStartPage(int groupStartPage) {
		this.groupStartPage = groupStartPage;
	}
	
}
