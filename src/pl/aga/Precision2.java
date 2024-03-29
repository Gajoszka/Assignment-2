package zaliczenie;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Menu {
	public Scanner scanner = new Scanner(System.in);
	int lineSize = 80;
	Integer scale = null;
	int count = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String options = "1 2 3 4 5 6 ";
		Menu ob = new Menu();
		String[] menu = { "1. Declare accuracy", "2. Linear Equation with one unknown",
				"3. Linear Equation with two unknowns", "4. Quadratic equation", "5. Bubble sort", "6. Exit" };
		int select;
		do {

			select = ob.printMenu(menu);
			options = options.replace(String.valueOf(select) + " ", "");//replace chosen options with blank spaces
			switch (select) {
			case 1:
				ob.accuracy();
				break;
			case 2:
				ob.unknown();
				break;
			case 3:
				ob.unknowkns();
				break;
			case 4:
				ob.quadratic();
				break;
			case 5:
				ob.bubble();
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

	public void accuracy() {
		printSeparator(lineSize);
		System.out.println("Choose number of decimal places of the result of equation from 1 to 5");
		while (scale == null || scale < 1 || scale > 5) {
			scale = scanner.nextInt();//input number of decimal places
			if (scale > 5) {
				System.out.println("Wrong option");
			}
		}
		printSeparator(lineSize);
	}

	void unknown() {
		printSeparator(lineSize);
		System.out.println("a*x + b = c");
		System.out.println("Input \"a\" factor");
		double a = scanner.nextDouble();
		System.out.println("Input \"b\" factor");
		double b = scanner.nextDouble();
		System.out.println("Input \"c\" factor");
		double c = scanner.nextDouble();
		System.out.println(a + "*x" + " + " + b + " = " + c);
		BigDecimal n = round((c - b) / a, scale);//using round method
		System.out.println("x = " + n);
		wait2();
	}

	void unknowkns() {
		printSeparator(lineSize);
		System.out.println("a*x + b*y = c");
		System.out.println("d*x + e*y = f");
		System.out.println("Input \"a\" factor");
		double a = scanner.nextDouble();
		System.out.println("Input \"b\" factor");
		double b = scanner.nextDouble();
		System.out.println("Input \"c\" factor");
		double c = scanner.nextDouble();
		System.out.println("Input \"d\" factor");
		double d = scanner.nextDouble();
		System.out.println("Input \"e\" factor");
		double e = scanner.nextDouble();
		System.out.println("Input \"f\" factor");
		double f = scanner.nextDouble();
		System.out.println();
		System.out.println(a + "*x" + " + " + b + "*y" + " = " + c);
		System.out.println(d + "*x" + " + " + e + "*y" + " = " + f);

		double w = (a * e - b * d);//counting determinant

		if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {//unreal equation
			System.out.println("Such equation doesn't exist");
		}

		if (w != 0) {
			BigDecimal x = round((c * e - b * f) / w, scale);//counting other determinants
			BigDecimal y = round((a * f - d * c) / w, scale);
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		} else {
			System.out.println("No results");
		}
		wait2();
	}

	void quadratic() {
		printSeparator(lineSize);
		System.out.println("Insert factors for quadratic equation");
		System.out.println("f(x) = a * x^2 + b * x + c");
		double a = 0;
		while (a == 0) {
			System.out.print("Insert \"a\" factor: ");
			a = scanner.nextDouble();
			if (a == 0) {//Checking if the factor is adequate to create quadratic equation
				System.out.println("-----This is not quadratic equation----- ");
			}
		}
		System.out.print("Insert \"b\" factor: ");
		double b = scanner.nextDouble();
		System.out.print("Insert \"c\" factor: ");
		double c = scanner.nextDouble();
		System.out.println("\nf(x) = " + a + " * x^2" + " + " + b + " * x" + " + " + c);

		double delta = Math.pow(b, 2) - 4 * a * c;//counting delta
		System.out.println("\nDelta = " + delta);
		if (delta < 0) {//checking number of results
			System.out.println("No results");
		} else {
			System.out.println("Results:");
			if (delta == 0) {
				BigDecimal x = round(-b / (2 * a), scale);
				System.out.println("x = " + x);
			} else {
				double delta1 = Math.sqrt(delta);//counting radical of delta to perform further equations
				BigDecimal x1 = round(((-b) - delta1) / (4 * a), scale);
				BigDecimal x2 = round(((-b) + delta1) / (4 * a), scale);
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
			}
		}
		wait2();
	}

	private void sort(int... id) {
		int l = id.length;
		for (int x = 0; x < l - 1; x++) {
			for (int y = 0; y < l - x - 1; y++) {
				if (id[y] > id[y + 1]) {//switching places
					int temp = id[y];
					id[y] = id[y + 1];
					id[y + 1] = temp;
				}
			}
		}
	}

	private void printArray(int id[]) {
		int l = id.length;
		for (int x = 0; x < l; ++x) {
			System.out.print(id[x] + " ");//printing sorted numbers with spaces between
		}
		System.out.println();
		
	}

	void bubble() {
		printSeparator(lineSize);
		int count = 0;
		while (count <= 0 || count > 7) {// choose amount of numbers in id, maximum 10
			System.out.println("Input students count (1-7):");
			count = scanner.nextInt();
			if(count >7 || count <= 0) {
				System.out.println("Wrong option.Try again");}
		}
		System.out.println("Input digits from your student ID to get them sorted in ascending order");
		int[] id = new int[count];
		for (int i = 0; i < count; i++) {
			System.out.print((i + 1) + ": ");
			id[i] = scanner.nextInt();//input digits to an array
		}
		printSeparator(lineSize);
		System.out.println("ID number is ");
		for (int i = 0; i < count; i++) {
			System.out.print(id[i] + "");//displaying real id number
		}
		System.out.println();
		printSeparator(lineSize);
		sort(id);//call sorting method
		System.out.println("ID digits after sorting");
		printArray(id);//call printing method
		wait2();
	}

	private BigDecimal round(double value, Integer scale) {
		BigDecimal d = new BigDecimal(value);
		if (scale != null)
			return d.setScale(scale, RoundingMode.HALF_UP);//setting decimal places to equation results
		return d;//if accuracy part is skipped
	}

	int printMenu(String[] menu) {//making output more organised and clear
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

	void printLine(String line, int size) {//"box" for the menu
		System.out.print("|  ");
		System.out.print(line);
		for (int i = line.length(); i < size - 3; i++)
			System.out.print(" ");
		System.out.println("|");

	}

	void printSeparator(int size) {//"box" for the menu
//		System.out.println();
		for (int i = 0; i < size; i++)
			System.out.print("-");
		System.out.println();

	}

	private void wait2() {
		printSeparator(lineSize);
		printLine("            Press ENTER to continue", lineSize);//informs user how to continue
		printSeparator(lineSize);
		try {
			System.in.read();
		} catch (IOException e) {

		}
	}
}
