package Model;

public class Unit {

	protected int hp;		//자식들이 접근할수 있다. : 마린에서 hp 접근 가능 but controller에선 접근가능 불가
	protected int attack;	//공격력
	protected String name;
	
	protected int x;
	protected int y;
	
	public Unit(int hp, int attack, String name) {
		this.hp = hp;
		this.attack = attack;
		this.name = name;
		this.x = 0;
		this.y = 0;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
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

	public void inform() {
		System.out.println(this.name + " 현재 HP는 " + this.hp + "입니다.");
		System.out.println();
	}
	
	public void attack(Unit unit) {
		
		if(unit.hp == 0){
			System.out.println(unit.name + "을 더이상 공격할 수 없습니다.");
		}else {
			System.out.println(this.name + "이 " + unit.name + "을 공격했습니다.");
			unit.hp = unit.hp - this.attack;
			if(unit.hp <= 0){
				System.out.println(unit.name +" die.");
				System.out.println();
				unit.hp = 0;
				return;
			}
		}
		unit.inform();
	}
	
	public void Move(Unit unit, String xy) {
		
		int x = xy.indexOf(',', 1);
		int y = xy.indexOf(',', 2);
		
		System.out.println("X : " + x + "Y : " + y);
		
	}

}
