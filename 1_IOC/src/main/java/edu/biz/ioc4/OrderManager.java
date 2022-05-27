package edu.biz.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {
	@Autowired @Qualifier("hm")
	private CarMaker maker;
	@Autowired
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