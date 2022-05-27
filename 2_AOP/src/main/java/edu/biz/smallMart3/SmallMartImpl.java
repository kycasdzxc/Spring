package edu.biz.smallMart3;

public class SmallMartImpl implements SmallMart{

	@Override
	public void getProduct(String name) throws Exception {
		System.out.printf("getProduct(%s)%n", name);
//		throw new Exception("내가 만든 예외");
	}
	
	@Override
	public void getProduct2(String name) throws Exception {
		System.out.printf("getProduct2(%s)%n", name);
//		throw new Exception("내가 만든 예외");
	}
}
