package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorPattern {

	static void printAggregate(Iterator<Item> itr) {
		System.out.println("Iterating over collection:");
		while (itr.hasNext()) {
			Item element = itr.next();
			System.out.println(element.getName());
		}
		System.out.println();
	}
	
	static void printBackwardsAggregate(ListIterator<Item> itr) {
		System.out.println("Iterating Backwards:");	
		 while (itr.hasPrevious()){
			 Item element = itr.previous();
				System.out.println(element.getName());
		      
		    }
		System.out.println();
	}

	public static void main(String args[]) {
		ArrayList<Item> aggregate = new ArrayList<Item>();
		aggregate.add(new Item("Item 0"));
		aggregate.add(new Item("Item 1"));
		aggregate.add(new Item("Item 2"));
		aggregate.add(new Item("Item 3"));
		aggregate.add(new Item("Item 4"));
		aggregate.add(new Item("Item 5"));
		aggregate.add(new Item("Item 6"));
		aggregate.add(new Item("Item 7"));
		aggregate.add(new Item("Item 8"));

		Iterator<Item> iterator = aggregate.iterator();
		ListIterator<Item> itr = aggregate.listIterator(aggregate.size());

		
		printAggregate(iterator);
		printBackwardsAggregate(itr);
		
		aggregate.forEach(item -> printString(item));
	}
	 private static void printString(Item  it) {
	        System.out.println(it.getName());
	    }
}