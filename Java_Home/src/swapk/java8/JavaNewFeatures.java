package swapk.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaNewFeatures {

	public static void main(String[] args) {
		
		TestInterface t = (a,b) -> (a+b);
		System.out.println("Function Interface Basic add example - " + t.add(2, 3));
		
		//Predicate
		Predicate<String> p = s -> (s.length() > 3);
		System.out.println(p.test("wap"));
		
		//Function
		Function<String, Integer> f = s -> (s.length());
		System.out.println(f.apply("swapnil"));
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		
		//filter takes predicate as argument
		List s = list.stream().filter( i -> (i%2 == 0) ).collect(Collectors.toList());
		System.out.println("s = "+s);
		
		//filter takes function as argument
		List st = list.stream().map( i -> (i+10) ).collect(Collectors.toList());
		System.out.println("st = "+st);
		System.out.println("list = "+list);
		
		//max or min takes Comparator as argument
		Integer min = list.stream().max( (s1,s2) -> s1.compareTo(s2)).get();
		System.out.println("min = " + min);
		
		list.stream().forEach(z -> System.out.println(z) );
		
	}

}
