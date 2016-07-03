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
	static List<Unit> unitList = new ArrayList<Unit>();	//배열 <Marine>: 제네릭(Generics)
	static int mNum = 1;	//마린 number
	static int fNum = 1;	//파이어뱃 number
	static int bNum = 1;	//배틀크루저 number

	public static void main(String[] args) {
/*
		Marine marine1   = new Marine("Marine1");	//hp 100 attack 70
		Firebet firebet1 = new Firebet("Firebet1");	//hp 100 attack 60
		
		firebet1.inform();
		marine1.attack(firebet1);
		marine1.attack(firebet1);
		marine1.attack(firebet1);
*/
		//List<Marine> mList = new ArrayList<Marine>();	//배열 <Marine>: 제네릭(Generics)
		//List<Firebet> fList = new LinkedList<Firebet>();	//데이터를 연결해놓은... 삽입만 하고 출력할 일이 없다면...  LinkedList 가 더 좋다.
		//제네릭을 안쓰면 어떤 타입이든 넣을수 있다.
		//Class : Scanner , List -> 대문자로 시작
		//Primitive : int, double -> 소문자로 시작
		
		//Unit unit = new Unit(); : public abstract class Unit 설정시 유닛을 만들 수 없다. (객체 생성 못함) 
		//상속보다 인터페이스가 좋다는게 설계적 관점
		
		/*
		 * 누가 누구를 공격한다.
		 * 이동가능
		 * 좌표개념 0,0 ~ 100,100
		 * 유닛은 0,0 에서 생성
		 * 유닛별 공격사거리가 정해져있다.
		 * 마린은 10이하인 , 파이어뱃은 5이하인 유닛을 공격할 수 있다.
		 * 1. 좌표 개념도입
		 * 2. 0,0 에서 생성
		 * 3. 유닛이 이동할 수 있기
		 * 4. 유닛은 자기 사거리안에 들어온 유닛만 공격가능
		 * 유닛이 죽으면 controller 에게 전달 해줌
		 * 5. 마린은 배틀크루저 공격가능. 파이어뱃은 공격불가능
		 * 
		 * 단축키
		 * alt + shift + m : 메소드 생성
		 * alt + shift + l : 메소드 리턴값 변수 생성
		 * F3 : 메소드 상세로 이동
		 * library : 내가 호출하는 것 / framework : 내가 호출 당하는 것
		*/
/*		
		Module m = new Module();	//jar
		m.run();
		MyModule m2 = new MyModule();	//프로젝트 종속성이 생김
		m2.run();
*/		
		while (true) {
			
			System.out.println("--------------------");
			System.out.println("1. : 마린 생성");
			System.out.println("2. : 파이어뱃 생성");
			System.out.println("3. : 배틀크루저 생성");
			System.out.println("4. : 유닛 현황 보기");
			System.out.println("5. : 유닉 선택하기");
			System.out.println("그 외 종료");
			System.out.println("--------------------");
			
			try{
				int input = scanner.nextInt();
				
				switch (input){
				case 1 :	//TODO 마린 생성
					markMarine();
					break;
				case 2 :	//TODO 파이어뱃 생성
					markFirebet();
					break;
				case 3 :	//TODO 배틀크루저 생성
					markBattlecruiser();
					break;
				case 4 :	//TODO 유닛 현황 보기
					if(unitCheck()){
						printUnitList();
					}
					break;
				case 5 :	//TODO 유닛 선택 하기
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
				System.out.println("숫자만 입력하세요.");
				scanner.nextLine();
			}
		}
	}
	
	private static void markMarine() {
		Marine marine = new Marine("Marine" + mNum);
		System.out.println("Marine" + mNum + " 생성.");
		mNum++;
		
		OnDiedListener onDiedListenerImplMarine = new OnDiedListener() {//익명클래스를 만들어서 새로운 객체를 생성
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
		System.out.println("Firebet" + fNum + " 생성.");
		fNum++;
		
		OnDiedListener onDiedListenerImplFirebet = new OnDiedListener() {//익명클래스를 만들어서 새로운 객체를 생성
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
		System.out.println("Battlecruise" + bNum + " 생성.");
		bNum++;
		
		OnDiedListener onDiedListenerImplBattlecruiser = new OnDiedListener() {//익명클래스를 만들어서 새로운 객체를 생성
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
		int unitNum = 1;	//유닛 number 생성
		System.out.println("유닛을 선택하세요. 취소는 0");
		
		for (Unit unit : unitList) {
			unit.setNum(unitNum);
			System.out.print(unitNum + " : ");
			unit.inform();
			unitNum++;
		}
		int unitSelectedNum = scanner.nextInt();	//선택한 유닛 number
		
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
				System.out.println(unit.getName() + " 선택하였습니다.");
				unitIdx = unitList.indexOf(unit);
			}
		}
		postProcessSelectUnit(unitIdx);
		return true;
	}

	private static void postProcessSelectUnit (int selectedUnitIdx){
		
		System.out.println("--------------------");
		System.out.println("1. : 공격하기");
		System.out.println("2. : 이동하기");
		System.out.println("그 외 취소");
		System.out.println("--------------------");
		
		scanner = new Scanner(System.in);
		int input = 0;
		try {
			 input = scanner.nextInt();
		}catch(InputMismatchException e){
			System.out.println("숫자만 입력하세요.");
		}
		
		switch (input){
			case 1 :	//TODO 공격하기
				attackUnit(selectedUnitIdx);
				break;
			case 2 :	//TODO 이동하기
				moveUnit(selectedUnitIdx);
				break;
			default :
				return;
		}
	}

	private static boolean attackUnit(int selectedUnitIdx) {
		List<Unit> attackUnitList = new ArrayList<Unit>();

		int attackUnitNum = 0;
		Unit selectdUnit = unitList.get(selectedUnitIdx);	//선택한 유닛(공격유닛)

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
			System.out.println("공격가능한 유닛이 없습니다.");
			return false;//break;
		}
		
		System.out.println("공격할 유닛을 선택하세요.");
		
		for (Unit unit : attackUnitList) {
				System.out.print(unit.getNum()+ " : ");
				unit.inform();
		}
		
		int attackSelectedNum = scanner.nextInt();	//공격할 유닛 number
		
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
		System.out.println("이동할 좌표를 입력 하세요");
		System.out.println("X");
		int x = scanner.nextInt();
		System.out.println("Y");
		int y = scanner.nextInt();
		
		Unit unit = unitList.get(selectedUnitIdx);
		unit.move(x,y);
		System.out.println("이동에 성공하였습니다.");
	}

	private static boolean unitCheck() {
		if(unitList.size() == 0){
			System.out.println("유닛이 없습니다.");
			return false;
		}else {
			return true;
		}	
	}
	
	private static boolean inputCheck(List<Unit> checkUnitList, int input) {
		if(!(input <= checkUnitList.size())){
			System.out.println("잘못 입력하였습니다.");
			return false;
		}else{
			return true;
		}
	}
}