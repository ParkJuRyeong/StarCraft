package Controller;

import javax.management.RuntimeErrorException;

import Model.FirebatTest;
import Model.MarineTest;

public class ControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 2016.06.18 �ǽ� 3����
		 * 
		 * ��������. 
		 * ������ ������ �����ϰԲ�...
		 * �׷��� ������ ������ �پ��...
		 * ���̾�� ����
		 * ���̾���� ������ �����Ҽ���... ������ ���̾������Ҽ���
		 * 
		 * ������ ��� / �Լ��� ����
		 * 
		 * ctrl + shift + O : import
		 * 
		 * 
		 * 2016.06.19 �ǽ�4����
		 * ĸ��ȭ 
		 * ���������� : public / private
		 * alt + shift + s + r : set/get ����
		 * 
		*/
		
		MarineTest marine1 = new MarineTest(100, 20);
		MarineTest marine2 = new MarineTest(100, 30);
		
//		marine1.setHp(50);
//		System.out.println(marine1.getHp());
//		marine1.getHp();
		
		FirebatTest firebat1 = new FirebatTest(120, 40);
		FirebatTest firebat2 = new FirebatTest(120, 50);
		
		marine1.attack("marine1", marine2.attack);

		marine2.attack("marine2", marine1.attack);
		
		marine1.attack("marine1", marine2.attack);	
		
		marine1.attack("marine1", marine2.attack);
		
		marine1.attack("marine1", marine2.attack);
		
		firebat1.attack("firebat1", marine2.attack);

		firebat1.attack("firebat1", firebat2.attack);
		
		firebat1.attack("firebat1", firebat2.attack);

	}
}