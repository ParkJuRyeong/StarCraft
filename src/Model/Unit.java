package Model;

import listener.OnDiedListener;

public abstract class Unit {//추상클래스

	protected int hp;		//자식들이 접근할수 있다. : 마린에서 hp 접근 가능 but controller에선 접근가능 불가
	protected int attack;	//공격력
	protected String name;	//이름
	
	private Location loc;	//유닛의 위치
	private int range;		//공격범위
	
	protected int num;		//유닛 순번
	protected int exp;		//경험치
	protected int level;	//레벨
	
	private boolean airAttackAble;	//공중공격 가능여부
	
	private OnDiedListener onDiedListener;
	
	public abstract void bark();	
	public abstract void upgrade();
	
	public Unit(int hp, int attack, String name, int range, boolean airAttackAble) {
		this.hp = hp;
		this.attack = attack;
		this.name = name;
		this.range = range;
		this.loc = new Location(0, 0);
		this.level = 1;
		this.exp = 0;
		this.airAttackAble = airAttackAble;
	}
	
	public void inform() {
		//System.out.println(this.name + " 현재 HP는 " + this.hp + "입니다.");
		//if(this.hp > 0){
			System.out.println("[" + this.name + "] HP : " + this.hp 
								+ " / Location " + this.loc.getX() +"," + this.loc.getY() 
								+ " / Level : " + this.level
								+ " / Attack : " + this.attack 
								//+ " / Range : " + this.range 
								+ " / Exp : " + this.exp 
								);
		//}
		//System.out.println();
	}
	
	public void unitAttack(Unit targetUnit) {
		
		//if(unit.hp == 0){
		//	System.out.println(unit.name + "을 더이상 공격할 수 없습니다.");
		//}else {
			System.out.println(this.name + "이 " + targetUnit.name + "을 공격했습니다.");
			targetUnit.hp = targetUnit.hp - this.attack;
			this.exp += 30;
			if(targetUnit.hp <= 0){
				//System.out.println(unit.name +" die.");
				//System.out.println();
				//targetUnit.hp = 0;
				OnDiedListener targetdiedListener = targetUnit.getOnDiedListener();
				if(targetdiedListener != null){
					targetdiedListener.onDied(targetUnit);
				}
				
				return;
			}
		//}
		//unit.inform();
		this.upgrade();
	}
	
	public boolean isAttackable(Unit target) {
		double distance = this.loc.getDistnace(target.getLoc());
		return distance <= this.range;
	}
	
	public boolean isAirAttackable(Unit target) {
		if(this.airAttackAble){
			return true;	
		}else{
			return false;
		}
	}

	public void move(int x, int y) {
		
		this.loc.movePoint(x, y);	// 각 객체의 특성으로 나눠주는게 좋음
		//this.loc.setX(this.loc.getX() + x);
		//this.loc.setY(this.loc.getY() + y);
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public OnDiedListener getOnDiedListener() {
		return onDiedListener;
	}

	public void setOnDiedListener(OnDiedListener onDiedListener) {
		this.onDiedListener = onDiedListener;
	}
}
