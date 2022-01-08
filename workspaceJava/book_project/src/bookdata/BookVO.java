package bookdata;

public class BookVO {
	private String isbn; // key
	private String bookTitle; // 이하 value
	private String writer;
	private String company;
	private String group;
	private int price;
	private int stock;
	
	public BookVO() {
		
	}
	
//	public BookVO(String isbn) {
//		this.isbn = isbn;
//	}
	
	public BookVO(String bookTitle, String writer, String company, String group, int price, int stock) {
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.company = company;
		this.group = group;
		this.price = price;
		this.stock = stock;
		
	}
	
	// 목록 타이틀 출력
//	public static void printTitle() {
//		System.out.println("---------------------------------------------------------------------");
//		System.out.print("\t도서명\t\t");
//		System.out.printf("%6s %12s %5s %6s %5s \n", "지은이", "출판사", "분류", "가격", "재고");
//		System.out.println("---------------------------------------------------------------------");
//	}
	
	// 목록 타이틀 출력
	public static void printTitle() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.printf("  %-16s %-20s %-11s %-9s %-5s %-5s %-5s \n", "ISBN", "도서명", "지은이", "출판사", "분류", "가격", "재고");
		System.out.println("---------------------------------------------------------------------------------------------------");
	}
	
	
	// 출력 - 책 1권당 출력
	public void printList() {
		System.out.printf(" %10s \t ", isbn);
		// 책 제목 출력
		String bookTitlePT, writerPT, companyPT;
		if(bookTitle.length() >10) bookTitlePT = bookTitle.substring(0, 10).concat("...");
		else bookTitlePT = bookTitle;
		
		if(bookTitle.length()<=3) System.out.print(bookTitlePT+"\t\t\t");
		else if(bookTitle.length()>7) System.out.print(bookTitlePT+"\t");
		else System.out.print(bookTitlePT+"\t\t");
		
		// 지은이 출력
		if(writer.length() >7) writerPT = writer.substring(0, 7).concat("...");
		else writerPT = writer;
		if(writer.length()<=5) System.out.print(writerPT+"\t\t");
		else System.out.print(writerPT+"\t");
		
		// 출판사 출력
		if(company.length() >6) companyPT = company.substring(0, 6).concat("...");
		else companyPT = company;
		if(company.replace(" ","").length()<4) System.out.print(companyPT+"\t\t");
		else System.out.print(companyPT+"\t");
		
		System.out.printf("%-5s %-8s %-5s \n", group, price, stock);
		//System.out.printf("%5s %10s %10d %10d %10d \n", writer, company, group, price, stock);
	}
	
	// ISBN 출력
//	public void printListAdmin() {
//		System.out.printf(" %10s \t ", isbn);
//		printList();
//	}
	
	// 상세 정보 출력
	public void printDetail() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("[도서 상세 정보]\n도서명: %s\n지은이: %s\n출판사: %s\n분류: %s\n가격: %d원\n재고: %d\nISBN: %s\n", bookTitle, writer, company, group, price, stock, isbn);
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	// 상세 정보 출력 - 수정용 (번호 매김)
	public void editDetail() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("[1.도서명] %s\n[2.지은이] %s\n[3.출판사] %s\n[4.분　류] %s\n[5.가　격] %d원\n[6.재　고] %d\n[7.ISBN] %s\n\n[8.수정취소]\n", bookTitle, writer, company, group, price, stock, isbn);
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	
	// getter // setter
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn (String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
