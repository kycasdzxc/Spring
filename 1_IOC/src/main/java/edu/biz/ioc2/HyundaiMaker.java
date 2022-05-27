package edu.biz.ioc2;

public class HyundaiMaker implements CarMaker {
	public Car sell(Money money) {
		// System.out.println("I sold a car :: " + car.getName());
		return new Car("sonata");
	}
}
