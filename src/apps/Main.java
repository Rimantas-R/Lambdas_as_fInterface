package apps;

public class Main implements Third{
	
	

	public static void main(String[] args) {

		Sec sec = ()-> System.out.println("Second Goes!");;
		sec.doIt();
		sec.goGo();
		
		First f = () -> System.out.println("Ok first GoEs");
		
		System.out.println(f);
	
	//f.doIt();
	f.goGo();
	f= ()-> System.out.println(sec);
	System.out.println(f);


	//String okS = "Smth ok";
		  Third th = (okS)->okS + " o boy"; 
		  System.out.println(th.doItThird());
		  System.out.println(th.say("Here you go"));
		 	
	
	System.out.println(new Main().say("ok"));
	
	
	}

	@Override
	public String say(String string) {
		
		return "default third string";
	}

	

}

@FunctionalInterface
interface First{
	//default void doIt() {System.out.println("first doIt");};
	
	void goGo();
}

@FunctionalInterface
interface Sec{
	default void doIt() {
		System.out.println("sec doIt");
	}
	
	void goGo();
}

interface Third{
	default String doItThird() {return "third Does";}
	
	String say(String string);
	
}
