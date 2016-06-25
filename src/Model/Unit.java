package Model;

public class Unit {

	protected int hp;		//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	protected int attack;	//���ݷ�
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
		System.out.println(this.name + " ���� HP�� " + this.hp + "�Դϴ�.");
		System.out.println();
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
	
	public void Move(Unit unit, String xy) {
		
		int x = xy.indexOf(',', 1);
		int y = xy.indexOf(',', 2);
		
		System.out.println("X : " + x + "Y : " + y);
		
	}

}
