package dev.huntul.finalfuntasy.shop;

public class OutOfMoneyExcept extends Exception {
	OutOfMoneyExcept(String msg) {
		super(msg);
	}
	public void response() {
		System.out.println(getMessage());
	}
}
