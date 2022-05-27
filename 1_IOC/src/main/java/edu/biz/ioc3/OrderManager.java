package edu.biz.ioc3;

public class OrderManager {
	private CarMaker maker;
	private Money money;
	
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public void order() {
		Car car = maker.sell(money);
		System.out.println("I sold a car :: " + car.getName() + ", " + money.getAmount());
	}
}