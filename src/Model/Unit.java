package Model;

public class Unit {

	protected int hp;	//자식들이 접근할수 있다. : 마린에서 hp 접근 가능 but controller에선 접근가능 불가
	
	public Unit(int hp) {
		this.hp = hp;
	}
	
	public void inform() {
		System.out.println(hp);
	}
	
}
