package cn.csu.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class Main {

	public Main() {

	}

	@Test
	public void test() {
		/*
		 * LocalDateTime ldt = LocalDateTime.now(); System.out.print(ldt);
		 */

		String str = "2012-01-18 12:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		System.out.println("dateTime.getMonth():"+dateTime.getMonth());
		System.out.print("dateTime.getMonthValue():"+dateTime.getMonthValue());
	}
}
