package com.alibaba.jdk.proxy;

public class CountImpl implements Count {

	public CountImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void queryCount() {
		System.out.println("查看账户方法...");

	}

	@Override
	public void updateCount() {
		System.out.println("修改账户方法...");

	}

}
