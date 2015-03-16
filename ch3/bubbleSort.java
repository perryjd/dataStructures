// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayBub(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void bubbleSort()
      {
      int out, in;

      for(out=nElems-1; out>1; out--)   // outer loop (backward)
         for(in=0; in<out; in++)        // inner loop (forward)
            if( a[in] > a[in+1] )       // out of order?
               swap(in, in+1);          // swap them
      }  // end bubbleSort()
//--------------------------------------------------------------
   public void dubblebubbleSort()
      {
      int out, revout, in;

      for(out=nElems-1, revout = 0; out>1; out--, revout++)
      {   // outer loop (backward)
         for(in=0; in<out; in++)
         {
            if( a[in] > a[in+1] )
            {
               swap(in, in+1);
               System.out.println("Swapping " + a[in] + " and " + a[in+1]);
            }
         }
         for (in = out; in > revout; in--)
         {
            if (a[in] < a[in-1])
            {
               swap(in, in-1);
               System.out.println("Reverse swapping " + a[in] + " and " + a[in-1]);
            }
         }
      }
   }
        // end bubbleSort()
//--------------------------------------------------------------
      public void oddEvenSort() 
      {
      int out, in, i, swaps=0, loops = 0;

      for(i = 0; i < nElems/2; i++)
      {
         for(in=0; in<nElems; in+=2)
         {
            if(in!=nElems-1 && a[in]>a[in+1])
            {
               swap(in,in+1);
               swaps++;
            }
            loops++;
         }

         display();

          for(in=1; in<nElems; in+= 2)
         {
            if(in!=nElems-1 && a[in]>a[in+1])
            {
               swap(in,in+1);
               swaps++;
            }
            loops++;
         }
      }

      System.out.println("swaps: " + swaps);
      System.out.println("loops: " + loops);
         
      }
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArrayBub
////////////////////////////////////////////////////////////////
class BubbleSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 200;            // array size
      long i;
      ArrayBub arr;                 // reference to array
      arr = new ArrayBub(maxSize);  // create the array

      for (i = 50; i > 0; i--)
         arr.insert(i);

      arr.display();                // display items

      arr.oddEvenSort();             // bubble sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
