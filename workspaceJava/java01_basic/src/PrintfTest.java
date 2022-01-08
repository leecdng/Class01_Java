class PrintfTest 
{
	public static void main(String[] args) 
	{
		// format : 포멧 형식
		// 정수 : %d , 실수 : %f , 문자열 : %s, %o(Octal:8진수), %x(Hex:16진수), %c(char:한 글자)
		// ex : %10d , %10.3f, %8s ...등

		// 제어문자: \n, \t, \\, \", \'

		int num = 1234;
		System.out.printf("num 변수의 \n값은 %d \n", num);
		System.out.printf("num 변수의 \n값은 %10d입니다. \n", num);
		System.out.printf("일정한 간격\t띄울 때...\n가격\\3,000 \n");
		System.out.printf("\"큰따옴표\" 그리고 \'작은따옴표\' \n");

		double num2 = 210987654321.23515;
		System.out.printf("num2=%10.3f이다. \n", num2); // 10.3 중에 소수점 자리 3자리????

		String nameKor ="홍길동";
		String nameEng ="hong";
		System.out.printf("국문 이름은 %-10s이다. \n", nameKor);	// -왼쪽 정렬
		System.out.printf("영문 이름은 %10s이다. \n", nameEng);	// 오른쪽 정렬

		int num3 = 12;
		System.out.printf("%d,	%o,	%x\n", num3, num3, num3);	// 12, 14, c

	}
}
