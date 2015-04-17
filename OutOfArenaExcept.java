package dev.huntul.finalfuntasy.arena;

public class OutOfArenaExcept extends Exception {
	private static int jml_except = 0;
	OutOfArenaExcept(String msg) {
		super(msg);
		jml_except++;
	}
	static int jmlException() {
		return jml_except;
	}
	public void response() {
		System.out.println(getMessage());
	}
}
