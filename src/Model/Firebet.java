package Model;

public class Firebet extends Unit{

	public Firebet(String name) {
		super(50, 25, name, 5);
	}
	
	public boolean upgrade() {
		if(this.level == 1 && this.exp >= 50){
			this.level += 1;
			this.exp -= 50;
			System.out.println("[" + this.name +"]" + " Level " + this.level + " Upgrade" );
			this.attack += 3;
			this.hp = 55;
			return true;
		}else if(this.level == 2 && this.exp >= 100){
			this.level += 1;
			this.exp -= 100;
			System.out.println("[" + this.name +"]" + " Level " + this.level + " Upgrade" );
			this.attack += 5;
			this.hp = 65;
			return true;
		}
		
		return false;
	}
	
}
