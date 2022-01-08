import java.util.Scanner;

class DoWhileEx 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int data = 0;	// 다시 시작하냐고 물었을 때 입력값

		do{
			System.out.print("금액을 입력하세요. : ");
			int money = scan.nextInt();
			
			int won=50000; // 50000 10000 5000 1000...	// 화폐 단위
			int r=0; // 화폐 장 수
			do{
				int i =1;
				while(i<=10){	// 화폐 단위 총 10가지
					if(i==1){	// 가장 큰 단위부터 1번째로 나누기
						won=50000;		// won = 가장 큰 단위 50000
					}else if(i%2==0){	// 2번 째부터(짝수 차례 때)는 화폐단위/5
						won/=5;		// 10000, 1000, 100, 10, 1
					}else{	// 3번 째부터(홀수 차례 때)는 화폐단위/2
						won/=2;	// 5000, 500, 50, 5
					}

					i++; // 총 10번 돌게 해놓음

					r = money/won;	// 화폐 장 수 = 금액/화폐단위
					money %= won;	// 금액 = 금액을 화폐단위로 나눈 나머지 금액
					
					if(r!=0){	// 화폐 장 수가 0이 아닐 때만 출력
						if(won>=1000){	// 지폐는 장
							System.out.printf("%d원 = %d장\n", won, r);
						} else{	// 동전은 개
							System.out.printf("%d원 = %d개\n", won, r);
						} //if
					}//if
				}//while

			}while(money > 0);	// 남은 금액이 0보다 크면 (0원이 아니면) 계속 실행 // 0원 되면 끝남.
			//do-while

			System.out.print("다시 하시겠습니까? (1.예, 2.아니오) : ");
			data = scan.nextInt();

		}while(data==1); // do-while
	} // main
} // class

/*
	실행
	금액을 입력하세요? 126300
	50000원=2장
	10000원=2장
	5000원=1장
	1000원=1장
	100원=3개
	다시 하시겠습니까? (1.예, 2.아니오) : 1

	금액을 입력하세요? 5435
	5000원=1장
	100원=4개
	10원=3개
	1원=5개
	다시 하시겠습니까? (1.예, 2.아니오) : 2
*/