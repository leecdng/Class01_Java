package com.seoul.myapp.board;

public class PagingVO {
	private int onePageRecord=5; // �� �������� �� ��
	private int totalRecord; // �� �� ��
	private int totalPage; // �� ������ ��
	private int nowPage=1; // ���� ������
	private int oneGroupPage=5; // �� ���� ���� ������ ��
	private int groupStartPage=1; // �� ������ �׷��� ù ������
	
	
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
		// �� ������ ��
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
