package swapk.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] a) {

		List<String> elements =
				Stream.of("a", "b", "c").filter(element -> element.contains("b"))
				.collect(Collectors.toList());
		Optional<String> anyElement = elements.stream().findAny();
		Optional<String> firstElement = Stream.of("a", "b", "c").findFirst();
		
		System.out.println(firstElement.get());
		
		Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("a"));
		Optional<String> anyElement1 = stream.findAny();
		
		Optional<String> firstElement1 = stream.findFirst();
		System.out.println(firstElement1.get());
	}

}
