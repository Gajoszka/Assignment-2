package assignment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Equations extends Assignment2 {
	
	public static void accuracy() {
		printSeparator(lineSize);
		System.out.println("Choose number of decimal places of the result of equation from 1 to 5");
		while (scale == null || scale < 1 || scale > 5) {
			scale = scanner.nextInt();//input number of decimal places
			if (scale > 5) {
				System.out.println("Wrong option");
			}
		}
		printSeparator(lineSize);
		wait2();
	}

	public static void unknown() {
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

	public static void unknowkns() {
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

	public static void quadratic() {
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
		Assignment2.wait2();
	}
	
	private static BigDecimal round(double value, Integer scale) {
		BigDecimal d = new BigDecimal(value);
		if (scale != null)
			return d.setScale(scale, RoundingMode.HALF_UP);//setting decimal places to equation results
		return d;//if accuracy part is skipped
	}

}
