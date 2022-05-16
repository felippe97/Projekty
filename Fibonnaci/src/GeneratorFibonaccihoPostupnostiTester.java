import java.util.Scanner;

public class GeneratorFibonaccihoPostupnostiTester {

	public static void main(String[] args) {
		Scanner vstup = new Scanner(System.in);
		System.out.print("Zadaj N: ");
		int n = vstup.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			long cislo = vratFibonaccihoCislo(i);
			System.out.println("Fibonacciho cislo: (" + i + ") = " + cislo);
		}
	}

	private static long vratFibonaccihoCislo(int n)
	{
		if(n <= 2)
		{
			return 1;
		}
		return vratFibonaccihoCislo(n - 1) + vratFibonaccihoCislo(n - 2);
	}
}
