package edu.biz.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KiaMaker implements CarMaker {
	@Autowired
	private Car car;
	
	public void setCar(Car car) {
		this.car = car;
	}

	public Car sell(Money money) {
		return car;
	}
}
