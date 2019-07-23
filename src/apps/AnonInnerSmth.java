package apps;

import java.util.function.Consumer;

public class AnonInnerSmth {
	
	void wrap(Integer ii) {
		doProces(ii, i -> {
			System.out.println("ii iis: " + i);
			System.out.println(this);
		});
	}

	<T> void  doProces(T i, Consumer<T> consumer) {
		consumer.accept(i);
	};
	
	public static void main(String[] strings) {
		AnonInnerSmth smth = new AnonInnerSmth();
		
		smth.doProces(2, new Consumer<Integer>() {

			@Override
			public  void accept(Integer i) {
				System.out.println("i is: " + i);
				System.out.println(this);
				System.out.println(aboutMe());
			}
			
			public String toString() {
				return "Tis is tis";
			}
			
			public String aboutMe() {
				return "Me is anonymous ";
			}
			
		});
		
		smth.doProces(3, (i) -> {
			System.out.println("i again is: " + i);
			System.out.println(aboutMe());
		});
		
		smth.doProces(3, System.out::println);
		
		smth.wrap(15);
		
	}
	
	public String toString() {
		return "I'm instance of  AnonInnerSmth";
	}

	private static String aboutMe() {
		return "I'm static ";
	}
}
