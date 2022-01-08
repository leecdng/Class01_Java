class Variable	// 클래스는 대문자로 시작하고 합성어일 때는 각 단어의 첫 번째 문자를 대문자로 한다. 256글짜까지 가능
{
	public static void main(String[] args) 
	{
		// 변수란: 값 또는 데이터를 보관하는 기능을 가진다.
		/* 기본데이터형 :	정수형 -> byte(1byte), short(2byte), int(4byte), long(8byte)
						실수형 -> float(4byte), double(8byte)
						논리 -> boolean (true / false -> 1byte)
						문자 -> char(2byte)

			레퍼런스형
		*/

		// 국어 50점, 영어 80점, 수학 70점

		//byte kor = 50;	// 1byte
		int kor2 = 50;	// 4byte	정수형 상수는 int형이다.
		int eng = 80;
		int math = 70;

		//변수 생성 규칙
		// 첫 글자는 소문자로 시작하거나, _ 또는 $로 시작할 수 있다.
		// 합성어일 때는 두 번째 이후 단어는 대문자로 시작한다.
		// 명령어(예약어)를 변수로 사용할 수 없다.
		// 가능: name, _name, $name
		// 불가능: 9name, *name, if(예약어)...

		// 계산
		// 연산자 : +, -, *, / , %(나머지)


		int sum = kor2 + eng + math;

		// 정수, 정수를 계산하면 = 정수
		// 정수, 실수 계산하면 = 실수
		// 실수, 정수 = 실수
		// 실수, 실수 = 실수

		double ave = sum / 3.0;	// 실수의 기본 데이터 타입은 double, 3도 실수로 바꿔주려고 3.0으로 함.
								// double을 주로 쓰고, float = 31.4f (뒤에 f를 붙여줌)
		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + ave);


		boolean state = true;	// true, false
		char lastName = '홍';	// 문자형은 ''임 ""하면 컴파일 오류남
		String firstName = "길동";
		
		// 형변환 (자주 씀)
		float data = (float) 3562.3265;
		int data2 = (int) 12.1;

		System.out.println(data);
		System.out.println(data2);

		// 큰 데이터형의 데이터를 작은 데이터형의 변수에 대입할 때는 형변환을 하면 된다.
		// 작은 데이터형의 데이터를 큰 데이터형의 변수에 대입할 때는 형변환을 하지 않아도 된다.
		double data3 = 1234567;

		
	}
}
