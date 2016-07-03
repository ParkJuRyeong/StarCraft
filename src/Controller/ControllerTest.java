package Controller;

import javax.management.RuntimeErrorException;

import Model.FirebatTest;
import Model.MarineTest;

public class ControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 2016.06.18 실습 3주차
		 * 
		 * 마린생성. 
		 * 마린이 마린을 공격하게끔...
		 * 그러면 마린은 생명이 줄어들어서...
		 * 파이어뱃 생성
		 * 파이어뱃이 마린을 공격할수도... 마린이 파이어뱃공격할수도
		 * 
		 * 변수는 명사 / 함수는 동사
		 * 
		 * ctrl + shift + O : import
		 * 
		 * 
		 * 2016.06.19 실습4주차
		 * 캡슐화 
		 * 접근제어자 : public / private
		 * alt + shift + s + r : set/get 생성
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