package Model;

public class Marine extends Unit{

	public Marine(String name) {
		//마린이 생성 되기전 Unit 생성되어야함
		super(100, 60, name);	//super : Unit(int hp, int attack, String name) 호출
	}
	
	public void inform() {//재정의 : 오버라이드 / Unit에서 정의한 메소드를 Marine에서 다시 정의함 / 오른쪽 세모로 표시됨
		System.out.println(this.name + " 현재 위치는 " + this.x +"," + this.y +"입니다.");
		System.out.println();
	}
}
