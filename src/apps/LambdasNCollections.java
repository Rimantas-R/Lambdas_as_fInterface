package apps;

import java.util.Arrays;
import java.util.List;

import apps.models.Person;

public class LambdasNCollections {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person(1,"Peet","Stomach"),
				new Person(2,"Meet","Atomach"),
				new Person(3,"Pheel","Mitomach"),
				new Person(4,"Peetuh","Storch"),
				new Person(5,"Art","Mach")
				);
		System.out.println("----------------------");
	
		persons.stream().forEach(System.out::println);
		
		System.out.println("----------------------");

		persons.parallelStream().forEach(System.out::println);
		
		System.out.println("----------------------");

		persons.forEach(System.out::println);

	}
}
