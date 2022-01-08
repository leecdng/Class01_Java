package com.bitcamp.myapp.board;

public class PagingVO {
	private int totalRecord; // 총 레코드 수
	private int nowPage = 1; // 현재 페이지
	private int totalPage; // 총 페이지 수
	private int onePageRecord = 5; // 한 페이지당 레코드 수
	
	// 검색어
	private String searchKey;
	private String searchWord;
	
	// 페이지
	private int startPage=1;
	private int onePageNumCount=5; // 한 번에 찍을 총 페이지 수
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		// 총 페이지 수
		totalPage = (int) Math.ceil(totalRecord/(double)onePageRecord);
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		if(nowPage!=0) {
			startPage = (nowPage-1)/onePageNumCount * onePageNumCount + 1; // 현재페이지에 따른 스타트페이지 설정
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
