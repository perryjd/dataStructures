class DequeStack
{
	private int maxSize;
	private long[] queArray;
	private int left;
	private int right;
	private int nItems;
	private int top;

	public DequeStack (int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		left = 0;
		right = -1;
		nItems = 0;
		top = 0;
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

    public long peek()
    {
    	System.out.println("cur top is " + top);
    	return queArray[top];
    }

    public void push(long j)
    {
    	insertRight(j);
    	top++;
    }

    public long pop()
    {
    	long toPop = queArray[top--];
    	removeRight();
    	return toPop;
    }
}

class DequeStackApp
{
	public static void main (String[] args)
	{
		DequeStack theStack = new DequeStack(5);
		theStack.push(5);
		theStack.push(4);
		theStack.push(3);

		System.out.println(theStack.pop());

		System.out.println(theStack.peek());

		theStack.display();
	}
}