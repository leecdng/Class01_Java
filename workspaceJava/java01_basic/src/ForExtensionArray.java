
public class ForExtensionArray {

	public static void main(String[] args) {
	
		int arr[] = {85,6,92,65,12,74,35};
		// 확장된 for문
		// 배열의 데이터형 변수 선언: 배열명
		for(int data : arr) {
			System.out.print(data+"\t");
		}
		System.out.println();
		
		
		// 2차원 배열
		int arr2 [][] = {
							{60,80,40,60}, 
							{56,62,84,79}, 
							{36,58,78,95}
						};
		
		// 1차원 배열의 변수 : 2차원 배열명
		for(int[] data : arr2) {
			// 배열의 데이터형 변수 : 1차원 배열명
			for(int z : data) {
				System.out.print(z + "\t");
			}
			System.out.println();
		}

	}

}
