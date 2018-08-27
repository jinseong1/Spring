package encapsulation13;

public class Contack600 {
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
	}

}
