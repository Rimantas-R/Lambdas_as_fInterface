package apps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import apps.models.Person;

public class LambdasNCollections {

//	@FunctionalInterface
//	public interface Criteria {
//
//		 String a(Person b);
//	}

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person(1, "Peet", "Stomach"), new Person(2, "Meet", "Atomach"),
				new Person(3, "Pheel", "Mitomach"), new Person(4, "Peet", "Storch"), new Person(5, "Art", "Mach"));
		System.out.println("----------------------");

		persons.stream().forEach(System.out::println);

		System.out.println("----------------------");

		persons.parallelStream().filter(p -> p.getName().charAt(1) == 'e').forEach(System.out::println);

		System.out.println("----------------------");

		persons.forEach(System.out::println);

		System.out.println("----------------------");

		Function<Person, String> parameter = p -> p.getName();
		List<Person> newPersons = sortCustom(persons, parameter);
		newPersons.forEach(System.out::println);
		System.out.println("----------------------");
		Function crit = new Function() {

			@Override
			public String apply(Object p) {
				return ((Person) p).getSurname();
			}
			
		};

		List<Person> newPersons2 = sortCustom(persons, crit);
		newPersons2.forEach(System.out::println);
	}

	/**
	 * @param persons
	 * @return
	 */
	private static List<Person> sortCustom(List<Person> persons, Function<Person, String> sortingParam) {
		return persons.stream().distinct()
				.sorted(Comparator.comparing(sortingParam).reversed().thenComparing(p -> p.getSurname()).reversed())
				.collect(Collectors.toList());
	}
	
	/**
	 * @param persons
	 * @return
	 *//*
	private static List<Person> sortCustom2(List<Person> persons, Criteria crit) {
		return persons.stream().distinct()
				.sorted(Comparator.comparing( (Function<Person, String>) crit).reversed().thenComparing(p -> p.getSurname()).reversed())
				.collect(Collectors.toList());
	}*/
}
