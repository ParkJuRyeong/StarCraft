package Model;

public class Unit {

	protected int hp;		//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	protected int attack;	//���ݷ�
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
			System.out.println(unit.name + "�� ���ݴ��߽��ϴ�. ���� hp : " + this.hp);
			return this.hp;
		}else{
			System.out.println(unit.name +" die.");
			return 0;
		}
		
	}
	
}
