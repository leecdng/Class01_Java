
public class ArrayTest02 {

	public static void main(String[] args) {
		// 2���� : ��� ���� ������.
		
		// �迭�� ����
		// 	   [��][��]
		int data[][] = new int[5][5]; // int 25���� ���� ������ ������ ������
		
		data[0][3] = 100;
		data[1][2] = 85;
		data[1][4] = 84;
		data[3][3] = 77;
		
		// 2���� �迭 ���		length: 1���� �迭�� �� ������ ����, 2���� �迭�� ���� ���� ��
		for(int r=0; r<data.length; r++) {	// ���� ����ŭ
			for(int c=0; c<data[r].length; c++) {	// data[r].length -> r���� ĭ ��
				System.out.print(data[r][c]+"\t");
			}
			System.out.println();
		}
		
		// 2���� �迭�� �ʱⰪ ����
		String[][] jusorok = {
				{"ȫ�浿", "010-0000-0000", "abc00@abc.com"},
				{"�̱浿", "010-1111-0000", "abc11@abc.com"},
				{"��浿", "010-2222-0000", "abc22@abc.com"}
		};
		
		for(int r=0; r<jusorok.length; r++) {
			for(int c=0; c<jusorok[r].length; c++) {
				System.out.print(jusorok[r][c]+"\t");
			}
			System.out.println();
		}
		
		

	}

}
