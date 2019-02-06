package BubbleSort;

import java.util.Scanner;

public class BubbleSort {
	
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
	public static void main(String[] args) {
		
		System.out.println("Input digits from your student ID to get them sorted in ascending order");
		
		Scanner n1 = new Scanner(System.in);
		Scanner n2 = new Scanner(System.in);
		Scanner n3 = new Scanner(System.in);
		Scanner n4 = new Scanner(System.in);
		Scanner n5 = new Scanner(System.in);
		Scanner n6 = new Scanner(System.in);
		Scanner n7 = new Scanner(System.in);
		
		int a = n1.nextInt();
		int b = n2.nextInt();
		int c = n3.nextInt();
		int d = n4.nextInt();
		int e = n5.nextInt();
		int f = n6.nextInt();
		int g = n7.nextInt();
		
		System.out.println("ID number is " + a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g);
		
		int[] id = {a,b,c,d,e,f,g};
		BubbleSort res = new BubbleSort();
		res.sort(id);
		System.out.println("ID digits after sorting");
		res.Printarray(id);
	}
	
}