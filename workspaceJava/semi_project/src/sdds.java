import java.util.Calendar;

public class sdds {

	public sdds() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = 2021; //������ �������� ��ƺô�.
		int month = 8;
		int date = 10;

		long now_day = cal.getTimeInMillis(); //���� �ð�

		cal.set(year, month-1, date); //��ǥ���� cal�� set

		long event_day = cal.getTimeInMillis(); //��ǥ�Ͽ� ���� �ð�
		long d_day = (event_day - now_day) / (60*60*24*1000);
		
		System.out.println(d_day);

	}

}
