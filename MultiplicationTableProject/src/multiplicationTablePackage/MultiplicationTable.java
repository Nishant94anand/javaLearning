package multiplicationTablePackage;

public class MultiplicationTable {
	public void print()
	{
		print(5);
	}

	public void print(int num)
	{
		print(num, 1, 10);
	}

	public void print(int num, int from, int to)
	{
		for (int i=from; i<=to; ++i)
		{
			System.out.printf("%d x %d = %d", num, i, num * i).println();
		}
	}

}
