package com.bitcamp.myapp.board;

public class PagingVO {
	private int totalRecord; // �� ���ڵ� ��
	private int nowPage = 1; // ���� ������
	private int totalPage; // �� ������ ��
	private int onePageRecord = 5; // �� �������� ���ڵ� ��
	
	// �˻���
	private String searchKey;
	private String searchWord;
	
	// ������
	private int startPage=1;
	private int onePageNumCount=5; // �� ���� ���� �� ������ ��
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		// �� ������ ��
		totalPage = (int) Math.ceil(totalRecord/(double)onePageRecord);
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		if(nowPage!=0) {
			startPage = (nowPage-1)/onePageNumCount * onePageNumCount + 1; // ������������ ���� ��ŸƮ������ ����
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getOnePageNumCount() {
		return onePageNumCount;
	}
	public void setOnePageNumCount(int onePageNumCount) {
		this.onePageNumCount = onePageNumCount;
	}
	
}
