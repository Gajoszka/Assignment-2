package pl.aga.menu;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Application {
	public Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Application app = new Application();
		int opt = 0;
		while (opt != 4) {
			opt = app.menu();
			if (opt != 4) {
				if (opt == 1) {
					app.accuracy(new double[] { 5.78787, 9.999999, 5.7777777 });
					// zrobic accuracy
				} else if (opt == 2) {
					app.equation(args);
				} else if (opt == 3) {
					app.Bubble(args);
				} else {
					System.out.println("Wrong number. Try again");
				}
				System.out.println("Press any key");
				app.scanner.next();
			}

		}
	}

	public int menu() {
		System.out.println("This is an application that performs simple tasks. Here is a list of them.");
		String[] menu = { "1. Declare accuracy", "2. Equation", "3. Bubble sort", "4. Exit" };
		for (String x : menu) {
			System.out.println(x);
		}
		System.out.print("Choose the option:");
		int opt = scanner.nextInt();
		return opt;
	}
	// do main jak ktoras nie zostala wybrana to ma sie pokazac, ze cos nie zostalo
	// uzyte i co

	public void accuracy(double[] x) {
		System.out.print("Set the precision of the result of the equation: ");
		int accuracy = scanner.nextInt();
		if (accuracy > 0 && accuracy < 6) {
			String format = "#0.";
			for (int i = 0; i < accuracy; i++)
				format += "0";
			DecimalFormat value1 = new DecimalFormat(format);
			System.out.println(value1.format(x[0]));
			System.out.println(value1.format(x[1]));
			System.out.println(value1.format(x[2]));
		} else {
			System.out.println("Wrong value. Try again");
		}

	}

	@SuppressWarnings("resource")
	public void equation(String[] args) {
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
		double x;
		double x1;
		double x2;

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

	// pomyslec nad bardziej skomplikowanym rownaniem, albo moze dac kilka do wyboru

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

	@SuppressWarnings("resource")
	public void Bubble(String[] args) {

		System.out.println("Input digits from your student ID to get them sorted in ascending order");

		Scanner n1 = new Scanner(System.in);

		int a = n1.nextInt();
		int b = n1.nextInt();
		int c = n1.nextInt();
		int d = n1.nextInt();
		int e = n1.nextInt();
		int f = n1.nextInt();
		int g = n1.nextInt();

		System.out.println("ID number is " + a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g);

		int[] id = { a, b, c, d, e, f, g };
		Application res = new Application();
		res.sort(id);
		System.out.println("ID digits after sorting");
		res.Printarray(id);
		System.out.println("");
		res.main(args);
	}

}
