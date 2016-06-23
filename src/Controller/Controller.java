package Controller;

import Model.Firebet;
import Model.Marine;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marine marine1   = new Marine("Marine1");	//hp 100 attack 70
		Firebet firebet1 = new Firebet("Firebet1");	//hp 100 attack 60
		
		firebet1.inform();
		marine1.attack(firebet1);
		marine1.attack(firebet1);
		marine1.attack(firebet1);
		
	}

}
