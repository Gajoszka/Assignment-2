package assignment;

import java.io.IOException;
import java.util.Scanner;

public class Assignment2 {
	public static Scanner scanner = new Scanner(System.in);
	public static int lineSize = 80;
	static Integer scale = null;
	int count = 0;

	public static void main(String[] args) {
		String options = "1 2 3 4 5 6";
		String[] menu = { "1. Declare accuracy", "2. Linear Equation with one unknown", "3. Linear Equation with two unknowns", "4. Quadratic equation", "5. Bubble sort", "6. Exit" };
		int select;
		do { select = Assignment2.printMenu(menu);
			options = options.replace(String.valueOf(select) + " ", "");//replace chosen options with blank spaces
			switch (select) {
			case 1:
				scale = null;
				Equations.accuracy();
				break;
			case 2:
				Equations.unknown();
				break;
			case 3:
				Equations.unknowkns();
				break;
			case 4:
				Equations.quadratic();
				break;
			case 5:
				BubbleSort.bubble();
				break;
			case 6:
				if (options == "") {
					System.out.println("");//all options implemented
				} else {
					System.out.println("These options haven't been used");
					System.out.println(options);
				}
				System.out.println("Closing the program");
				System.exit(0);
				break;
			default:
				if (select > 6) {
					System.out.println("Wrong option. Try again");
				}
			}
		} while (select > 0);//iterates until select option is greater than zero

	}
	
	public static int printMenu(String[] menu) {//making output more organised and clear
		printSeparator(lineSize);
		printLine("This is an application that performs simple tasks. Here is a list of them. ", lineSize);
		printSeparator(lineSize);
		for (String x : menu) {
			printLine(x, lineSize);
		}
		printSeparator(lineSize);
		int select = 0;
		while (select < 1 || select > menu.length) {
			select = scanner.nextInt();
		}
		return select;
	}

	public static void printLine(String line, int size) {//"box" for the menu
		System.out.print("|  ");
		System.out.print(line);
		for (int i = line.length(); i < size - 3; i++)
			System.out.print(" ");
		System.out.println("|");

	}

	public static void printSeparator(int size) {//"box" for the menu
//		System.out.println();
		for (int i = 0; i < size; i++)
			System.out.print("-");
		System.out.println();

	}

	public static void wait2() {
		printSeparator(lineSize);
		printLine("            Press ENTER to continue", lineSize);//informs user how to continue
		printSeparator(lineSize);
		try {
			System.in.read();
		} catch (IOException e) {

		}
	}
}