import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bookdata.BookDataSet;
import bookdata.BookVO;
import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class BookSystem {
	String loginId;
	
	public BookSystem() {
		MemberDataSet.memberData();
		MemberDataSet.bookingData();
		BookDataSet.basicBookData();
		bookStart();
	}
	
	// 처음 실행
	public void bookStart() {
		do {
			String select = inputData("[1.로그인][2.회원가입][3.종료]: ");
			if(select.equals("1")) {
				Login login = new Login();
				loginId = login.loginProcess();
				break;
			} else if (select.equals("2")) {
				Join join = new Join();
				loginId = join.joinProcess();
				break;
			}else if (select.equals("3")) {
				exitBookSystem();
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		} while(true);
		MemberVO mvo = new MemberVO();
		mvo = MemberDataSet.memberList.get(loginId);
		
		if(mvo.getGrade().equals("일반회원")) {
			showBookList();
			bookProcess();
		} else if(mvo.getGrade().equals("관리자")) {
			showBookList();
			bookProcessAdmin();
		}

	}
	
	// 메뉴 출력 - 관리자
	public String bookNavAdmin() {
		System.out.println("\n[1.도서목록] [2.도서검색] [3.도서등록] [4.도서정보수정] [5.도서삭제] [6.예약목록] [7.회원목록] [8.나의 정보] [9.로그아웃] [0.종료]");
		return inputData("메뉴 번호를 입력하세요. : ");
	} // 메뉴 출력 - 관리자 ----->
	
	// 메뉴 출력 - 일반인
	public String bookNav() {
		System.out.println("\n[1.도서목록] [2.도서검색] [3.도서예약하기] [4.예약확인] [5.나의 정보] [6.로그아웃] [7.종료]");
		return inputData("메뉴 번호를 입력하세요. : ");
	} // 메뉴 출력 - 일반인 ----->
	
	// 메뉴 실행 - 관리자
	public void bookProcessAdmin() {
		do {
			String nav = bookNavAdmin();
			
			if(nav.equals("1")) { // 1. 도서목록
				showBookList();
			} else if(nav.equals("2")) { // 2. 도서검색
				searchBook();
			} else if(nav.equals("3")) { // 3. 도서등록
				addBook();
				showBookList();
			} else if(nav.equals("4")) { // 4. 도서정보수정
				editBook();
				showBookList();
			} else if(nav.equals("5")) { // 5. 도서삭제
				deleteBook();
				showBookList();
			} else if(nav.equals("6")) { // 6. 예약 목록
				showBookingListAdmin();
			} else if(nav.equals("7")) { // 7. 회원 목록
				showMemberListAdmin();
			} else if(nav.equals("8")) { // 8. 나의 정보
				editMyInfo();
			} else if(nav.equals("9")) { // 9. 로그아웃
				bookStart();
			} else if(nav.equals("0")) { // 0. 종료
				exitBookSystem();
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}while(true);
	} // 메뉴 실행 - 관리자 ----->
	
	// 메뉴 실행 - 일반인
	public void bookProcess() {
		do {
			String nav = bookNav();
			
			if(nav.equals("1")) { // 1. 도서목록
				showBookList();
			} else if(nav.equals("2")) { // 2. 도서검색
				searchBook();
			} else if(nav.equals("3")) { // 3. 도서예약하기
				bookingBook();
				showBookList();
			} else if(nav.equals("4")) { // 4. 예약확인
				bookingBookDetail();
				showBookList();
			} else if(nav.equals("5")) { // 5. 나의 정보
				editMyInfo();
			} else if(nav.equals("6")) { // 6. 로그아웃
				bookStart();
			} else if(nav.equals("7")) { // 7. 종료
				exitBookSystem();
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}while(true);
	} // 메뉴 실행 - 일반인 ----->
	
	
	// 도서검색 - ISBN은 온전히 입력했을 때만 검색되게 함 / 검색어 및 비교문자 공백 없앰.
	public void searchBook() {
		String msg;
		boolean chk = false;
		boolean chk2 = false;
		try {
			int answer = Integer.parseInt(inputData("[1.통합검색] [2.도서명] [3.지은이] [4.출판사] [5.ISBN]\n검색할 항목 번호를 선택하세요. : "));
			switch(answer) {
				case 1: msg = "검색어"; break;
				case 2: msg = "도서명"; break;
				case 3: msg = "지은이"; break;
				case 4: msg = "출판사"; break;
				case 5: msg = "ISBN"; break;
				default: throw new NumberFormatException();
			} // switch
			String findTxt = inputData(msg + ": ").replace(" ","");
			
			BookVO.printTitle();
			Set<Map.Entry<String, BookVO>> list = BookDataSet.bookList.entrySet();
			Iterator<Map.Entry<String, BookVO>> it = list.iterator();
			
			while(it.hasNext()) {
				Map.Entry<String, BookVO> e = (Map.Entry<String, BookVO>)it.next();
				BookVO vo = e.getValue();
				vo.setIsbn(e.getKey());
				switch(answer) {
					case 1:
						msg ="";
						String msg1 = vo.getBookTitle();
						String msg2 = vo.getWriter(); 
						String msg3 = vo.getCompany();
						String msg4 = vo.getIsbn();
						if(msg1.replace(" ","").indexOf(findTxt)!= -1 || msg2.replace(" ","").indexOf(findTxt)!= -1 || msg3.replace(" ","").indexOf(findTxt)!= -1 || msg4.replace(" ","").equals(findTxt)) chk=true;
						else chk=false;
						break;
					case 2: msg = vo.getBookTitle(); break;
					case 3: msg = vo.getWriter(); break;
					case 4: msg = vo.getCompany(); break;
					case 5:
						msg = "";
						if(vo.getIsbn().equals(findTxt)) chk=true;
						else chk=false;
						break;
				} // switch
				if(msg.replace(" ","").indexOf(findTxt)!= -1 || chk) {
					vo.printList();
					chk2 = true;
				} //if
			} // while
			if(chk2 == false) System.out.println(" \t \t \t \t 검색된 도서가 없습니다.");
		} catch(NumberFormatException nfe) {
			System.out.println("잘못 입력하였습니다.");
			searchBook();
		} catch(Exception e) {
			System.out.println("잘못 입력하였습니다.");
			searchBook();
		}
//		} catch(NoSuchElementException nsee) { -------------------------------------- 오류 확인해 보기
//			System.out.println("잘못 입력하였습니다.");
//			searchBook();
//		}// try-catch
	} // 도서검색 ----->
	
	
	// 도서등록
	public void addBook() {
		System.out.println("등록할 도서의 정보를 입력하세요.");
		String isbn, group;
		int price, stock;
		// isbn 유효성 검사
		isbn = checkIsbn("ISBN : ", "nowIsbn"); // 2번째 매개변수값은 아무거나 써도 됨 (ISBN 수정이 아닐 시)
		String bookTitle = inputData("도서명: ");
		String writer = inputData("지은이: ");
		String company = inputData("출판사: ");
		
		// 분류 검사
		do {
			try {
				group = inputData("분류: ");
				int groupInt = Integer.parseInt(group);
				if(groupInt>=0 && groupInt<1000 && group.length()==3) break;
				else throw new NumberFormatException();
			} catch(NumberFormatException nfe) {
				System.out.println("3자리 숫자만 입력해주세요.");
			}
		} while(true);
		
		//가격 검사
		do {
			try {
				price = Integer.parseInt(inputData("가격: "));
				if(price>=0 && price<=10000000) break;
				else System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
			} catch(NumberFormatException nfe) {
				System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
			}
		} while(true);
		
		//재고 검사
		do {
			try {
				stock = Integer.parseInt(inputData("재고: "));
				if(stock>=0 && stock<=10000000) break;
				else System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
			} catch(NumberFormatException nfe) {
				System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
			}
		} while(true);
		
		BookDataSet.bookList.put(isbn, new BookVO(bookTitle, writer, company, group, price, stock));
		System.out.println("해당 도서 정보가 등록되었습니다.");
	} // 도서등록 ----->
	
	
	// 도서 정보 수정
	public void editBook() {
		String isbn = inputData("수정할 도서의 ISBN을 입력하세요. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("해당 도서를 찾을 수 없습니다. ");
			do {
				String answer = inputData("[1.다시 입력하기] [2.목록으로 돌아가기] : ");
				if(answer.equals("1")) {
					editBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("관리자")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true);
		} else {
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.editDetail();
			do {
				String answer = inputData("수정할 항목을 선택하세요. : ");
				if(answer.equals("1")) {
					System.out.println("[1.도서명] "+ vo.getBookTitle());
					vo.setBookTitle(inputData("수정할 내용: "));
					break;
				} else if(answer.equals("2")) {
					System.out.println("[2.지은이] "+ vo.getWriter());
					vo.setWriter(inputData("수정할 내용: "));
					break;
				} else if(answer.equals("3")) {
					System.out.println("[3.출판사] "+ vo.getCompany());
					vo.setCompany(inputData("수정할 내용: "));
					break;
				} else if(answer.equals("4")) {
					System.out.println("[4.분　류] "+ vo.getGroup());
					vo.setGroup(inputData("수정할 내용: "));
					break;
				} else if(answer.equals("5")) {
					System.out.println("[5.가　격] "+ vo.getPrice());
					do {
						try {
							int price = Integer.parseInt(inputData("수정할 내용: "));
							if(price>=0 && price<=10000000) {
								vo.setPrice(price);
								break;
							} else {
								System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
							}
						} catch(NumberFormatException nfe) {
							System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
						}
					} while(true);
					break;
				} else if(answer.equals("6")) {
					System.out.println("[6.재　고] "+ vo.getStock());
					do {
						try {
							int stock = Integer.parseInt(inputData("수정할 내용: "));
							if(stock>=0 && stock<=10000000) {
								vo.setStock(stock);
								break;
							} else {
								System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
							}
						} catch(NumberFormatException nfe) {
							System.out.println("0 ~ 1천 이하의 정수만 입력해주세요.");
						}
					} while(true);
					break;
				} else if(answer.equals("7")) {
					System.out.println("[7.ISBN] "+ vo.getIsbn());
					String newIsbn = checkIsbn("수정할 ISBN: ", isbn); // ISBN 유효성 체크
					BookDataSet.bookList.put(newIsbn, vo);
					BookDataSet.bookList.remove(vo.getIsbn());
					break;
				} else if(answer.equals("8")) {
					System.out.println("수정이 취소되었습니다.");
					break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				} // if
			} while(true);

			System.out.println("수정되었습니다.");
		} // if
	} // 도서 정보 수정 ----->
	
	
	// 도서삭제
	public void deleteBook() {
		String isbn = inputData("삭제할 도서의 ISBN을 입력하세요. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("해당 도서를 찾을 수 없습니다. ");
			do {
				String answer = inputData("[1.다시 입력하기] [2.목록으로 돌아가기] : ");
				if(answer.equals("1")) {
					deleteBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("관리자")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true);
		} else {		///////////////// 도서 검색 후에 작성하기
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.printDetail();
			int answer = Integer.parseInt(inputData("해당 도서를 정말 삭제하시겠습니까? [1.삭제] [2.취소] : "));
			if(answer == 1) {
				System.out.println("삭제되었습니다.");
				BookDataSet.bookList.remove(isbn);
			}
			else if(answer == 2) {
				System.out.println("취소되었습니다.");
				//bookProcessAdmin();
			}
		}
	} // 도서삭제 ----->
	
	
	// 도서 목록 보여주기 
	public void showBookList() {
		BookVO.printTitle();
		Set<Map.Entry<String, BookVO>> list = BookDataSet.bookList.entrySet();
		Iterator<Map.Entry<String, BookVO>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String, BookVO> e = (Map.Entry<String, BookVO>)it.next();
			BookVO vo = e.getValue();
			vo.setIsbn(e.getKey());
			vo.printList();
		}
	} // 도서 목록 보여주기 ----->
	
	
	// 예약 목록 보여주기
	public void showBookingListAdmin() {
		MemberVO.printBookingTitle();
		List<MemberVO> list = MemberDataSet.bookingList;
		for(int i=0; i<list.size(); i++) {
			MemberVO mvo = list.get(i);
			//MemberVO mvo2 = MemberDataSet.memberList.get(mvo.getId());
			mvo.printBookingList();
		}
		//MemberVO.printBookingList();
	} // 예약 목록 보여주기 ----->
	
	
	// 예약하기
	public void bookingBook() {
		String isbn = inputData("예약할 도서의 ISBN을 입력하세요. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("해당 도서를 찾을 수 없습니다. ");
			do {
				String answer = inputData("[1.다시 입력하기] [2.목록으로 돌아가기] : ");
				if(answer.equals("1")) {
					bookingBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("관리자")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true);
			
		} else {
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.printDetail();
			if(vo.getStock() == 0) {
				System.out.println("해당 도서는 품절되었습니다.");
			} else {
				int qnty = Integer.parseInt(inputData("예약할 수량: "));
				if(vo.getStock()-qnty<0) {
					System.out.println("예약 가능한 수량이 부족합니다. 재고를 확인해주세요.");
				} else {
					do {
						String answer = inputData("해당 도서를 예약하시겠습니까? [1.예약] [2.취소] : ");
						if(answer.equals("1")) {
							// 예약리스트 올리기
							mvo = MemberDataSet.memberList.get(loginId);
							int listSize = MemberDataSet.bookingList.size();
							String bookingCode = "A"+(listSize+1);
							MemberDataSet.addBooking(new MemberVO(bookingCode, isbn, vo.getBookTitle(), qnty ,loginId , mvo.getName(), mvo.getTel()));
							// 재고 수량 빼기
							vo.setStock(vo.getStock()-qnty);
							
							System.out.println("예약되었습니다.");
							break;
						}
						else if(answer.equals("2")) {
							System.out.println("취소되었습니다.");
							break;
						} else {
							System.out.println("잘못 입력하셨습니다.");
						}
					} while(true);
				}
			}
		}
	}
	
	// 예약 확인
	public void bookingBookDetail() {
		System.out.println("\t\t\t나의 예약 목록");
		MemberVO.printBookingCheckTitle();
		List<MemberVO> list = MemberDataSet.bookingList;
		boolean check = false;
		for(int i=0; i<list.size(); i++) {
			MemberVO mvo = list.get(i);
			if(mvo.getId().equals(loginId)) {
				mvo.printBookingCheck();
				check = true;
			}
		}
		System.out.println();
		if(!check) {
			System.out.println("예약 내역이 없습니다.");
			do {
				String select = inputData("[1.목록으로 돌아가기] : ");
				if(select.equals("1")) {
					break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true);
		} else {
			do {
				String select = inputData("[1.목록으로 돌아가기] [2.예약 취소] : ");
				if(select.equals("1")) {
					break;
				} else if(select.equals("2")) {
					String bookingCode = inputData("예약번호를 입력하세요. :  ");
					boolean chk = false;
					for(int i=0; i<list.size(); i++) {
						MemberVO mvo = list.get(i);
						if(mvo.getBookingCode().equals(bookingCode) && mvo.getId().equals(loginId)) {
							int bookingNum = Integer.parseInt(bookingCode.substring(1));
							// 재고 다시 추가하기
							BookVO vo = BookDataSet.bookList.get(mvo.getIsbn());
							vo.setStock(vo.getStock()+mvo.getQnty());
							// 예약 데이터 삭제하기
							MemberDataSet.bookingList.remove(bookingNum-1);
							// 예약 취소 메세지
							System.out.println("해당 예약이 취소되었습니다.");
							chk = true;
							break;
						}
					}
					if(!chk) System.out.println("잘못된 예약 번호입니다.");
					else break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}while(true);
		}
	}
	
	
	
	// 회원 목록 보여주기
	public void showMemberListAdmin() {
		MemberVO.printMemberTitle();
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO vo = e.getValue();
			vo.setId(e.getKey());
			vo.printMemberList();
		}
	} // 회원 목록 보여주기 ----->
	
	
	// 회원 정보 수정 + 탈퇴
	public void editMyInfo() {
		String pw, name, tel, email;
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		Join join = new Join();
		do {
			mvo.printMyInfo();
			do {
				String select = inputData("[1.목록으로 돌아가기] [2.회원정보 수정] [3.회원 탈퇴] : ");
				if(select.equals("1")) {
					if(mvo.getGrade().equals("관리자")) {
						showBookList();
						bookProcessAdmin();
					} else {
						showBookList();
						bookProcess();
					}
					break;
				} else if(select.equals("2")) {
					String answer = inputData("수정할 항목을 선택하세요. [1.비밀번호] [2.이름] [3.휴대폰번호] : ");
					if(answer.equals("1")) {
						pw = join.inputMemberPw();
						mvo.setPw(pw);
						System.out.println("수정이 완료되었습니다.");
						break;
					} else if(answer.equals("2")) {
						name = join.inputMemberName();
						mvo.setName(name);
						System.out.println("수정이 완료되었습니다.");
						break;
					} else if(answer.equals("3")) {
						tel = join.inputMemberTel();
						mvo.setTel(tel);
						System.out.println("수정이 완료되었습니다.");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				} else if(select.equals("3")) {
					String answer = inputData("정말 탈퇴하시겠습니까? [1.회원탈퇴] [2.취소] : ");
					if(answer.equals("1")) {
						MemberDataSet.memberList.remove(loginId);
						System.out.println("탈퇴가 완료되었습니다.");
						bookStart();
						break;
					} else if(answer.equals("2")) {
						System.out.println("취소되었습니다.");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true);
		} while(true);
	} // 도서 정보 수정 ----->
	
	
	// 종료
	public void exitBookSystem() {
		System.out.println("종료되었습니다.");
		System.exit(0);
	}
	
	
	// 데이터 입력 받기
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // 데이터 입력 받기 ----->
	
	
	// ISBN 유효성 검사 // 등록 시엔 nowIsbn = ""; 으로
	public String checkIsbn(String msg, String nowIsbn) {
		String newIsbn;
		do {
			try {
				newIsbn = inputData(msg);
				boolean newIsbnCheck = BookDataSet.bookList.containsKey(newIsbn);
				if(newIsbnCheck) {
					if(newIsbn.equals(nowIsbn)) System.out.println("해당 도서의 기존 ISBN과 같습니다. 다시 입력하세요.");
					else System.out.println("이미 등록된 도서의 ISBN입니다. 다시 입력하세요.");
				} else {
					long isbnLong = Long.parseLong(newIsbn);
					if(isbnLong >0 && (newIsbn.length()==10 || newIsbn.length()==13)) break;
					else throw new NumberFormatException();
				}
			} catch(NumberFormatException nfe) {
				System.out.println("10자리 또는 13자리의 숫자만 입력하세요.");
			}
		} while(true);
		
		return newIsbn;
	} // 유효성 검사 ISBN ----->
	
}
