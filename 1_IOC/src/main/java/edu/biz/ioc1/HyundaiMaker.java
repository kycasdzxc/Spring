package edu.biz.ioc1;

public class HyundaiMaker {
	public Car sell(Money money) {
		Car car = new Car("sonata");
		// System.out.println("I sold a car :: " + car.getName());
		return car;
	}
}
