package precision;

import java.util.Scanner;

public class Precision {
	
	public Scanner scanner = new Scanner(System.in);
	double x;
	double x1;
	double x2;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int select;
		do {
			System.out.println("This is an application that performs simple tasks. Here is a list of them.");
			String[] menu = { "1. Declare accuracy", "2. Equation", "3. Bubble sort", "4. Exit" };
			for (String x : menu) {
				System.out.println(x);
			}
		    Scanner scanner = new Scanner(System.in);
		    select = scanner.nextInt();
		    Precision ob = new Precision();

		    switch (select) {
		        case 1:
		            ob.accuracy();
		            break;
		        case 2:
		            ob.equation();
		            break;
		        case 3:
		            ob.Bubble();
		            break;
		        case 4:
		        	System.out.println("Closing the program");
		        	System.exit(0);
				default:
					if(select >= 4) {
						System.out.println("Wrong option. Try again");
		    }
		    }
		    
		} while (select > 0);
		
	}
	
	void accuracy() {
		System.out.println("Hello");
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
			x = (-b) / 2 * a;
			System.out.println("x = " + x);
		}
		if (delta > 0) {
			x1 = ((-b) - delta) / 4 * a;
			x2 = ((-b) + delta) / 4 * a;
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

	void Printarray(int id[]) {
		int l = id.length;
		for (int x = 0; x < l; ++x) {
			System.out.print(id[x] + " ");
		}
		System.out.println();

	}
	
	public void Bubble() {
		
		System.out.println("Input digits from your student ID to get them sorted in ascending order");

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int e = scanner.nextInt();
		int f = scanner.nextInt();
		int g = scanner.nextInt();

		System.out.println("ID number is " + a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g);

		int[] id = { a, b, c, d, e, f, g };
		Precision res = new Precision();
		res.sort(id);
		System.out.println("ID digits after sorting");
		res.Printarray(id);
	}
}