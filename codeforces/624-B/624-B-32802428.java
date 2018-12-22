import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.readInt();
        int[] a= new int[n];
        for (int i =0;i<n;i++)
            a[i]= in.readInt();
        Arrays.sort(a);
        for (int i=n-1;i>0;i--)
        {
            if (a[i]<=a[i-1])
                a[i-1]=Math.max(0,a[i]-1);

        }
        out.printLine(getSum(a,n));
        out.flush();
    }
static  long getSum(int[]a,int n)
{
    long sum =0;
    for (int i =0;i<n;i++)
        sum+=(long)a[i];
    return  sum;
}


  static int BFS(Graph g,int n,int start)
   {
       boolean[]visited = new boolean[n];
       Queue<Integer> q = new LinkedList<>();
       visited[start] = true;
       q.add(start);
       int counter =0;
       while(!q.isEmpty())
       {
           int index = q.poll();
counter++;
           for (int i=0;i<g.adjList[index].size();i++ )
           {

               if (!visited[g.adjList[index].get(i)]) {
                   visited[g.adjList[index].get(i)] = true;
                   q.add(g.adjList[index].get(i));
               }
           }
       }
       return  counter;
   }

   static void addEdgeUni(Graph g ,int i,int j)
   {
       g.adjList[i].addFirst(j);
       g.adjList[j].addFirst(i);
   }
   static void addEdgeDir(Graph g ,int i,int j)
   {
       g.adjList[i].addFirst(j);
   }

    static    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static   void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle polong
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
class Graph {


    int n;
    LinkedList<Integer>[] adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new LinkedList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new LinkedList<>();
    }

}
class LazySegmentTree
{
    final int MAX = 1000;        // Max tree size
    int tree[] = new int[MAX];  // To store segment tree
    int lazy[] = new int[MAX];  // To store pending updates

    /*  si -> index of current node in segment tree
        ss and se -> Starting and ending indexes of elements for
                     which current nodes stores sum.
        us and eu -> starting and ending indexes of update query
        ue  -> ending index of update query
        diff -> which we need to add in the range us to ue */
    void updateRangeUtil(int si, int ss, int se, int us,
                         int ue, int diff)
    {
        // If lazy value is non-zero for current node of segment
        // tree, then there are some pending updates. So we need
        // to make sure that the pending updates are done before
        // making new updates. Because this value may be used by
        // parent after recursive calls (See last line of this
        // function)
        if (lazy[si] != 0)
        {
            // Make pending updates using value stored in lazy
            // nodes
            tree[si] += (se - ss + 1) * lazy[si];

            // checking if it is not leaf node because if
            // it is leaf node then we cannot go further
            if (ss != se)
            {
                // We can postpone updating children we don't
                // need their new values now.
                // Since we are not yet updating children of si,
                // we need to set lazy flags for the children
                lazy[si * 2 + 1] += lazy[si];
                lazy[si * 2 + 2] += lazy[si];
            }

            // Set the lazy value for current node as 0 as it
            // has been updated
            lazy[si] = 0;
        }

        // out of range
        if (ss > se || ss > ue || se < us)
            return;

        // Current segment is fully in range
        if (ss >= us && se <= ue)
        {
            // Add the difference to current node
            tree[si] += (se - ss + 1) * diff;

            // same logic for checking leaf node or not
            if (ss != se)
            {
                // This is where we store values in lazy nodes,
                // rather than updating the segment tree itelf
                // Since we don't need these updated values now
                // we postpone updates by storing values in lazy[]
                lazy[si * 2 + 1] += diff;
                lazy[si * 2 + 2] += diff;
            }
            return;
        }

        // If not completely in rang, but overlaps, recur for
        // children,
        int mid = (ss + se) / 2;
        updateRangeUtil(si * 2 + 1, ss, mid, us, ue, diff);
        updateRangeUtil(si * 2 + 2, mid + 1, se, us, ue, diff);

        // And use the result of children calls to update this
        // node
        tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
    }

    // Function to update a range of values in segment
    // tree
    /*  us and eu -> starting and ending indexes of update query
        ue  -> ending index of update query
        diff -> which we need to add in the range us to ue */
    void updateRange(int n, int us, int ue, int diff)  {
        updateRangeUtil(0, 0, n - 1, us, ue, diff);
    }

    /*  A recursive function to get the sum of values in given
        range of the array. The following are parameters for
        this function.
        si --> Index of current node in the segment tree.
               Initially 0 is passed as root is always at'
               index 0
        ss & se  --> Starting and ending indexes of the
                     segment represented by current node,
                     i.e., tree[si]
        qs & qe  --> Starting and ending indexes of query
                     range */
    int getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        // If lazy flag is set for current node of segment tree,
        // then there are some pending updates. So we need to
        // make sure that the pending updates are done before
        // processing the sub sum query
        if (lazy[si] != 0)
        {
            // Make pending updates to this node. Note that this
            // node represents sum of elements in arr[ss..se] and
            // all these elements must be increased by lazy[si]
            tree[si] += (se - ss + 1) * lazy[si];

            // checking if it is not leaf node because if
            // it is leaf node then we cannot go further
            if (ss != se)
            {
                // Since we are not yet updating children os si,
                // we need to set lazy values for the children
                lazy[si * 2 + 1] += lazy[si];
                lazy[si * 2 + 2] += lazy[si];
            }

            // unset the lazy value for current node as it has
            // been updated
            lazy[si] = 0;
        }

        // Out of range
        if (ss > se || ss > qe || se < qs)
            return 0;

        // At this point sure, pending lazy updates are done
        // for current node. So we can return value (same as
        // was for query in our previous post)

        // If this segment lies in range
        if (ss >= qs && se <= qe)
            return tree[si];

        // If a part of this segment overlaps with the given
        // range
        int mid = (ss + se) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    // Return sum of elements in range from index qs (query
    // start) to qe (query end).  It mainly uses getSumUtil()
    int getSum(int n, int qs, int qe)
    {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe)
        {
            System.out.println("Invalid Input");
            return -1;
        }

        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    /* A recursive function that constructs Segment Tree for
      array[ss..se]. si is index of current node in segment
      tree st. */
    void constructSTUtil(int arr[], int ss, int se, int si)
    {
        // out of range as ss can never be greater than se
        if (ss > se)
            return;

        /* If there is one element in array, store it in
         current node of segment tree and return */
        if (ss == se)
        {
            tree[si] = arr[ss];
            return;
        }

        /* If there are more than one elements, then recur
           for left and right subtrees and store the sum
           of values in this node */
        int mid = (ss + se) / 2;
        constructSTUtil(arr, ss, mid, si * 2 + 1);
        constructSTUtil(arr, mid + 1, se, si * 2 + 2);

        tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
    }

    /* Function to construct segment tree from given array.
       This function allocates memory for segment tree and
       calls constructSTUtil() to fill the allocated memory */
    void constructST(int arr[], int n)
    {
        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

}