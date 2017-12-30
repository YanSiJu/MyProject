package cn.csu.local;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;

public class LocalDateTimeTest {

	public static void main(String[] args) {

		System.out.println(new Date());
		System.out.println(LocalDate.now().isLeapYear());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());

		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);

		// Returns time based on system clock zone Clock defaultClock =
		Clock.systemDefaultZone();
		System.out.println("Clock : " + clock.toString());
	}

	@Test
	public void interlvalCalc() {

		LocalDate today = LocalDate.now();
		System.out.println("today : " + today);

		LocalDate birthday = LocalDate.of(1996, 07, 06);
		System.out.println("birthday : " + birthday);
		System.out.println("Period: " + Period.between(birthday, today));

		System.out.println("I hava been the world for " + ChronoUnit.DAYS.between(birthday, today) + " days.");

		System.out.println("I hava been the world for " + ChronoUnit.DAYS.between(birthday, today) + " days.");

		System.out.println("-----------------------------------------------------------\n");
	}

	@Test
	public void formatTest() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY年MM月dd日 ");
		LocalDate today = LocalDate.now();
		String dateStr = today.format(dtf);
		System.out.println("dateStr:" + dateStr);

		System.out.println("----------------------------------------\n");
		DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("YYYY年MM月dd日  HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTimeStr:" + dateTime.format(dateTimeformatter));
		
		System.out.println("----------------------------------------\n");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern(" HH:mm:ss");
		LocalTime time = LocalTime.now();
		System.out.println("dateTimeStr:" + time.format(timeformatter));

	}
}
