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
		
		int mNum = 1;
		int fNum = 1;
		
		while (true) {
			System.out.println("--------------------");
			System.out.println("1 : ���� ����");
			System.out.println("2 : ���̾�� ����");
			System.out.println("3 : ���� ��Ȳ ����");
			System.out.println("4 : ���� �����ϱ�");
			System.out.println("�� �� ����");
			System.out.println("--------------------");
			
			int input = scanner.nextInt();
			
			switch (input){
			case 1 :
				Marine marine = new Marine("Marine" + mNum);
				unitList.add(marine);
				System.out.println("Marine" + mNum + " ����.");
				mNum++;
				break;
			case 2 :
				Firebet firebet = new Firebet("Firebet" + fNum);
				unitList.add(firebet);
				System.out.println("Firebet" + fNum + " ����.");
				fNum++;
				break;
			case 3 :
				for (Unit unit : unitList) {
					unit.inform();
				}
				//System.out.println(unitList.size() + "����");
				break;
			case 4 :
				if(unitList.size() == 0){
					System.out.println("������ �����ϴ�.");
					continue;
				}
				
				System.out.println("������ �����ϼ���. ��Ҵ� -1");
				for (Unit unit : unitList) {
					System.out.print(unitList.indexOf(unit) + " : ");
					unit.inform();
				}
				
				int idx = scanner.nextInt();
				
				if(idx == -1) {
					continue;
				}
				
				System.out.println(unitList.get(idx).getName() + " �����Ͽ����ϴ�.");
				selectUnit(idx, unitList);
				
				break;
			default :
				return;
			}
		}
	}
	
	private static void selectUnit (int idx, List<Unit> unitList){
		System.out.println("1 : �����ϱ�");
		System.out.println("2 : �̵��ϱ�");
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch (input){
			case 1 :
				//������ ������ ���ݹ��� �ȿ� �ִ� list ��� -> ���ݰ����� ���� list ã��
				if(unitList.size() == 1){
					System.out.println("������ ������ �����ϴ�.");
					break;
				}
				System.out.println("������ ������ �����ϼ���.");
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
				System.out.println("�̵��� ��ǥ�� �Է� �ϼ���");
				System.out.println("X");
				
				int x = scanner.nextInt();
				System.out.println("Y");
				int y = scanner.nextInt();
				
				Unit unit = unitList.get(idx);
				System.out.println(unit.getName());
				
				unit.moveUnit(x,y);
				//System.out.println("�̵��� �����Ͽ����ϴ�.");
				break;
			default :
				return;
		}
	}
}
	
