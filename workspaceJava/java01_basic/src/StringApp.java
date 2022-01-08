class StringApp 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World");	// String 문자열 : 여러 글자도 가능
		System.out.println('H');	// '' -> Character 문자 : 1글자만 표현하는 데이터 타입
		System.out.println("H");	// String 문자열

		System.out.println("Hello "
				+ "World");			// 이렇게 해도 줄이 안 바뀜
		// new line -> \n	: 줄바꿈
		System.out.println("Hello \nWorld");
		
		// System.out.println("Hello "World"");	// Hello "World" -> 컴파일 에러

		// escape
		System.out.println("Hello \"World\"");	// 잠깐 해방시킴(?)
	}
}
