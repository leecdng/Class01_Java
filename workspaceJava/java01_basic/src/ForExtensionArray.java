
public class ForExtensionArray {

	public static void main(String[] args) {
	
		int arr[] = {85,6,92,65,12,74,35};
		// Ȯ��� for��
		// �迭�� �������� ���� ����: �迭��
		for(int data : arr) {
			System.out.print(data+"\t");
		}
		System.out.println();
		
		
		// 2���� �迭
		int arr2 [][] = {
							{60,80,40,60}, 
							{56,62,84,79}, 
							{36,58,78,95}
						};
		
		// 1���� �迭�� ���� : 2���� �迭��
		for(int[] data : arr2) {
			// �迭�� �������� ���� : 1���� �迭��
			for(int z : data) {
				System.out.print(z + "\t");
			}
			System.out.println();
		}

	}

}
