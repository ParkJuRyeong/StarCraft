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
		//List<Marine> mList = new ArrayList<Marine>();	//�迭 <Marine>: ���׸�(Generics)
		//List<Firebet> fList = new LinkedList<Firebet>();	//�����͸� �����س���... ���Ը� �ϰ� ����� ���� ���ٸ�...  LinkedList �� �� ����.
		//���׸��� �Ⱦ��� � Ÿ���̵� ������ �ִ�.
		List<Unit> list = new ArrayList<Unit>();	//�迭 <Marine>: ���׸�(Generics)
		
		Scanner scanner   = new Scanner(System.in);
		
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
		System.out.println("���� ���� : 1");
		System.out.println("���̾�� ���� : 2");
		System.out.println("���� ��Ȳ ���� : 3");
		System.out.println("�����̵�(x,y)  : 4");
		
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
				System.out.println(list.size() + "����");
				
				for(int i=0; i<list.size(); i++) {
					Unit unit = list.get(i);
					unit.inform();
				}
				
				break;
			case 4 :
				System.out.println("������ �����ϼ���");
				int idx = scanner.nextInt();
				
				if(idx == -1) {
					continue;
				}
				
				//Unit selUnit = list.get(idx);
				System.out.println("�̵��� ��ǥ�� �Է� �ϼ���");
				//String xy = scanner.nextLine();
				//System.out.println(xy);
				
				break;
			}
		
		}
	}

}
