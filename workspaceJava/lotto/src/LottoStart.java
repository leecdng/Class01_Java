
public class LottoStart {
	// 메인 메서드
		public static void main(String[] args) {
			LottoOOPCollection oop = new LottoOOPCollection();
			do {
				try {
					oop.lottoStart();
					break;
				} catch(NumberFormatException ne) {	// int형 아닌 다른 문자 입력 or 숫자를 너무 길게 or 0또는 음수, 10000초과 숫자 넣었을 경우
					System.out.println("잘못 입력하셨습니다. 1~10000까지의 숫자만 입력 가능합니다.");
				}
			} while(true);
		}
}
