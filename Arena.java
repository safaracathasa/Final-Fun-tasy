package finalfuntasy.arena;

public class Arena {
	private int width;
	private int height;
	public Arena(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void cekPos(int x, int y) throws OutOfArenaExcept {
		if ((x > width-1) || (y > height-1) || (x < 0) || (y < 0)) {
			throw new OutOfArenaExcept("Out of bound!");
		}
	}
}
