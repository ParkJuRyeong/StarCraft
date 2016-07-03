package Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Model.Battlecruiser;

//import com.kyh0209.Module;
//import com.tjoeun.pjr0916.MyModule;

import Model.Firebet;
import Model.Marine;
import Model.Unit;
import listener.OnDiedListener;

public class Controller {

	private static Scanner scanner = new Scanner(System.in);
	static List<Unit> unitList = new ArrayList<Unit>();	//�迭 <Marine>: ���׸�(Generics)
	static int mNum = 1;	//���� number
	static int fNum = 1;	//���̾�� number
	static int bNum = 1;	//��Ʋũ���� number

	public static void main(String[] args) {
/*
		Marine marine1   = new Marine("Marine1");	//hp 100 attack 70
		Firebet firebet1 = new Firebet("Firebet1");	//hp 100 attack 60
		
		firebet1.inform();
		marine1.attack(firebet1);
		marine1.attack(firebet1);
		marine1.attack(firebet1);
*/
		//List<Marine> mList = new ArrayList<Marine>();	//�迭 <Marine>: ���׸�(Generics)
		//List<Firebet> fList = new LinkedList<Firebet>();	//�����͸� �����س���... ���Ը� �ϰ� ����� ���� ���ٸ�...  LinkedList �� �� ����.
		//���׸��� �Ⱦ��� � Ÿ���̵� ������ �ִ�.
		//Class : Scanner , List -> �빮�ڷ� ����
		//Primitive : int, double -> �ҹ��ڷ� ����
		
		//Unit unit = new Unit(); : public abstract class Unit ������ ������ ���� �� ����. (��ü ���� ����) 
		//��Ӻ��� �������̽��� ���ٴ°� ������ ����
		
		/*
		 * ���� ������ �����Ѵ�.
		 * �̵�����
		 * ��ǥ���� 0,0 ~ 100,100
		 * ������ 0,0 ���� ����
		 * ���ֺ� ���ݻ�Ÿ��� �������ִ�.
		 * ������ 10������ , ���̾���� 5������ ������ ������ �� �ִ�.
		 * 1. ��ǥ ���䵵��
		 * 2. 0,0 ���� ����
		 * 3. ������ �̵��� �� �ֱ�
		 * 4. ������ �ڱ� ��Ÿ��ȿ� ���� ���ָ� ���ݰ���
		 * ������ ������ controller ���� ���� ����
		 * 5. ������ ��Ʋũ���� ���ݰ���. ���̾���� ���ݺҰ���
		 * 
		 * ����Ű
		 * alt + shift + m : �޼ҵ� ����
		 * alt + shift + l : �޼ҵ� ���ϰ� ���� ����
		 * F3 : �޼ҵ� �󼼷� �̵�
		 * library : ���� ȣ���ϴ� �� / framework : ���� ȣ�� ���ϴ� ��
		*/
/*		
		Module m = new Module();	//jar
		m.run();
		MyModule m2 = new MyModule();	//������Ʈ ���Ӽ��� ����
		m2.run();
*/		
		while (true) {
			
			System.out.println("--------------------");
			System.out.println("1. : ���� ����");
			System.out.println("2. : ���̾�� ����");
			System.out.println("3. : ��Ʋũ���� ����");
			System.out.println("4. : ���� ��Ȳ ����");
			System.out.println("5. : ���� �����ϱ�");
			System.out.println("�� �� ����");
			System.out.println("--------------------");
			
			try{
				int input = scanner.nextInt();
				
				switch (input){
				case 1 :	//TODO ���� ����
					markMarine();
					break;
				case 2 :	//TODO ���̾�� ����
					markFirebet();
					break;
				case 3 :	//TODO ��Ʋũ���� ����
					markBattlecruiser();
					break;
				case 4 :	//TODO ���� ��Ȳ ����
					if(unitCheck()){
						printUnitList();
					}
					break;
				case 5 :	//TODO ���� ���� �ϱ�
					if(unitCheck()){
						boolean choiceUnit = choiceUnit();
						if(choiceUnit){
							continue;
						}
					}
					break;
				default :
					return;
				}
			}catch(InputMismatchException e){
				System.out.println("���ڸ� �Է��ϼ���.");
				scanner.nextLine();
			}
		}
	}
	
	private static void markMarine() {
		Marine marine = new Marine("Marine" + mNum);
		System.out.println("Marine" + mNum + " ����.");
		mNum++;
		
		OnDiedListener onDiedListenerImplMarine = new OnDiedListener() {//�͸�Ŭ������ ���� ���ο� ��ü�� ����
			@Override
			public void onDied(Unit diedUnit) {
				// TODO Auto-generated method stub
				System.out.println(diedUnit.getName()+ " die.");
				unitList.remove(diedUnit);
			}
		};
		marine.setOnDiedListener(onDiedListenerImplMarine);
		unitList.add(marine);
	}
	
