package Controller;

import Model.Firebet;
import Model.Marine;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marine marine = new Marine();
		//marine.inform();
		Firebet firebet = new Firebet();
		
		firebet.setHp(marine.attack(firebet));
		firebet.setHp(marine.attack(firebet));
		firebet.setHp(marine.attack(firebet));
		//marine.inform();
	}

}
