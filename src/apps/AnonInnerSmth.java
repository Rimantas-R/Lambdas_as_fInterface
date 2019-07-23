package apps;

import java.util.function.Consumer;

public class AnonInnerSmth {

	void doProces(Integer i, Consumer<Integer> consumer) {
		consumer.accept(i);
	};
	
	public static void main(String[] strings) {
		AnonInnerSmth smth = new AnonInnerSmth();
		
		smth.doProces(2, new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
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
		
	}

	private static String aboutMe() {
		// TODO Auto-generated method stub
		return "I'm static ";
	}
}
