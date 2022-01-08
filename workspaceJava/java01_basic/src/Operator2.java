class Operator2 
{
	public static void main(String[] args) 
	{
		// 비트 연산자 : &, |, ^(XOR), ~(부정)  -> 2진수 데이터를 이용한 연산자
		int a = 12;
		int b = 4;

		// & (and)
		// ex) 0011 & 0101 = 0001
		int result = a & b; // 1: true, 0: false
		System.out.println("result =" + result);	// result = 4
	
		// | (or)
		// ex) 0011 | 0101 = 0111;
		int result2 = a | b;
		System.out.println("result2 =" + result2);	// result2 = 12
		
		// ^ (XOR)
		// ex) 1101 ^ 0101 = 1000
		int result3 = a ^ b;	// 두 값이 다를 때 참 (익스크루시브오어)
		System.out.println("result3 =" + result3);	// result3 = 8

		// ~ (부정) : ~n = -(n+1);
		// 음수인 데이터를 환산하는 방법 : 2보수 -> 1의 보수 + 1
		// 1의 보수는 0은 1로 1은 0으로 바꾸는 것이다. (반대로 바꾸라는 것)
		// ex) ~ 0101 = 1010
		int result4 = ~a; // ~12
		System.out.print(result4);	// result4 = -13;


		



		// 쉬프트 연산자 : 비트를 이동시킨다.
		// << : 비트가 왼쪽으로 이동. 곱하기(*)기능 ---> a << n : a를 n bit만큼 왼쪽으로 이동하고 오른쪽은 0으로 채워라 : 곱하기 2의 n승 해라.
		// >>(부호로 채워짐), >>>(0으로 채워짐) : 비트가 오른쪽으로 이동. 나누기(/) 기능	---> a >> 2 : a를 n bit만큼 오른쪽으로 이동하고 왼쪽은 부호로 채워라. // a >>> n : a를 n비트만큼 오른쪽으로 이동하고 나머지는 0으로 채워라..
		// a = 12


		// << (left shift)
		int result5 = 12 << 2;	// 왼쪽으로 2bit 이동하고 오른쪽은 0으로 채워라
		System.out.println("result5 =" + result5);

		// >> (arithmeotic right shift)
		int result6 = 12 >> 2;	// 오른쪽으로 2bit 이동하고 왼쪽은 부호로 채워라
		System.out.println("result6 =" + result6);	// 3
		int result7 = -13 >> 2;	// 오른쪽으로 2bit 이동하고 왼쪽은 부호로 채워라
		System.out.println("result7 =" + result7);	// -4

		// >>> (logical right shift)
		int result8 = -13 >>> 2; // 오른쪽으로 2bit 이동하고 왼쪽은 0으로 채워라
		System.out.println("result8 =" + result8);	

	}
}
