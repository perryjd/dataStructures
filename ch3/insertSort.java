// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
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
   public void insertionSortWithStats()
      {
      int in, out, copies = 0, comps = 0;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0) {
            comps++;
            if(a[in-1] >= temp) // until one is smaller,
            {
            a[in] = a[in-1];            // shift item to right
            copies++;                   // count copy
            }
            in--;
         }
         a[in] = temp;                  // insert marked item
         }  // end for
      System.out.println("Sort complete! Copies: " + copies + ", Comparisons: " + comps);
      }  // end insertionSort()
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
            a[in] = a[in-1];            // shift item to right
            --in;                       // go left one position
            }
         a[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------
   public void insertionSortNoDups()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
            a[in] = a[in-1];            // shift item to right
            --in;                       // go left one position
            }
         a[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------
   public long median()
      {
      long median;

      if (nElems % 2 != 0)
         return a[nElems/2];
      else
         return (a[nElems/2] + a[nElems/2]) / 2;
      }
//--------------------------------------------------------------
      public void noDups()
      {
         int i, dupCount = 0, curSwap = 0, lastKnown = 0;

         insertionSort();
         for (i = 0; i < nElems; i++)
         {
            if (a[i] != a[i+1])
               lastKnown++;
            else if (a[i] == a[lastKnown])
            {
               a[i] = -1;
               dupCount++;
               lastKnown++;
            }
         }
         for (i = 0; i < nElems; i++)
         {
            if (a[i] != -1)
            {
               if (curSwap == i)
               {
                  curSwap++;
               }
               else
               {
                  swap(i, curSwap);
                  curSwap++;
               }
            }
         }
         nElems -= dupCount;
      }
//--------------------------------------------------------------
  private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
   }  // end class ArrayIns


////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

      arr.insert(1);               // insert 10 items
      arr.insert(2);
      arr.insert(3);
      arr.insert(4);
      arr.insert(5);
      arr.insert(6);
      arr.insert(8);
      arr.insert(7);
      arr.insert(9);
      arr.insert(10);

      arr.display();

      arr.insertionSortWithStats();          // insertion-sort them

      arr.display();
      arr.noDups();
      arr.display();               // display them again
      }  // end main()
   }  // end class InsertSortApp
