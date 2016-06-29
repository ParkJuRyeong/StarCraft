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
		//List<Marine> mList = new ArrayList<Marine>();	//배열 <Marine>: 제네릭(Generics)
		//List<Firebet> fList = new LinkedList<Firebet>();	//데이터를 연결해놓은... 삽입만 하고 출력할 일이 없다면...  LinkedList 가 더 좋다.
		//제네릭을 안쓰면 어떤 타입이든 넣을수 있다.
		//Class : Scanner , List -> 대문자로 시작
		//Primitive : int, double -> 소문자로 시작
		
		List<Unit> unitList = new ArrayList<Unit>();	//배열 <Marine>: 제네릭(Generics)
		Scanner scanner = new Scanner(System.in);
		
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
		*/
		
		int mNum = 1;	//마린 number
		int fNum = 1;	//파이어뱃 number
		
		while (true) {
			System.out.println("--------------------");
			System.out.println("1. : 마린 생성");
			System.out.println("2. : 파이어뱃 생성");
			System.out.println("3. : 유닛 현황 보기");
			System.out.println("4. : 유닉 선택하기");
			System.out.println("그 외 종료");
			System.out.println("--------------------");
			
			int input = scanner.nextInt();
			
			switch (input){
			case 1 :	//마린 생성
				Marine marine = new Marine("Marine" + mNum);
				unitList.add(marine);
				System.out.println("Marine" + mNum + " 생성.");
				mNum++;
				break;
			case 2 :	//파이어뱃 생성
				Firebet firebet = new Firebet("Firebet" + fNum);
				unitList.add(firebet);
				System.out.println("Firebet" + fNum + " 생성.");
				fNum++;
				break;
			case 3 :	//유닛 현황 보기
				if(unitCheck(unitList)){
					int mCount = 0;	//마린
					int fCount = 0;	//파이어뱃
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
//					/System.out.println("총 : " + (mCount+fCount) + "마리 (" + "마린: " + mCount +" / 파이어뱃 : " + fCount+ ")");
				}
				break;
			case 4 :	//유닛 선택 하기
				if(unitCheck(unitList)){
					int unitNum = 1;	//유닛 number 생성
					System.out.println("유닛을 선택하세요. 취소는 0");
					
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
					int unitSelectedNum = scanner.nextInt();	//선택한 유닛 number
					
					if(unitSelectedNum == 0) {
						continue;
					}else if(!(unitSelectedNum <= unitList.size())){
						System.out.println("잘못 입력하였습니다.");
						continue;
					}
					
					int unitIdx = 0;// selectedUnit
					for (Unit unit : unitList) {
						if(unit.getNum() == unitSelectedNum){
							System.out.println(unit.getName() + " 선택하였습니다.");
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
		System.out.println("1. : 공격하기");
		System.out.println("2. : 이동하기");
		System.out.println("그 외 취소");
		System.out.println("--------------------");
		
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch (input){
			case 1 :
				List<Unit> attackUnitList = new ArrayList<Unit>();

				int attackUnitNum = 0;
				Unit selectdUnit = unitList.get(selectedUnitIdx);	//선택한 유닛(공격유닛)
			
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
					System.out.println("공격가능한 유닛이 없습니다.");
					break;
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
					unitList.get(selectedUnitIdx).attack(attackUnitList.get(attackUnitIdx));
				}
				break;
			case 2 :
				System.out.println("이동할 좌표를 입력 하세요");
				System.out.println("X");
				int x = scanner.nextInt();
				System.out.println("Y");
				int y = scanner.nextInt();
				
				Unit unit = unitList.get(selectedUnitIdx);
				unit.moveUnit(x,y);
				System.out.println("이동에 성공하였습니다.");
				break;
			default :
				return;
		}
	}
	
	private static boolean unitCheck(List<Unit> unitList) {
		if(unitList.size() == 0){
			System.out.println("유닛이 없습니다.");
			return false;
		}else {
			return true;
		}	
	}
	
	private static boolean inputCheck(List<Unit> unitList, int input) {
		if(!(input <= unitList.size())){
			System.out.println("잘못 입력하였습니다.");
			return false;
		}else{
			return true;
		}
	}
}