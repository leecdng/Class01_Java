class ForTestBreak2
{
	public static void main(String[] args) 
	{
		abc: // 라벨, 라벨명은 자유
		for(int i=1; i<=10; i++){
			
			for(int j=1; ; j++){	// 무한루프
				System.out.println("i="+i+" , j="+j);
				if(j>5){	// j가 5보다 크면(6이 되면) 멈춰라 -> 실행하고 멈춤
					break abc;
				}
			}
			// break 걸린 후 여기서 for문 실행

			/*if(i>3){	// i가 3보다 커지면(4가 되면) 멈춰라
				break;
			}*/
		}
		// for문 실행
		System.out.println("========");
	}
}
