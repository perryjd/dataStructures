class Deque
{
	private int maxSize;
	private long[] queArray;
	private int left;
	private int right;
	private int nItems;

	public Deque(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		left = 0;
		right = -1;
		nItems = 0;
	}

	public void insertLeft(long j)
	{
		System.out.println("Trying to call insertLeft()");
		if (left == 0)
			left = maxSize;
		queArray[--left] = j;
		nItems++;
	}

	public void insertRight(long j)
	{
		if (right == maxSize - 1)
			right = -1;
		queArray[++right] = j;
		nItems++;
	}

	public void removeLeft()
	{
		if (++left >= maxSize)
			left = 0;
		nItems--;
	}

	public void removeRight()
	{
		if (--right <= 0)
			right = maxSize - 1;
		nItems--;
	}

	public boolean isFull()
	{
		return (nItems==maxSize);
	}

	public boolean isEmpty()
	{
		return (nItems==0);
	}

	public void display()
    {
        int n, i=1, temp;
        temp = left;
        System.out.println("Entering for loop. nItems = " + nItems + ", left = " + left);
        for (n = 0; n < nItems; n++)
        {
           System.out.println("Element " + i++ + ": " + queArray[temp++]);
           if (temp >= maxSize)
            temp = 0;
        }
    }
}

class DequeApp
{
	public static void main(String[] args)
	{
		Deque theDeque = new Deque(20);
		System.out.println(theDeque.isFull());
		System.out.println(theDeque.isEmpty());

		for (int n = 0; n < 20; n++)
			theDeque.insertRight(n);

		theDeque.display();

		for (int n = 0; n < 5; n++)
			theDeque.removeLeft();

		theDeque.display();

		for (int n = 0; n < 5; n++)
			theDeque.removeRight();

		theDeque.display();

	}
}