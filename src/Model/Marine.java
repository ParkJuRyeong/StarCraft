package Model;

public class Marine extends Unit{

	public Marine(String name) {
		//������ ���� �Ǳ��� Unit �����Ǿ����
		super(100, 60, name);	//super : Unit(int hp, int attack, String name) ȣ��
	}
	
	public void inform() {//������ : �������̵� / Unit���� ������ �޼ҵ带 Marine���� �ٽ� ������ / ������ ����� ǥ�õ�
		System.out.println(this.name + " ���� ��ġ�� " + this.x +"," + this.y +"�Դϴ�.");
		System.out.println();
	}
}
