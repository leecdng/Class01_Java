
public class ArrayTest02 {

	public static void main(String[] args) {
		// 2차원 : 행과 열을 가진다.
		
		// 배열의 선언
		// 	   [행][열]
		int data[][] = new int[5][5]; // int 25개를 저장 가능한 변수가 생성됨
		
		data[0][3] = 100;
		data[1][2] = 85;
		data[1][4] = 84;
		data[3][3] = 77;
		
		// 2차원 배열 출력		length: 1차원 배열일 때 변수의 개수, 2차원 배열일 때는 행의 수
		for(int r=0; r<data.length; r++) {	// 행의 수만큼
			for(int c=0; c<data[r].length; c++) {	// data[r].length -> r행의 칸 수
				System.out.print(data[r][c]+"\t");
			}
			System.out.println();
		}
		
		// 2차원 배열의 초기값 설정
		String[][] jusorok = {
				{"홍길동", "010-0000-0000", "abc00@abc.com"},
				{"이길동", "010-1111-0000", "abc11@abc.com"},
				{"김길동", "010-2222-0000", "abc22@abc.com"}
		};
		
		for(int r=0; r<jusorok.length; r++) {
			for(int c=0; c<jusorok[r].length; c++) {
				System.out.print(jusorok[r][c]+"\t");
			}
			System.out.println();
		}
		
		

	}

}
