package Model;

public class Unit {

	protected int hp;	//�ڽĵ��� �����Ҽ� �ִ�. : �������� hp ���� ���� but controller���� ���ٰ��� �Ұ�
	
	public Unit(int hp) {
		this.hp = hp;
	}
	
	public void inform() {
		System.out.println(hp);
	}
	
}
