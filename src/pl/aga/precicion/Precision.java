package pl.aga.precicion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Precision {

	public Scanner scanner = new Scanner(System.in);
	BigDecimal x;
	BigDecimal x1;
	BigDecimal x2;
	int scale = 2;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int select;
		Precision ob = new Precision();
		do {
			System.out.println("This is an application that performs simple tasks. Here is a list of them.");
			String[] menu = { "1. Declare accuracy", "2. Equation", "3. Bubble sort", "4. Exit" };
			for (String x : menu) {
				System.out.println(x);
			}
			
			select = ob.scanner.nextInt();

			switch (select) {
			case 1:
				ob.accuracy();
				break;
			case 2:
				ob.equation();
				break;
			case 3:
				ob.bubble();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				if (select > 4) {
					System.out.println("Wrong option. Try again");
				}
			}

		} while (select > 0);
		System.out.println("Closing the program");
	}

	void accuracy() {
		System.out.println("Hello");
		scale = scanner.nextInt();

	}

	public void equation() {
		System.out.println("Insert factors for quadratic equation");
		System.out.println("f(x) = a * x^2 + b * x + c");
		System.out.print("Insert a factor: ");
		double a = scanner.nextDouble();
		System.out.print("Insert b factor: ");
		double b = scanner.nextDouble();
		System.out.print("Insert c factor: ");
		double c = scanner.nextDouble();
		System.out.println();
		System.out.println("f(x) = " + a + " * x^2" + " + " + b + " * x" + " + " + c);
		double delta = Math.pow(b, 2) - 4 * a * c;

		if (delta < 0) {
			System.out.println("No results");
		}
		if (delta == 0) {
			x = new BigDecimal(-b / 2 * a).setScale(scale,RoundingMode.HALF_UP);
			
			System.out.println("x = " + x);
		}

		if (delta > 0) {
			x1 = new BigDecimal(((-b) - delta) / 4 * a).setScale(scale,RoundingMode.HALF_UP);
			x2 = new BigDecimal(((-b) + delta) / 4 * a).setScale(scale,RoundingMode.HALF_UP);
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
	}

	void sort(int... id) {

		int l = id.length;

		for (int x = 0; x < l - 1; x++) {
			for (int y = 0; y < l - x - 1; y++) {
				if (id[y] > id[y + 1]) {
					int temp = id[y];
					id[y] = id[y + 1];
					id[y + 1] = temp;
				}
			}
		}
	}

	void printarray(int id[]) {
		int l = id.length;
		for (int x = 0; x < l; ++x) {
			System.out.print(id[x] + " ");
		}
		System.out.println();

	}

	public void bubble() {

		System.out.println("Input digits from your student ID to get them sorted in ascending order");
		System.out.print("1:");
		int a = scanner.nextInt();
		System.out.print("2:");
		int b = scanner.nextInt();
		System.out.print("3:");
		int c = scanner.nextInt();
		System.out.print("4:");
		int d = scanner.nextInt();
		System.out.print("5:");
		int e = scanner.nextInt();
		System.out.print("6:");
		int f = scanner.nextInt();
		System.out.print("7:");
		int g = scanner.nextInt();

		System.out.println("ID number is " + a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g);

		int[] id = { a, b, c, d, e, f, g };
		sort(a, b, c, d, e, f, g);
		System.out.println("ID digits after sorting");
		printarray(id);
	}
}