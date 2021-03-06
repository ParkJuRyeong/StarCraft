package Model;

public class Location {

	public int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void movePoint(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public double getDistnace (Location target){
		int xDiffer = target.x - x;
		int yDiffer = target.y - x;
		return Math.sqrt(
					Math.pow(xDiffer, 2)+
					Math.pow(yDiffer, 2)
				);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
