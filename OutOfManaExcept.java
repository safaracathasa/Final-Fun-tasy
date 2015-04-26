package dev.huntul.finalfuntasy.character;

public class OutOfManaExcept extends Exception {
	OutOfManaExcept(String msg) {
		super(msg);
	}
	public void response() {
		System.out.println(getMessage());
	}
}
