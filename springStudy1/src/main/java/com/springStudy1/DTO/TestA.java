package com.springStudy1.DTO;

public class TestA {
	private TestB tb;
	private TestC tc;
	
	
	public void makeObject1() {
		// 강한 결합
		this.tb = new TestB();
	}// A객체를 만들 때 B객체가 생성 된 상태로 만들어진다.
	// 	다른 매게변수를 만들고 싶을 때, 한 쪽(Test B)가 새로 생성자메서드를 만들면
	//	 	한 쪽(TestA)도 내용변경이 필요하다
	// 	한 쪽이 삭제되는 내용이 있다면 다른 내용도 삭제됨 

	public void makeObject1(int num, String name) {
		this.tb = new TestB(num, name);
	}

	public void makeObject1(int num) {
		this.tb = new TestB(num);
	}

////////
	public void makeObject2(TestC tc){
		//약한 결합
		this.tc = tc;
}



}
	
	