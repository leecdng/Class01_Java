import java.util.Calendar;

class CalendarTest 
{
	public static void main(String[] args) 
	{
		//��ǻ���� ��¥ �ð� ���� ������
		// Calendar, Date

		Calendar now = Calendar.getInstance(); // getInstance() -> ��ü�� �������ִ� �޼ҵ� - �̹� new�� ����� ��

		// ��¥ ���� : set() --> ���� ������ �����Ѵ�.
		now.set(2021, 5, 8); // 2018�� 7�� 14�Ϸ� ���õ�

		// �⵵�� ����
		now.set(Calendar.YEAR, 2022);
		now.set(Calendar.MONTH, 10);

		// 2021�� 6�� 4�� (��) 15:21
		// get() --> ��¥, �ð� ���� ������ ���´�.
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1; // 6
		int day = now.get(Calendar.DAY_OF_MONTH); // 4
		int week = now.get(Calendar.DAY_OF_WEEK); // 6
		int hour = now.get(Calendar.HOUR_OF_DAY); // 16
		int minute = now.get(Calendar.MINUTE); // 44
		
		String weekStr = "";
		switch(week){
			case 1: weekStr = "��"; break;
			case 2: weekStr = "��"; break;
			case 3: weekStr = "ȭ"; break;
			case 4: weekStr = "��"; break;
			case 5: weekStr = "��"; break;
			case 6: weekStr = "��"; break;
			case 7: weekStr = "��"; break;
		}

		System.out.println(now);	//���⼭ ���� ��ɾ� ��� ����

		System.out.printf("%d�� %d�� %d�� (%s) %d:%d\n", year, month, day, weekStr, hour, minute);

		//
		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("��������=>"+lastDay);
		int lastMonth = now.getActualMaximum(Calendar.MONTH);
		System.out.println("�� �߿� ���� ū ��=>"+lastMonth); // 12���ε� ���ڷδ� 11 ����.
		int lastYear = now.getActualMaximum(Calendar.YEAR);
		System.out.println("���� �߿� ���� ū ��=>"+lastYear);

	}
}
