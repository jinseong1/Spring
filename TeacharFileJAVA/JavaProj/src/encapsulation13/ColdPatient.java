package encapsulation13;

public class ColdPatient {
	/*=======캡술화 전============*/
	/*
	//멤버변수]
	SneezeCap sneeze   = new SneezeCap();
	SniffleCap sniffle = new SniffleCap();
	SnivelCap snivel   = new SnivelCap();
	//멤버메소드]
	void take() {
		//복용순서가 중요하다]
		//콧물 ->기침->재채기
		snivel.take();
		sniffle.take();
		sneeze.take();		
	}*/
	/*===========캡술화 후============*/
	//멤버변수]
	Contack600 contack600=new Contack600();
	//멤버 메소드]
	void take() {
		contack600.take();
	}
}
