package Controller;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import Model.Firebet;
import Model.Location;
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
		
		int mNum = 1;
		int fNum = 1;
		
		while (true) {
			System.out.println("--------------------");
			System.out.println("1 : 마린 생성");
			System.out.println("2 : 파이어뱃 생성");
			System.out.println("3 : 유닛 현황 보기");
			System.out.println("4 : 유닉 선택하기");
			System.out.println("그 외 종료");
			System.out.println("--------------------");
			
			int input = scanner.nextInt();
			
			switch (input){
			case 1 :
				Marine marine = new Marine("Marine" + mNum);
				unitList.add(marine);
				System.out.println("Marine" + mNum + " 생성.");
				mNum++;
				break;
			case 2 :
				Firebet firebet = new Firebet("Firebet" + fNum);
				unitList.add(firebet);
				System.out.println("Firebet" + fNum + " 생성.");
				fNum++;
				break;
			case 3 :
				for (Unit unit : unitList) {
					unit.inform();
				}
				//System.out.println(unitList.size() + "마리");
				break;
			case 4 :
				if(unitList.size() == 0){
					System.out.println("유닛이 없습니다.");
					continue;
				}
				
				System.out.println("유닛을 선택하세요. 취소는 -1");
				for (Unit unit : unitList) {
					System.out.print(unitList.indexOf(unit) + " : ");
					unit.inform();
				}
				
				int idx = scanner.nextInt();
				
				if(idx == -1) {
					continue;
				}
				
				System.out.println(unitList.get(idx).getName() + " 선택하였습니다.");
				selectUnit(idx, unitList);
				
				break;
			default :
				return;
			}
		}
	}
	
	private static void selectUnit (int idx, List<Unit> unitList){
		System.out.println("1 : 공격하기");
		System.out.println("2 : 이동하기");
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch (input){
			case 1 :
				//공격할 유닛은 공격범위 안에 있는 list 출력 -> 공격가능한 유닛 list 찾기
				if(unitList.size() == 1){
					System.out.println("공격할 유닛이 없습니다.");
					break;
				}
				System.out.println("공격할 유닛을 선택하세요.");
				for (Unit unit : unitList) {
					if(unitList.indexOf(unit) != idx){
						System.out.print(unitList.indexOf(unit) + " : ");
						unit.inform();
					}
				}
				
				int attackIdx = scanner.nextInt();
				//selecedtUnit.get(idx).attack(selecedtUnit.get(attackIdx));
				//unitList.get(idx).getX();
				//unitList.get(idx).getY();
				//System.out.println(unitList.get(idx).getLoc());
				
				break;
			case 2 :
				System.out.println("이동할 좌표를 입력 하세요");
				System.out.println("X");
				
				int x = scanner.nextInt();
				System.out.println("Y");
				int y = scanner.nextInt();
				
				Unit unit = unitList.get(idx);
				System.out.println(unit.getName());
				
				unit.moveUnit(x,y);
				//System.out.println("이동에 성공하였습니다.");
				break;
			default :
				return;
		}
	}
}
	
