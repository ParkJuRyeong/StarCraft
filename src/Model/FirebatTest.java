package Model;

public class FirebatTest {

	public int power;//ü��
	public int attack;//���ݷ�
	
	
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
	
	//����.
	public void attack(String UnitName, int attack) {
		this.power = this.power - attack;
		
		if(this.power > 0 ){
			System.out.println(UnitName + " ���ݴ��޽��ϴ�." );
			System.out.println(attack + " ü�°���." );
			System.out.println("���� ü�� : " +  this.power);
		}else {
			System.out.println(UnitName + " die.");
		}
		
		System.out.println();
		
	}
	
}
