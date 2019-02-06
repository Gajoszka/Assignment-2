package menu;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("This is an application that performs simple tasks. Here is a list of them.");
		String[] menu = {"1. Declare accuracy", "2. Equation", "3. Bubble sort", "4. Exit"};
		for(String x:menu) {
		System.out.println(x); }
		
		System.out.println("Choose the option");
		Scanner choice = new Scanner(System.in);
		int opt = choice.nextInt();
		
		Application option = new Application();
		
		if(opt == 1) {
			option.Accuracy1(args);
			//zrobic accuracy
		} else if(opt == 2) {
			option.Equation(args);
		} else if(opt == 3) {
			option.Bubble(args);
		} else if(opt == 4) {
			//exit
		} else {
			System.out.println("Wrong number. Try again");
			// + powrot do ponownego wyboru
		}
	}
	
	//do main jak ktoras nie zostala wybrana to ma sie pokazac, ze cos nie zostalo uzyte i co
	
	public void Accuracy1(String[] args) {
		
		DecimalFormat value = new DecimalFormat("#0.000");
		Scanner acc = new Scanner(System.in);
		System.out.println("Set the precision of the result of the equation");
		int accuracy = acc.nextInt();
	
		if(accuracy == 1) {
			DecimalFormat value1 = new DecimalFormat("#0.0");
			System.out.println(value1.format(x));
			System.out.println(value1.format(x1));
			System.out.println(value1.format(x2));
		} else if(accuracy == 2) {
			DecimalFormat value2 = new DecimalFormat("#0.00");
			System.out.println(value2.format(x));
			System.out.println(value2.format(x1));
			System.out.println(value2.format(x2));
		} else if(accuracy == 3) {
			DecimalFormat value3 = new DecimalFormat("#0.000");
			System.out.println(value3.format(x));
			System.out.println(value3.format(x1));
			System.out.println(value3.format(x2));
		} else if(accuracy == 4) {
			DecimalFormat value4 = new DecimalFormat("#0.0000");
			System.out.println(value4.format(x));
			System.out.println(value4.format(x1));
			System.out.println(value4.format(x2));
		} else if(accuracy == 5) {
			DecimalFormat value5 = new DecimalFormat("#0.00000");
			System.out.println(value5.format(x));
			System.out.println(value5.format(x1));
			System.out.println(value5.format(x2));
		} else {
			System.out.println("Wrong value. Try again");
			Application back = new Application();
			
		}
		
		Application menu = new Application();
		menu.main(args);
		
	}
	
	@SuppressWarnings("resource")
	public void Equation(String[] args) {
		Scanner n1 = new Scanner(System.in);
		Scanner n2 = new Scanner(System.in);
		Scanner n3 = new Scanner(System.in);
		System.out.println("Insert factors for quadratic equation");
		System.out.println("f(x) = a * x^2 + b * x + c");
		System.out.println("Insert a factor");
		double a = n1.nextDouble();
		System.out.println("Insert b factor");
		double b = n2.nextDouble();
		System.out.println("Insert c factor");
		double c = n3.nextDouble();
		
		System.out.println("f(x) = " + a + " * x^2" + " + " + b + " * x" + " + " + c);
		
		double delta = Math.pow(b, 2) - 4 * a * c;
		double x;
		double x1;
		double x2;
		
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

	//pomyslec nad bardziej skomplikowanym rownaniem, albo moze dac kilka do wyboru
	
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
		
		int[] id = {a,b,c,d,e,f,g};
		Application res = new Application();
		res.sort(id);
		System.out.println("ID digits after sorting");
		res.Printarray(id);
		System.out.println("");
		res.main(args);
	}

}
