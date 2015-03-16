// highArray.java
// demonstrates array class with high-level interface

class HighArray
{
	private long[] a;
	private int nElems;

	public HighArray(int max)
	{
		a = new long[max];
		nElems = 0;
	}

	public boolean find(long searchKey)
	{
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == searchKey)
				break;
		if (j == nElems)
			return false;
		else
			return true;
	}

	public void insert(long value)
	{
		a[nElems] = value;
		nElems++;
	}

	public boolean delete(long value)
	{
		int j;
		for (j = 0; j < nElems; j++)
			if (value == a[j])
				break;
		if (j == nElems)
			return false;
		else
		{
			for (int k = j; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return true;
		}
	}

	public void display()
	{
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public long getMax()
	{
		long max = a[0];
		if (nElems == 0)
			return -1;
		else
		{
			for (int j = 0; j < nElems; j++)
				if (a[j] > max)
					max = a[j];
			return max;
		}
	}

	public long removeMax()
	{
		long max = a[0];
		int maxIndex = 0;

		if (nElems == 0)
			return -1;
		else
		{
			for (int j = 0; j < nElems; j++)
				if (a[j] > max)
				{
					max = a[j];
					maxIndex = j;
				}
			for (int k = maxIndex; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return max;

		}
	}
}








class HighArrayApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		HighArray sortedArr = new HighArray(maxSize);

		arr.insert(10);
		arr.insert(20);
		arr.insert(30);
		arr.insert(40);
		arr.insert(500);
		arr.insert(60);
		arr.insert(70);
		arr.insert(80);
		arr.insert(90);
		arr.insert(100);

		arr.display();

		System.out.println(arr.getMax());

		arr.display();

		while (arr.getMax() != -1)
			sortedArr.insert(arr.removeMax());

		sortedArr.display();
	}
}