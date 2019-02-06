package app;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("This is an application that performs simple tasks. Here is a list of them.");
		
		boolean control = true;
		while(control) {
			String[] menu = {"1. Declare accuracy", "2. Equation", "3. Bubble sort", "4. Exit"};
			for(String x:menu) {
			System.out.println(x); }
			
			System.out.println("Choose the option");
			Scanner choice = new Scanner(System.in);
			int opt = choice.nextInt();
			
			App ch = new App();

		switch(opt) {
		case 1:
			ch.Accuracy1();
			break;
		case 2:
			ch.Equation();
			break;
		case 3:
			ch.Bubble();
			break;
		case 4:
			control = false;
		default:
			System.out.println("Wrong option. Try again");
		}
		
		}

	}
	
	public void Accuracy1() {
		
		DecimalFormat value = new DecimalFormat("#0.000");
		Scanner acc = new Scanner(System.in);
		System.out.println("Set the precision of the result of the equation");
		int accuracy = acc.nextInt();
		
		switch(accuracy) {
		case 1:
			DecimalFormat value1 = new DecimalFormat("#0.0");
			System.out.println(value1.format(x));
			System.out.println(value1.format(x1));
			System.out.println(value1.format(x2));
			break;
		case 2:
			DecimalFormat value2 = new DecimalFormat("#0.00");
			System.out.println(value2.format(x));
			System.out.println(value2.format(x1));
			System.out.println(value2.format(x2));
			break;
		case 3:
			DecimalFormat value3 = new DecimalFormat("#0.000");
			System.out.println(value3.format(x));
			System.out.println(value3.format(x1));
			System.out.println(value3.format(x2));
			break;
		case 4:
			DecimalFormat value4 = new DecimalFormat("#0.0000");
			System.out.println(value4.format(x));
			System.out.println(value4.format(x1));
			System.out.println(value4.format(x2));
			break;
		case 5:
			DecimalFormat value5 = new DecimalFormat("#0.00000");
			System.out.println(value5.format(x));
			System.out.println(value5.format(x1));
			System.out.println(value5.format(x2));
		default:
			System.out.println("Wrong value. Try again");
			App back = new App();
			
		}
	}
	
	public void Equation() {
		Scanner n1 = new Scanner(System.in);
		System.out.println("Insert factors for quadratic equation");
		System.out.println("f(x) = a * x^2 + b * x + c");
		System.out.println("Insert a factor");
		double a = n1.nextDouble();
		System.out.println("Insert b factor");
		double b = n1.nextDouble();
		System.out.println("Insert c factor");
		double c = n1.nextDouble();
		
		System.out.println("f(x) = " + a + " * x^2" + " + " + b + " * x" + " + " + c);
		
		double delta = Math.pow(b, 2) - 4 * a * c;
		double x;
		double x1;
		double x2;
		
		App ac = new App();
		
		if(delta < 0) {
			System.out.println("No results"); } 
		if(delta == 0) {
			x = (-b) / 2* a;
			System.out.println("x = " + x); } 
		if(delta > 0) {
			x1 = ((-b) - delta) / 4 * a;
			x2 = ((-b) + delta) / 4 * a;
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
		
		Application opt1 = new Application();
		System.out.println("");
		opt1.main(args);
	}

	void sort(int... id) {
		
		int l = id.length;
		
		for(int x = 0; x < l - 1; x++) {
			for(int y = 0; y < l - x -1; y++) {
				if(id[y] > id[y+1]) {
					int temp = id[y];
					id[y] = id[y+1];
					id[y+1] = temp;
				}
			}
		}
	}
		
	void Printarray(int id[]) {
		int l = id.length; 
        for (int x = 0; x < l; ++x) { 
            System.out.print(id[x] + " "); } 
        	System.out.println(); 

	}

	@SuppressWarnings("resource")
	public void Bubble() {
		
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
		
		int[] id = {a,b,c,d,e,f,g};
		App res = new App();
		res.sort(id);
		System.out.println("ID digits after sorting");
		res.Printarray(id);
		System.out.println("");
		res.main(args);
	}

}
