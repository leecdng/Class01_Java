
public class ArrayEx04 {

	public static void main(String[] args) {
		
		int arr[][] = new int[10][10]; // 0~9까지
		
		for(int r=0; r<arr.length-1; r++) {	// 행번호 //0~8까지만 반복
			for(int c=0; c<arr[r].length-1; c++) { // 열번호 0~8
					arr[r][c] = (r+1) * (c+1);
					arr[r][9] = arr[r][9] + arr[r][c]; // 행의 합 // arr[r][9]의 초기값은 0
					//arr[r][9] += arr[r][c];
					arr[9][c] = arr[9][c] + arr[r][c]; // 열의 합 // arr[9][c]의 초기값은 0
			}
		}
		
		// arr[9][9] = 0;
				
		for(int[] data : arr) {
			for(int a : data) {
				System.out.print(a+"\t");
			}
			System.out.println();
		}
	}
}