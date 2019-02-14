package precision;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Precision {
	
	public Scanner scanner = new Scanner(System.in);
	BigDecimal x;
	BigDecimal x1;
	BigDecimal x2;
	BigDecimal y;
	BigDecimal z;
	BigDecimal n;
	BigDecimal m;
	
	int scale = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int select;
		Precision ob = new Precision();
		
		String options = "1 2 3 4 5 6";

		do {
			System.out.println("This is an application that performs simple tasks. Here is a list of them.");
			String[] menu = { "1. Declare accuracy", "2. Linear Equation with one unknown", "3. Linear Equation with two unknowns", "4. Quadratic equation", "5. Bubble sort", "6. Exit" };
			for (String x : menu) {
				System.out.println(x);
			}
		    Scanner scanner = new Scanner(System.in);
		    select = scanner.nextInt();
		    options = options.replace(String.valueOf(select),"");
		    
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
		        	ob.Bubble();
		        	break;
		        case 6:
		        	if(options == "") {
		        		System.out.println("");
		        	} else {
		        	System.out.println("These options haven't been used");
		        	System.out.println(options);
		        	}
		        	System.out.println("Closing the program");
		        	System.exit(0);
		        	 break;
				default:
					if(select > 6) {
						System.out.println("Wrong option. Try again");
		    }
		    }
		} while (select > 0);
	}
	
	void accuracy() {
		System.out.println("Choose number of decimal places of the result of equation from 1 to 5");
		scale = scanner.nextInt();
		if(scale > 5 && scale < 0) {
			System.out.println("Wrong option");
		}
	}
	
	void unknown() {
		System.out.println("a*x + b = c");
		System.out.println("Input a factor");
		double a = scanner.nextDouble();
		System.out.println("Input b factor");
		double b = scanner.nextDouble();
		System.out.println("Input c factor");
		double c = scanner.nextDouble();
		System.out.println(a + "*x" + " + " + b + "*y" + " = " + c);
		
		n = new BigDecimal((c - b)/a).setScale(scale, RoundingMode.HALF_UP);
		
		System.out.println("x = " + n);
	}
	
	void unknowkns() {
		
		System.out.println("a*x + b*y = c");
		System.out.println("d*x + e*y = f");
		System.out.println("Input a factor");
		double a = scanner.nextDouble();
		System.out.println("Input b factor");
		double b = scanner.nextDouble();
		System.out.println("Input c factor");
		double c = scanner.nextDouble();
		System.out.println("Input d factor");
		double d = scanner.nextDouble();
		System.out.println("Input e factor");
		double e = scanner.nextDouble();
		System.out.println("Input f factor");
		double f = scanner.nextDouble();
		
		System.out.println(a + "*x" + " + " + b + "*y" + " = " + c);
		System.out.println(d + "*x" + " + " + e + "*y" + " = " + f);
		
		double w = (a*e - b*d);
		
		if(a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
			System.out.println("Such equation doesn't exist");
		}
		
		if(w != 0) {
			z = new BigDecimal((c*e - b*f) / w).setScale(scale, RoundingMode.HALF_UP);
			y = new BigDecimal((a*f - d*c) / w).setScale(scale, RoundingMode.HALF_UP);
			
		System.out.println("x = " + z);
		System.out.println("y = " + y);
		} else {
			System.out.println("No results");
		}
	
	}
	
	void quadratic() {
		System.out.println("Insert factors for quadratic equation");
		System.out.println("f(x) = a * x^2 + b * x + c");
		System.out.print("Insert a factor: ");
		double a = scanner.nextDouble();
		System.out.print("Insert b factor: ");
		double b = scanner.nextDouble();
		System.out.print("Insert c factor: ");
		double c = scanner.nextDouble();
		System.out.println("f(x) = " + a + " * x^2" + " + " + b + " * x" + " + " + c);
		
		double delta = Math.pow(b, 2) - 4 * a * c;
		
		while(a != 0) {
		if (delta < 0) {
			System.out.println("Delta = " + delta);
			System.out.println("No results");
		} else if (delta == 0) {
			System.out.println("Delta = " + delta);
			x = new BigDecimal(-b / 2 * a).setScale(scale, RoundingMode.HALF_UP);
			System.out.println("x = " + x);
		} else {
			System.out.println("Delta = " + delta);
			double delta1 = Math.sqrt(delta);
			x1 = new BigDecimal(((-b) - delta1) / 4 * a).setScale(scale, RoundingMode.HALF_UP);
			x2 = new BigDecimal(((-b) + delta1) / 4 * a).setScale(scale, RoundingMode.HALF_UP);
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
		}
		
		if(a == 0) {
			System.out.println("This is not quadratic equation");
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
	
	void Bubble() {
		
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
		sort(id);
		System.out.println("ID digits after sorting");
		printarray(id);
	}
}
