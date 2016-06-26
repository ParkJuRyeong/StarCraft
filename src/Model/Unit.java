package Model;

public class Unit {

	protected int hp;		//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	protected int attack;	//���ݷ�
	protected String name;
	protected int x;
	protected int y;
	
	private Location loc;	//������ ��ġ
	private int range;		//���ݹ���
	
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
		//System.out.println(this.name + " ���� HP�� " + this.hp + "�Դϴ�.");
		if(this.hp > 0){
			System.out.println(this.name + " HP : " + this.hp +" / Location " + this.x +"," + this.y);
		}
		//System.out.println();
	}
	
	public void attack(Unit unit) {
		
		if(unit.hp == 0){
			System.out.println(unit.name + "�� ���̻� ������ �� �����ϴ�.");
		}else {
			System.out.println(this.name + "�� " + unit.name + "�� �����߽��ϴ�.");
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
