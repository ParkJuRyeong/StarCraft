package Controller;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Model.Firebet;
import Model.Marine;
import Model.Unit;

public class Controller {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		List<Unit> unitList = new ArrayList<Unit>();	//�迭 <Marine>: ���׸�(Generics)
		Scanner scanner = new Scanner(System.in);
		
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
		*/
		
		int mNum = 1;	//���� number
		int fNum = 1;	//���̾�� number
		
		while (true) {
			System.out.println("--------------------");
			System.out.println("1. : ���� ����");
			System.out.println("2. : ���̾�� ����");
			System.out.println("3. : ���� ��Ȳ ����");
			System.out.println("4. : ���� �����ϱ�");
			System.out.println("�� �� ����");
			System.out.println("--------------------");
			
			int input = scanner.nextInt();
			
			switch (input){
			case 1 :	//���� ����
				Marine marine = new Marine("Marine" + mNum);
				unitList.add(marine);
				System.out.println("Marine" + mNum + " ����.");
				mNum++;
				break;
			case 2 :	//���̾�� ����
				Firebet firebet = new Firebet("Firebet" + fNum);
				unitList.add(firebet);
				System.out.println("Firebet" + fNum + " ����.");
				fNum++;
				break;
			case 3 :	//���� ��Ȳ ����
				if(unitCheck(unitList)){
					int mCount = 0;	//����
					int fCount = 0;	//���̾��
					for (Unit unit : unitList) {
						unit.inform();
						/*
						if(unit.getName().startsWith("Marine")){
							mCount++;
						}else{
							fCount++;
						}
						*/
					}
//					/System.out.println("�� : " + (mCount+fCount) + "���� (" + "����: " + mCount +" / ���̾�� : " + fCount+ ")");
				}
				break;
			case 4 :	//���� ���� �ϱ�
				if(unitCheck(unitList)){
					int unitNum = 1;	//���� number ����
					System.out.println("������ �����ϼ���. ��Ҵ� 0");
					
					for (Unit unit : unitList) {
						if(unit.getHp() > 0){
							unit.setNum(unitNum);
							System.out.print(unitNum + " : ");
							unit.inform();
							unitNum++;
						}else {
							unit.setNum(0);
						}
					}
					int unitSelectedNum = scanner.nextInt();	//������ ���� number
					
					if(unitSelectedNum == 0) {
						continue;
					}else if(!(unitSelectedNum <= unitList.size())){
						System.out.println("�߸� �Է��Ͽ����ϴ�.");
						continue;
					}
					
					int unitIdx = 0;// selectedUnit
					for (Unit unit : unitList) {
						if(unit.getNum() == unitSelectedNum){
							System.out.println(unit.getName() + " �����Ͽ����ϴ�.");
							unitIdx = unitList.indexOf(unit);
						}
					}
					selectedUnit(unitIdx, unitList);
				}
				break;
			default :
				return;
			}
		}
	}
	
	private static void selectedUnit (int selectedUnitIdx, List<Unit> unitList){
		System.out.println("--------------------");
		System.out.println("1. : �����ϱ�");
		System.out.println("2. : �̵��ϱ�");
		System.out.println("�� �� ���");
		System.out.println("--------------------");
		
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch (input){
			case 1 :
				List<Unit> attackUnitList = new ArrayList<Unit>();

				int attackUnitNum = 0;
				Unit selectdUnit = unitList.get(selectedUnitIdx);	//������ ����(��������)
			
				for (Unit unit : unitList) {
					if(unit.getHp() > 0){
						if(unitList.indexOf(unit) != selectedUnitIdx && selectdUnit.isAttackable(unit)){
							attackUnitList.add(attackUnitNum, unit);
							attackUnitNum++;
							unit.setNum(attackUnitNum);
						}else{
							unit.setNum(0);
						}
					}
				}
				
				if(attackUnitList.size() == 0){
					System.out.println("���ݰ����� ������ �����ϴ�.");
					break;
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
					unitList.get(selectedUnitIdx).attack(attackUnitList.get(attackUnitIdx));
				}
				break;
			case 2 :
				System.out.println("�̵��� ��ǥ�� �Է� �ϼ���");
				System.out.println("X");
				int x = scanner.nextInt();
				System.out.println("Y");
				int y = scanner.nextInt();
				
				Unit unit = unitList.get(selectedUnitIdx);
				unit.moveUnit(x,y);
				System.out.println("�̵��� �����Ͽ����ϴ�.");
				break;
			default :
				return;
		}
	}
	
	private static boolean unitCheck(List<Unit> unitList) {
		if(unitList.size() == 0){
			System.out.println("������ �����ϴ�.");
			return false;
		}else {
			return true;
		}	
	}
	
	private static boolean inputCheck(List<Unit> unitList, int input) {
		if(!(input <= unitList.size())){
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return false;
		}else{
			return true;
		}
	}
}