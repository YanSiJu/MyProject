package cn.csu.local;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
}
