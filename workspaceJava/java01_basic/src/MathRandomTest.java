
public class MathRandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 난수 : 컴퓨터가 실행되는 시점에 0.0과 1.0 사이 임의의 값이 생성된다.
		// 랜덤 정수 만들기 -> *10을 하면 0~9 / 100을 곱하면 0~999 / 50이면 0~49까지
		// 50~100 만들려면 (정수화)(난수*(정수의 개수)+작은값--> (int)(난수*51)+50--> 정수 개수--> 큰값-작은값+1
		
		for(int i=1; i<=1000; i++) {
			double ran = Math.random();
			//int ranInt = (int)(ran*50);
			//주사위 랜덤 숫자
			int ranInt = (int)(ran*6)+1;
			System.out.print(ranInt+" ");
			if(i%10==0) System.out.println();
		}
	}
}
