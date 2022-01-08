class Operator1 
{
	public static void main(String[] args) 
	{
		// 연산자 : 산술연산자, 관계연산자(비교연산자), 논리연산자, 단항연산자, 대입연산자, 쉬프트연산자, 삼항연산자

		// 1. 산술연산자 : +, -, *, /(몫, 실수), %(나머지)

		int num1 = 10;
		int num2 = 3;

		int result = num1 % num2;	// 1
		System.out.println("result =" + result);



		// 2. 단항연산자 : ++(1증가), --(1감소)

		int a = 10;
		a = a + 1;	// 1 증가하는 수식
		System.out.println("a = " + a);

		// a++;	// 1 증가하는 수식
		++a;
		System.out.println("a = " + a);


		// --a;	== a = a - 1;
		a--; // 1감소하는 수식	//a = 11
		System.out.println("a = " + a);

		int b = a++;	// b=11 / a=12
		System.out.println("b =" + b + ", a =" + a);
		int c = ++a;	// c=13 / a=13
		System.out.println("c =" + c + ", a =" + a);

		int result2 = b + c++;	// 11+13, c=14	// b + ++c; 일 경우 11+14, c=14가 나옴
		System.out.println("result2 =" + result2 + ", c=" + c);	// 24, 14



		// 3. 대입연산자
		// a = 13
		a += 4;	// a = a + 4;	// 17	// a++; a=a+1; a+=1; 모두 같음
		// b = 11
		b -= 3;	// b = b - 3;	// 8
		// c = 14
		c *= 2;	// c = c * 2;	// 28

		System.out.println("a =" + a + ", b =" + b + ", c =" + c);

		c += a + b;	// c = c + (a+b); 인 셈
		System.out.println("c =" + c); // c = 53



		// 4. 비교연산자 : 값이 boolean 값으로 나올 수 있는 연산자
		//	<, <=, >, >=, ==, !=
		int x = 200;
		int y = 300;

		boolean boo = x > y;	// false
		boolean boo2 = x < y;	// true
		System.out.println("boo =" + boo);
		System.out.println("boo2 =" + boo2);



		// 5. 삼항연산자
		// 급여가 10000원 이상일 때는 보너스 50%
		// 급여가 10000원 미만일 때는 보너스 90% 이럴 때 보너스는 얼마?
		int sal = 12000;	// 급여

		// 결과 = (조건식)? 참일 때 : 거짓일 때	// result = (n > 10)? true : false;
		double bonus = (sal>=10000)? sal*0.5 : sal*0.9;
		System.out.println("sal =" + sal + ", bonus =" + bonus);



		// 6. 논리연산자 : &&(and), ||(or), !(not)
		// 평균에 따른 학점 구하기
		int ave = 75;
		String grade = (ave>=70 && ave<80)? "c":"그 외";
		System.out.println("grade =" + grade);	// grade = c;

		
		char ch = 'A';	// char 타입은 연산이 가능하다!
		// ch++;
		// ch = ch + 1;	// 컴파일 오류	// char(2byte) + int(4byte) -> int가 더 크기 때문에 결과값도 char에 int 대입 불가. char + int 결과값은 int로 나옴. 그래서 형변환 해줘야 함!
		ch = (char)(ch + 1);
		System.out.println("ch =" + ch);

		char ch2 = (char)85;
		System.out.println("ch2 =" + ch2);	// ch2 = U // 아스키코드 검색~


	}
}