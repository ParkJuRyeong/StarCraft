package Model;

public class Marine extends Unit{

	public Marine() {
		//마린이 생성 되기전 Unit 생성되어야함
		super(100, 30, "Marine");	//super : Unit(int hp) 호출
	}
	
	
}
