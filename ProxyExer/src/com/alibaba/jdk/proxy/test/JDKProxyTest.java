package com.alibaba.jdk.proxy.test;

import org.junit.Test;
import com.alibaba.jdk.proxy.Handler;
import com.alibaba.service.ICountService;
import com.alibaba.service.Impl.CountServiceImpl;


public class JDKProxyTest {

	public JDKProxyTest() {

	}

	@Test
	public void dynamicProxyTest() {
		// 目标对象
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// 返回一个代理对象
		ICountService proxy = (ICountService) handler.bind(service);
		// 1.此处打印proxy时会先调用invoke()方法，很奇怪
		System.out.println("proxy:" + proxy);

		proxy.updateCount();
		// 2.目标对象的任何方法都会被拦截,是否可以指定只拦截某些方法(当然，不用Spring AOP 的情况下)
		proxy.queryCount();

	}

}
