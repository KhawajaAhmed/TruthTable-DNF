
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	// ArrayList to store each boolean expression with output
	public static ArrayList<String> list = new ArrayList<String>();

	public static void dnfExpression() {
		System.out.println("\nDNF Expression:");

		for (int i = 0; i < list.size() - 1; i++) 
		{
			System.out.print("(" + list.get(i) + ") ∨ ");
		}

		System.out.println("(" + list.get(list.size() - 1) + ")");

	}

	public static boolean myExpression(boolean a, boolean b) 
	{
		return !(a && b);
	}

	public static boolean myExpression(boolean a, boolean b, boolean c) 
	{
		return (a && b) && (c);
	}

	public static boolean myExpression(boolean a, boolean b, boolean c, boolean d) 
	{
		return !(a && b && !c) && (b && d) || (d && !c);
	}

	public static void twoVariables() {

		System.out.println("-------------");
		System.out.println("| A | B | X |");
		System.out.println("-------------");

		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 2; j++) 
			{
				ArrayList<String> arr = new ArrayList<String>();

				boolean a = i != 0;
				boolean b = j != 0;

				int result = (myExpression(a, b)) ? 1 : 0;

				// stores the string representation of each variable inside a ArrayList if
				// output is 1
				if (result == 1) {
					arr.add(a ? "a" : "¬a");
					arr.add(b ? "b" : "¬b");

					// stores the individual converted expression into another ArrayList
					list.add(arr.get(0) + "∧" + arr.get(1));
				}

				System.out.println("| " + i + " | " + j + " | " + result + " |");

			}

		}

	}

	public static void threeVariables() {
		System.out.println("-----------------");
		System.out.println("| A | B | C | X |");
		System.out.println("-----------------");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					ArrayList<String> arr = new ArrayList<String>();

					boolean a = i != 0;
					boolean b = j != 0;
					boolean c = k != 0;

					int result = (myExpression(a, b, c)) ? 1 : 0;

					if (result == 1) {
						arr.add(a ? "a" : "¬a");
						arr.add(b ? "b" : "¬b");
						arr.add(c ? "c" : "¬c");

						list.add(arr.get(0) + "∧" + arr.get(1) + "∧" + arr.get(2));
					}

					System.out.println("| " + i + " | " + j + " | " + k + " | " + result + " |");

				}
			}
		}
	}

	public static void fourVariables() {
		System.out.println("---------------------");
		System.out.println("| A | B | C | D | X |");
		System.out.println("---------------------");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {

					for (int z = 0; z < 2; z++) {
						ArrayList<String> arr = new ArrayList<String>();

						boolean a = i != 0;
						boolean b = j != 0;
						boolean c = k != 0;
						boolean d = z != 0;

						int result = (myExpression(a, b, c, d)) ? 1 : 0;
						if (result == 1) {
							arr.add(a ? "a" : "¬a");
							arr.add(b ? "b" : "¬b");
							arr.add(c ? "c" : "¬c");
							arr.add(d ? "d" : "¬d");

							list.add(arr.get(0) + "∧" + arr.get(1) + "∧" + arr.get(2) + "∧" + arr.get(3));
						}
						System.out.println("| " + i + " | " + j + " | " + k + " | " + z + " | " + result + " |");
					}
				}
			}
		}
	}

	public static void truthTable(int inputs) 
	{

		System.out.println("\nTruth Table:");

		if (inputs == 2)
			twoVariables();
		else if (inputs == 3)
			threeVariables();
		else
			fourVariables();

	}

	public static void main(String[] args) 
	{
		System.out.println(
				"\nPlease input the number of unique variables in the boolean expression.\n\nAlso please read the markdown file for more detail about the code.\n");

		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter number of inputs.");
		int num = input.nextInt();

		truthTable(num);
		dnfExpression();

		input.close();
	}

}