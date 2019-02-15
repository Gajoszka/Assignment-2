package assignment;

public class BubbleSort extends Assignment2 {
	
	private static void sort(int... id) {
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

	private static void printArray(int id[]) {
		int l = id.length;
		for (int x = 0; x < l; ++x) {
			System.out.print(id[x] + " ");//printing sorted numbers with spaces between
		}
		System.out.println();
		
	}

	public static void bubble() {
		Assignment2.printSeparator(lineSize);
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

}
