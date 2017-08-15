package swapk.collection.TestDiffCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCollection {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("Swapnil");
		list.add("Dinya");
		list.add("Swapnil");
		list.add("Dinya");
		
		System.out.println(list);
		list.add(2, "Harneesha");
		/**
		 * Add
		 * Inserts the specified element at the specified position in this list. 
		 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
		 */
		System.out.println(list);
		System.out.println("----");
		list.set(2, "Aju");
		/**
		 * Replaces the element at the specified position in this list with the specified element
		 */
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}

}
