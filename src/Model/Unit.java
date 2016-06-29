package Model;

public class Unit {

	protected int hp;		//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	protected int attack;	//���ݷ�
	protected String name;	//�̸�
	
	private Location loc;	//������ ��ġ
	private int range;		//���ݹ���
	
	protected int num;		//���� ����
	protected int exp;		//����ġ
	protected int level;	//����

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
	
	public Unit(int hp, int attack, String name, int range) {
		this.hp = hp;
		this.attack = attack;
		this.name = name;
		this.range = range;
		this.loc = new Location(0, 0);
		this.level = 1;
		this.exp = 0;
	}
	
	public void inform() {
		//System.out.println(this.name + " ���� HP�� " + this.hp + "�Դϴ�.");
		if(this.hp > 0){
			System.out.println("[" + this.name + "] HP : " + this.hp 
								+ " / Location " + this.loc.getX() +"," + this.loc.getY() 
								+ " / Level : " + this.level
								+ " / Attack : " + this.attack 
								//+ " / Range : " + this.range 
								+ " / Exp : " + this.exp 
								);
		}
		//System.out.println();
	}
	
	public void attack(Unit unit) {
		
		//if(unit.hp == 0){
		//	System.out.println(unit.name + "�� ���̻� ������ �� �����ϴ�.");
		//}else {
			System.out.println(this.name + "�� " + unit.name + "�� �����߽��ϴ�.");
			unit.hp = unit.hp - this.attack;
			this.exp += 30;
			if(unit.hp <= 0){
				System.out.println(unit.name +" die.");
				System.out.println();
				unit.hp = 0;
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

	public void moveUnit(int x, int y) {
		this.loc.setX(this.loc.getX() + x);
		this.loc.setY(this.loc.getY() + y);
	}
	
	public boolean upgrade() {
		return false;
	}
	
}
