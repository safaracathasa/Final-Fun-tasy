package dev.huntul.finalfuntasy.etc;

public class MismatchPositionExcept extends Exception {
	MismatchPositionExcept(String msg) {
		super(msg);
	}
	public void response() {
		System.out.println(getMessage());
	}
}
