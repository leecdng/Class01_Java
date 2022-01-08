class Casting	// 형변환.. 필요할 때 검색
{
	public static void main(String[] args) 
	{
		double a = 1.1;
		double b = 1;
		double b2 = (double) 1; // 명시적 형변환
		System.out.println(b);	// 1을 double형에 담으면 1.0이 됨

		// int c = 1.1;	// 컴파일 오류.
		double d = 1.1;
		int e = (int) 1.1;	// 1.1 -> 1.0 손실 일어남
		System.out.println(e);

		// 1 to String
		String f = Integer.toString(1);
		System.out.println(f.getClass());	// String
	}
}
