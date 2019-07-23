package apps;

public class DupeDefaultInterfaceMethods {
	
	public void goDDIF() {System.out.println("goddif");}
	
	public static void goDDIFs() {System.out.println("staticGoDDIF");}

interface FirstAbility {
    public default boolean doSomething() {
        return true;
    }
    
    default void ok() {System.out.println("ok1");}
}

interface SecondAbility {
    public default boolean doSomething() {
        return false;
    }
    
    default void ok() {System.out.println("ok2");}
}

class Dupe implements FirstAbility, SecondAbility {

	@Override
	public boolean doSomething() {
		return FirstAbility.super.doSomething();
	}

	@Override
	public void ok() {
		SecondAbility.super.ok();
	}
    
}

public static void main(String[] args) {
    DupeDefaultInterfaceMethods ddif = new DupeDefaultInterfaceMethods();
    Dupe dupe = ddif.new Dupe();
    ddif.goDDIF();
    System.out.println(dupe.doSomething());
    dupe.ok();
   

    }
}