package com.atguigu.java8;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.atguigu.java8.Employee.Status;

public class TestStreamAPI3 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "鏉庡洓", 79, 6666.66, Status.BUSY),
			new Employee(101, "寮犱笁", 18, 9999.99, Status.FREE),
			new Employee(103, "鐜嬩簲", 28, 3333.33, Status.VOCATION),
			new Employee(104, "璧靛叚", 8, 7777.77, Status.BUSY),
			new Employee(104, "璧靛叚", 8, 7777.77, Status.FREE),
			new Employee(104, "璧靛叚", 8, 7777.77, Status.FREE),
			new Employee(105, "鐢颁竷", 38, 5555.55, Status.BUSY)
	);
	
	//3. 缁堟鎿嶄綔
	/*
		褰掔害
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 鈥斺�斿彲浠ュ皢娴佷腑鍏冪礌鍙嶅缁撳悎璧锋潵锛屽緱鍒颁竴涓�笺��
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream()
			.reduce(0, (x, y) -> x + y);
		
		System.out.println(sum);
		
		System.out.println("----------------------------------------");
		
		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		
		System.out.println(op.get());
	}
	
	//闇�姹傦細鎼滅储鍚嶅瓧涓� 鈥滃叚鈥� 鍑虹幇鐨勬鏁�
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream()
			.map(Employee::getName)
			.flatMap(TestStreamAPI1::filterCharacter)
			.map((ch) -> {
				if(ch.equals(""))
					return 1;
				else 
					return 0;
			}).reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	//collect鈥斺�斿皢娴佽浆鎹负鍏朵粬褰㈠紡銆傛帴鏀朵竴涓� Collector鎺ュ彛鐨勫疄鐜帮紝鐢ㄤ簬缁橲tream涓厓绱犲仛姹囨�荤殑鏂规硶
	@Test
	public void test3(){
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);

		System.out.println("----------------------------------");
		
		HashSet<String> hs = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(HashSet::new));
		
		hs.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		Optional<Double> max = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.maxBy(Double::compare));
		
		System.out.println(max.get());
		
		Optional<Employee> op = emps.stream()
			.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		
		System.out.println(op.get());
		
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		
		System.out.println(sum);
		
		Double avg = emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println(avg);
		
		Long count = emps.stream()
			.collect(Collectors.counting());
		
		System.out.println(count);
		
		System.out.println("--------------------------------------------");
		
		DoubleSummaryStatistics dss = emps.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));
		
		System.out.println(dss.getMax());
	}
	
	//鍒嗙粍
	@Test
	public void test5(){
		Map<Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		
		System.out.println(map);
	}
	
	//澶氱骇鍒嗙粍
	@Test
	public void test6(){
		Map<Status, Map<String, List<Employee>>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "鑰佸勾";
				else if(e.getAge() >= 35)
					return "涓勾";
				else
					return "鎴愬勾";
			})));
		
		System.out.println(map);
	}
	
	//鍒嗗尯
	@Test
	public void test7(){
		Map<Boolean, List<Employee>> map = emps.stream()
			.collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
		
		System.out.println(map);
	}
	
	//
	@Test
	public void test8(){
		String str = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining("," , "----", "----"));
		
		System.out.println(str);
	}
	
	@Test
	public void test9(){
		Optional<Double> sum = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.reducing(Double::sum));
		
		System.out.println(sum.get());
	}
}
