package Model;

public class MarineTest {

	public int power;//체력
	public int attack;//공격력
	
	private int hp;
	private int shield;
	
	private boolean opt1;
	private boolean opt2;
	private boolean opt3;
	private int attackOpt1;
	
	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public boolean isOpt1() {
		return opt1;
	}

	public void setOpt1(boolean opt1) {
		this.opt1 = opt1;
	}

	public boolean isOpt2() {
		return opt2;
	}

	public void setOpt2(boolean opt2) {
		this.opt2 = opt2;
	}

	public boolean isOpt3() {
		return opt3;
	}

	public void setOpt3(boolean opt3) {
		this.opt3 = opt3;
	}

	public int getAttackOpt1() {
		return attackOpt1;
	}

	public void setAttackOpt1(int attackOpt1) {
		this.attackOpt1 = attackOpt1;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	private boolean isDead = false;
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public MarineTest(int power, int attack) {
		this.power = power;
		this.attack = attack;
	}
	
/*
	 public void attack(Marine m) {
	 }
	 public void attack(Firebat f) {
	 }
*/
	
	//공격.
	public void attack(String UnitName, int attack) {
		this.power = this.power - attack;
		
		if(this.power > 0 ){
			System.out.println(UnitName + " 공격당햇습니다." );
			System.out.println(attack + " 체력감소." );
			System.out.println("현재 체력 : " +  this.power);
		}else {
			System.out.println(UnitName + " die.");
		}
		
		System.out.println();
		
	}
	
	
}
