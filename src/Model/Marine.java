package Model;

public class Marine extends Unit{

	public Marine(String name) {
		//마린이 생성 되기전 Unit 생성되어야함
		super(100, 60, name);	//super : Unit(int hp, int attack, String name) 호출
	}
	
}
