package fp_java.ch01.anonymousclass;

public class Main {
	
	// nested class = 클래스 내부에 있는 클래스
	// private protected 등 다 가능
	public static class SubMain {
		
	}
	
	public static void main(String[] args) {
		
		
		Main main = new Main();
		// fp_java.ch01.anonymousclass.Main@1f32e575
		System.out.println(main);
		
		// fp_java.ch01.anonymousclass.Main$SubMain@2ff4acd0
		// 이름이 있기 때문에 $+이름
		SubMain submain = new SubMain();
		System.out.println(submain);
		
		
		// 인터페이스에 있던 메소드 구현 -> 이름없는 클래스, 익명클래스 구현
		Computable computer = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		
		// fp_java.ch01.anonymousclass.Main$1@27716f4
		// 이름이 없기 때문에 $1
		System.out.println(computer); 
		
		
		Computable computer2 = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		// fp_java.ch01.anonymousclass.Main$2@2a84aee7
		// 이름이 없기 때문에 $2
		System.out.println(computer2); 
		
		
		Computable computer3 = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		System.out.println(computer3); 
		
		
	}

}
