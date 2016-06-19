package Model;

public class Unit {

	protected int hp;		//자식들이 접근할수 있다. : 마린에서 hp 접근 가능 but controller에선 접근가능 불가
	protected int attack;	//공격력
	protected String name;
	
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

	public void inform() {
		System.out.println(hp);
	}
	
	public Unit(int hp, int attack, String name) {
		this.hp = hp;
		this.attack = attack;
		this.name = name;
	}
	
	public int attack(Unit unit) {
		this.hp = unit.hp - unit.attack;

		if(this.hp > 0){
			System.out.println(unit.name + "이 공격당했습니다. 현재 hp : " + this.hp);
			return this.hp;
		}else{
			System.out.println(unit.name +" die.");
			return 0;
		}
		
	}
	
}
