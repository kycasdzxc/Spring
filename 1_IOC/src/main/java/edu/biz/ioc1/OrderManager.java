package edu.biz.ioc1;

public class OrderManager {
	private HyundaiMaker maker;

	public OrderManager() {
		maker = new HyundaiMaker();
	}

	public void order() {
		Money money = new Money(1000);
		Car car = maker.sell(money);
		System.out.println("I sold a car :: " + car.getName() + ", " + money.getAmount());
	}
}