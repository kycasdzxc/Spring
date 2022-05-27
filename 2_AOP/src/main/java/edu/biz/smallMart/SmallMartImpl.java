package edu.biz.smallMart;

public class SmallMartImpl implements SmallMart{

	@Override
	public void getProduct(String name) throws Exception {
		System.out.printf("getProduct(%s)%n", name);
		throw new Exception("내가 만든 예외");
	}
	
}
