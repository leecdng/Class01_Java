import java.util.Calendar;

public class sdds {

	public sdds() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = 2021; //수능일 기준으로 잡아봤다.
		int month = 8;
		int date = 10;

		long now_day = cal.getTimeInMillis(); //현재 시간

		cal.set(year, month-1, date); //목표일을 cal에 set

		long event_day = cal.getTimeInMillis(); //목표일에 대한 시간
		long d_day = (event_day - now_day) / (60*60*24*1000);
		
		System.out.println(d_day);

	}

}