	private static void markFirebet() {
		Firebet firebet = new Firebet("Firebet" + fNum);
		System.out.println("Firebet" + fNum + " ����.");
		fNum++;
		
		OnDiedListener onDiedListenerImplFirebet = new OnDiedListener() {//�͸�Ŭ������ ���� ���ο� ��ü�� ����
			@Override
			public void onDied(Unit diedUnit) {
				// TODO Auto-generated method stub
				System.out.println(diedUnit.getName()+ " die.");
				unitList.remove(diedUnit);
			}
		};
		firebet.setOnDiedListener(onDiedListenerImplFirebet);
		unitList.add(firebet);
	}
	
	private static void markBattlecruiser() {
		Battlecruiser Battlecruiser = new Battlecruiser("Battlecruiser" + bNum);
		System.out.println("Battlecruise" + bNum + " ����.");
		bNum++;
		
		OnDiedListener onDiedListenerImplBattlecruiser = new OnDiedListener() {//�͸�Ŭ������ ���� ���ο� ��ü�� ����
			@Override
			public void onDied(Unit diedUnit) {
				// TODO Auto-generated method stub
				System.out.println(diedUnit.getName()+ " die.");
				unitList.remove(diedUnit);
			}
		};
		Battlecruiser.setOnDiedListener(onDiedListenerImplBattlecruiser);
		unitList.add(Battlecruiser);
	}
	
	private static void printUnitList() {
		for (Unit unit : unitList) {
			unit.inform();
		}
	}
	
	private static boolean choiceUnit() {
		int unitNum = 1;	//���� number ����
		System.out.println("������ �����ϼ���. ��Ҵ� 0");
		
		for (Unit unit : unitList) {
			unit.setNum(unitNum);
			System.out.print(unitNum + " : ");
			unit.inform();
			unitNum++;
		}
		int unitSelectedNum = scanner.nextInt();	//������ ���� number
		
		if(unitSelectedNum == 0) {
			return false;
			//continue;
		}else if(!inputCheck(unitList, unitSelectedNum)){
			return false;
			//continue;
		}
		
		int unitIdx = 0;// selectedUnit
		for (Unit unit : unitList) {
			if(unit.getNum() == unitSelectedNum){
				System.out.println(unit.getName() + " �����Ͽ����ϴ�.");
				unitIdx = unitList.indexOf(unit);
			}
		}
		postProcessSelectUnit(unitIdx);
		return true;
	}

	private static void postProcessSelectUnit (int selectedUnitIdx){
		
		System.out.println("--------------------");
		System.out.println("1. : �����ϱ�");
		System.out.println("2. : �̵��ϱ�");
		System.out.println("�� �� ���");
		System.out.println("--------------------");
		
		scanner = new Scanner(System.in);
		int input = 0;
		try {
			 input = scanner.nextInt();
		}catch(InputMismatchException e){
			System.out.println("���ڸ� �Է��ϼ���.");
		}
		
		switch (input){
			case 1 :	//TODO �����ϱ�
				attackUnit(selectedUnitIdx);
				break;
			case 2 :	//TODO �̵��ϱ�
				moveUnit(selectedUnitIdx);
				break;
			default :
				return;
		}
	}

	private static boolean attackUnit(int selectedUnitIdx) {
		List<Unit> attackUnitList = new ArrayList<Unit>();

		int attackUnitNum = 0;
		Unit selectdUnit = unitList.get(selectedUnitIdx);	//������ ����(��������)

		for (Unit unit : unitList) {
			if(unitList.indexOf(unit) != selectedUnitIdx && selectdUnit.isAttackable(unit)){
				attackUnitList.add(attackUnitNum, unit);
				attackUnitNum++;
				unit.setNum(attackUnitNum);
			}else{
				unit.setNum(0);
			}
		}
		
		if(attackUnitList.size() == 0){
			System.out.println("���ݰ����� ������ �����ϴ�.");
			return false;//break;
		}
		
		System.out.println("������ ������ �����ϼ���.");
		
		for (Unit unit : attackUnitList) {
				System.out.print(unit.getNum()+ " : ");
				unit.inform();
		}
		
		int attackSelectedNum = scanner.nextInt();	//������ ���� number
		
		if(inputCheck(attackUnitList, attackSelectedNum)){
			int attackUnitIdx = 0;	//selectedAttackUnit
			for (Unit unit : attackUnitList) {
				
				if(unit.getNum() == attackSelectedNum){
					attackUnitIdx = attackUnitList.indexOf(unit);
				}
			}
			unitList.get(selectedUnitIdx).unitAttack(attackUnitList.get(attackUnitIdx));
		}
		return true;
	}

	private static void moveUnit(int selectedUnitIdx) {
		System.out.println("�̵��� ��ǥ�� �Է� �ϼ���");
		System.out.println("X");
		int x = scanner.nextInt();
		System.out.println("Y");
		int y = scanner.nextInt();
		
		Unit unit = unitList.get(selectedUnitIdx);
		unit.move(x,y);
		System.out.println("�̵��� �����Ͽ����ϴ�.");
	}

	private static boolean unitCheck() {
		if(unitList.size() == 0){
			System.out.println("������ �����ϴ�.");
			return false;
		}else {
			return true;
		}	
	}
	
	private static boolean inputCheck(List<Unit> checkUnitList, int input) {
		if(!(input <= checkUnitList.size())){
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return false;
		}else{
			return true;
		}
	}
}