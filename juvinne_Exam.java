package pagalan;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class juvinne_Exam {
	
	static Scanner input = new Scanner(System.in);
	
	static Queue<String> queue = new LinkedList<>();
	
	static int total;
	
	public static void main(String[] args) {
		
		int choice;
		
		do {
			System.out.println("\n==========PERMUTATION==========");
			System.out.println("1. Add Element");
			System.out.println("2. Display Elements");
			System.out.println("3. Generate Permutation");
			System.out.println("4. Exit");
			
			System.out.print("Enter your choice: ");
			
			choice = input.nextInt();
			
			switch(choice) {
			case 1:
				addElement();
				break;
			case 2:
				displayQueue();
				break;
			case 3:
				generatePermutation();
				break;
			case 4:
				System.out.println("Program Terminated.");
			default:
				System.out.println("Invalid Input.");
			}
			
		} while (choice != 4);
	}
	
	static void addElement() {
		System.out.print("Enter number of elements to add: ");
		int numElement = input.nextInt();
		
		for (int i = 1; i <= numElement; i++) {
			System.out.print("Enter element " + i + ": ");
			queue.add(input.next().toUpperCase());
		}
		displayQueue();
		
		if(numElement == 5) {
			for(int i = 0; i < 2 && !queue.isEmpty(); i++) {
				System.out.print("Dequeued: " + queue.peek());
				queue.poll();
			}
			displayQueue();
		}
	}
	
	static void displayQueue() {
		if(queue.isEmpty()) {
			System.out.println("Queue is Empty.");
		} else {
			System.out.println();
			System.out.println("Queue: " + queue);
		}
	}
	
	static String[] copyQueue() {
		int queuesize = queue.size();
		String[] elements = new String[queuesize];
		
		for (int i = 0; i < queuesize; i++) {
			String element = queue.poll();
			elements[i] = element;
			queue.add(element);
		}
		return elements;
	}
	
	static void generatePermutation() {
		if(queue.isEmpty()) {
			System.out.println("Queue is Empty. Please Enter elements first.");
			return;
		}
		displayQueue();
		System.out.println();
		
		System.out.print("Enter number of elements to arrange: ");
		int numSelect = input.nextInt();
		System.out.println();
		
		if(numSelect < 1 || numSelect> queue.size()) {
			System.out.println("invalid. must be 1 to " + queue.size() + ".");
			return;
		}
		
		String[] elements = copyQueue();
		boolean[] isUsed = new boolean[elements.length];
		total = 0;
		arrangeElement(elements, isUsed, "", 0, numSelect);
		
		System.out.println();
		System.out.println("Total Permutation: " + total);
	}
	
	static void arrangeElement(String[] elements, boolean[] isUsed, String result, int position, int numSelect) {
		if(position == numSelect) {
			System.out.println(result);
			total++;
			return;
		}
		for(int i = 0; i < elements.length; i++) {
			if(!isUsed[i]) {
				isUsed[i]= true;
				arrangeElement(elements, isUsed, result+elements[i], position + 1, numSelect);
				isUsed[i] = false;
			}
		}
	}
}



