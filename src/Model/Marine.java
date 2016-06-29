package Model;

public class Marine extends Unit{

	public Marine(String name) {
		//������ ���� �Ǳ��� Unit �����Ǿ����
		super(40, 15, name, 10);	//super : Unit(int hp, int attack, String name) ȣ��
	}
/*	
	public void inform() {//������ : �������̵� / Unit���� ������ �޼ҵ带 Marine���� �ٽ� ������ / ������ ����� ǥ�õ�
		System.out.println(this.name + " ���� ��ġ�� " + this.x +"," + this.y +"�Դϴ�.");
		System.out.println();
	}
*/	
	public boolean upgrade() {
		if(this.level == 1 && this.exp >= 50){
			this.level += 1;
			this.exp -= 50;
			System.out.println("[" + this.name +"]" + " Level " + this.level + " Upgrade" );
			this.attack += 3;
			this.hp = 45;
			return true;
		}else if(this.level == 2 && this.exp >= 100){
			this.level += 1;
			this.exp -= 100;
			System.out.println("[" + this.name +"]" + " Level " + this.level + " Upgrade" );
			this.attack += 5;
			this.hp = 55;
			return true;
		}
		
		return false;
	}
}
