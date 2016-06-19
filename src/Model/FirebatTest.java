package Model;

public class FirebatTest {

	public int power;//체력
	public int attack;//공격력
	
	
	public FirebatTest(int power, int attack) {
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
