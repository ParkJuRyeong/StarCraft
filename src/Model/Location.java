package Model;

public class Location {

	private int x;
	private int y;
	
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
		System.out.println("X : "  + this.x);
		System.out.println("X : "  + x);
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
