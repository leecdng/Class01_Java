import java.util.Scanner;

class ForTest07
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		// 내가 쓴 답
		/*
		for(int i=1;;){ // 무한루프
			
			System.out.print("메뉴 [1. 사각형의 넓이, 2. 원의 넓이, 3. 종료]? ");
			int menu = scan.nextInt();

			int width = 0, height = 0;
			int result1 = 0;
			int radius = 0;
			final double PI = 3.141592;
			double result2 = 0;

			switch(menu){
				case 1:
					System.out.print("가로 = ");
					width = scan.nextInt();
					System.out.print("세로 = ");
					height = scan.nextInt();

					result1 = width * height;

					System.out.printf("사각형의 넓이 = %d\n", result1);

					break;

				case 2:
					System.out.print("반지름 = ");
					radius = scan.nextInt();

					result2 = radius * radius * PI;
					
					System.out.printf("원의 넓이 = %.2f\n", result2);

					break;

				case 3:
					System.exit(0);
			}

		} //for

			*/

		for(;;){
			System.out.print("[1. 사각형의 넓이, 2. 원의 넓이, 3. 종료]? ");
			int menu = scan.nextInt();
			if(menu==1){
				System.out.print("가로 = ");
				int w = scan.nextInt();
				System.out.print("세로 = ");
				int h = scan.nextInt();

				int rect = w * h;
				System.out.println("사각형의 넓이= " + rect);
			} else if(menu==2){
				System.out.print("반지름= ");
				int r = scan.nextInt();

				double circle = r * r * 3.141592;
				System.out.println("원의 넓이= "+circle);
			} else if(menu==3){
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 선택하세요.");
			}



		} // for



		
	} // main
}	// class
/*
	사각형의 넓이 = 가로 * 높이
	원의 넓이 = 반지름 * 반지름 * 3.141592

	실행
	메뉴 [1. 사각형의 넓이, 2. 원의 넓이, 3. 종료]? 1
	가로 =
	세로 =
	사각형의 넓이 =

	메뉴 [1. 사각형의 넓이, 2. 원의 넓이, 3. 종료]? 2
	반지름 =
	원의 넓이 =

	메뉴 [1. 사각형의 넓이, 2. 원의 넓이, 3. 종료]? 2

*/