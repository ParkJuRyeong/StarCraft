package Model;

import listener.OnDiedListener;

public abstract class Unit {//�߻�Ŭ����

	protected int hp;		//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	protected int attack;	//���ݷ�
	protected String name;	//�̸�
	
	private Location loc;	//������ ��ġ
	private int range;		//���ݹ���
	
	protected int num;		//���� ����
	protected int exp;		//����ġ
	protected int level;	//����
	
	private boolean airAttackAble;	//���߰��� ���ɿ���
	
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
		//System.out.println(this.name + " ���� HP�� " + this.hp + "�Դϴ�.");
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
		//	System.out.println(unit.name + "�� ���̻� ������ �� �����ϴ�.");
		//}else {
			System.out.println(this.name + "�� " + targetUnit.name + "�� �����߽��ϴ�.");
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
		
		this.loc.movePoint(x, y);	// �� ��ü�� Ư������ �����ִ°� ����
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
