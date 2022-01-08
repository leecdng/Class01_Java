public class Test2 {
	public static void main(String[] a) // JVM에 기본으로 내장된 클래스들이 있다. 첫글자 대문자면 그럴 수 있음
	{
		System.out.println("첫 번째 줄 출력");	// 클래스.변수.메소드(); // ""-> 문자열(String), '' ->문자(char)
		System.out.println(1234);			// "" -> 계산 불가, '' -> 계산 가능
		System.out.println(1234+1000);
		System.out.println("1234"+1000);	// "문자"화 된 숫자 + 숫자 -> 12341000
											// 문자열에 어떤 값을 더하면 문자열이 연결된다.

											// 한 줄 주석
											/* 여러 줄 주석 */
		System.out.print("ABCD");
		System.out.print("EFGH");			// ABCDEFGH -> ln(line) 빼니까 명령당 한 줄씩이 아닌 다음 명령도 한 줄로 쭉 이어짐

		
	}
}
