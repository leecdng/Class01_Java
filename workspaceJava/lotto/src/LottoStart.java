
public class LottoStart {
	// ���� �޼���
		public static void main(String[] args) {
			LottoOOPCollection oop = new LottoOOPCollection();
			do {
				try {
					oop.lottoStart();
					break;
				} catch(NumberFormatException ne) {	// int�� �ƴ� �ٸ� ���� �Է� or ���ڸ� �ʹ� ��� or 0�Ǵ� ����, 10000�ʰ� ���� �־��� ���
					System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~10000������ ���ڸ� �Է� �����մϴ�.");
				}
			} while(true);
		}
}
