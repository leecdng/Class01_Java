class DataType{
	public static void main(String[] args) 
	{
		System.out.println(6);	// Number
		System.out.println("six"); //String 문자열
		
		System.out.println("6"); // String 6

		System.out.println(6+6); // 12
		System.out.println("6"); // 66

		System.out.println(6*6); // 36
		// System.out.println("6"*"6"); // 컴파일 오류. 문자열은 곱하기 못 함.

		System.out.println("1234".length()); // 4
		//System.out.println(1111.length()); // 컴파일 오류 - String 전용 연산..


		System.out.println("___________");
		int n = 0;
		String a = (n>0)? "양수":"음수";
		String b = (n == 0)? "0":a;
		System.out.println(b);


	}
}
