package edu.biz.magic;

import lombok.Setter;

public class Magician {
	@Setter
	private MagicBox magicBox;
	@Setter
	private String magicWord;
	
	public void magic() {
		System.out.println("마술을 시작합니다.");
		System.out.println(magicWord);
		System.out.println("짜잔 --> " + magicBox.getContent());
	}
}
