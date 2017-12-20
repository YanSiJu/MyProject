package cn.ccsu.test;

import org.junit.Test;

import cn.ccsu.entity.Toy;

/**
 * @author Bill
 *
 */
public class ReflectTest {

	public ReflectTest() {

	}

	/**
	 * 
	 */
	@Test
	public void classTest() {

		try {
			Class.forName("cn.ccsu.entity.Toy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		 Class<Toy> c =Toy.class; 
		 System.out.println(c);
		 System.out.println(c.getClass());
	}

}
