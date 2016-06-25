package Controller;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Model.Firebet;
import Model.Marine;
import Model.Unit;

public class Controller {

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
		List<Unit> list = new ArrayList<Unit>();	//배열 <Marine>: 제네릭(Generics)
		
		Scanner scanner   = new Scanner(System.in);
		
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
		System.out.println("마린 생성 : 1");
		System.out.println("파이어뱃 생성 : 2");
		System.out.println("유닛 현황 보기 : 3");
		System.out.println("유닛이동(x,y)  : 4");
		
		int mNum = 1;
		int fNum = 1;
		Marine marine = new Marine("Marine" + mNum);
		Firebet firebet = new Firebet("Firebet" + fNum);
		
		while (true) {
			int input = scanner.nextInt();
			
			switch (input){
			case 1 :
				//Marine marine = new Marine("Marine" + mNum);
				list.add(marine);
				mNum++;
				break;
			case 2 :
				//Firebet firebet = new Firebet("Firebet" + fNum);
				list.add(firebet);
				fNum++;
				break;
			case 3 :
				System.out.println(list.size() + "마리");
				
				for(int i=0; i<list.size(); i++) {
					Unit unit = list.get(i);
					unit.inform();
				}
				
				break;
			case 4 :
				System.out.println("유닛을 선택하세요");
				int idx = scanner.nextInt();
				
				if(idx == -1) {
					continue;
				}
				
				//Unit selUnit = list.get(idx);
				System.out.println("이동할 좌표를 입력 하세요");
				//String xy = scanner.nextLine();
				//System.out.println(xy);
				
				break;
			}
		
		}
	}

}
