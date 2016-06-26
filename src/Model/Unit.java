package Model;

public class Unit {

	protected int hp;		//자식들이 접근할수 있다. : 마린에서 hp 접근 가능 but controller에선 접근가능 불가
	protected int attack;	//공격력
	protected String name;
	protected int x;
	protected int y;
	
	private Location loc;	//유닛의 위치
	private int range;		//공격범위
	
	public Unit(int hp, int attack, String name, int range) {
		this.hp = hp;
		this.attack = attack;
		this.name = name;
		this.x = 0;
		this.y = 0;
		this.range = range;
		//this.loc.setX(0);
		//this.loc.setY(0);
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	public void inform() {
		//System.out.println(this.name + " 현재 HP는 " + this.hp + "입니다.");
		if(this.hp > 0){
			System.out.println(this.name + " HP : " + this.hp +" / Location " + this.x +"," + this.y);
		}
		//System.out.println();
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
	
	public boolean isAttackable(Unit target) {
		//Location myloc = this.loc;
		//Location targetloc = target.loc;
		//double distance = myloc.getDistnace(targetloc);
		double distance = this.loc.getDistnace(target.getLoc());
		return distance <= this.range;
	}

	public void moveUnit(int x, int y) {
		System.out.println(x);
		this.loc.setX(x);
		System.out.println(this.loc.getX());
		//this.loc.setX(this.loc.getX() + x);
		//this.loc.setY(this.loc.getX() + y);
	}

}
