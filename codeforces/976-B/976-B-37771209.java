import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        long n = in.nextLong();
        long m = in.nextLong();
        long k = in.nextLong();
        if (k>=0&&k<n)
        {
            out.printLine((k+1)+" "+1);
        }
        else if (k<m+n-1)
            out.printLine(n+" "+(k+2-n));
        else if (k>=n+m-1)
        {
            k-=(n+m-1);
            long y1= k/(m-1);
            y1++;
            long y2 = k%(m-1);
            if (y1%2==0)
            y2= m-2-y2;
            out.printLine((n-y1)+" "+(m-y2));

        }
        out.flush();
    }




    static void MergeSort(int[] a, int[] b, int[] c, int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b, c,p, q);
            MergeSort(a, b, c,q + 1, r);
            Merge(a, b, c, p, q, r);
        }
    }
    static void Merge(int[] a, int[] b, int[] c, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];
        int[] R1 = new int[n1];
        int[] L1 = new int[n2];

        int[] R2 = new int[n1];
        int[] L2 = new int[n2];

        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];
            R1[i] = b[p + i];
            R2[i] = c[p + i];

        }
        R[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];
            L1[i] = b[q + i + 1];
            L2[i] = c[q + i + 1];


        }
        L[n2] = Integer.MAX_VALUE;
        int n = a.length;
        int j = 0;
        int k = 0;
        for (int i = p; i <= r; i++)
        {
            if (L[j] < R[k])
            {
                a[i] = L[j];
                b[i] = L1[j];
                c[i] = L2[j];

                j++;
            }
            else
            {
                a[i] = R[k];
                b[i] = R1[k];
                c[i] = R2[k];

                k++;
            }

        }
    }

}

class LazySegmentTree {
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
                         int ue, int diff) {
        // If lazy value is non-zero for current node of segment
        // tree, then there are some pending updates. So we need
        // to make sure that the pending updates are done before
        // making new updates. Because this value may be used by
        // parent after recursive calls (See last line of this
        // function)
        if (lazy[si] != 0) {
            // Make pending updates using value stored in lazy
            // nodes
            tree[si] += (se - ss + 1) * lazy[si];

            // checking if it is not leaf node because if
            // it is leaf node then we cannot go further
            if (ss != se) {
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
        if (ss >= us && se <= ue) {
            // Add the difference to current node
            tree[si] += (se - ss + 1) * diff;

            // same logic for checking leaf node or not
            if (ss != se) {
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
    void updateRange(int n, int us, int ue, int diff) {
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
    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // If lazy flag is set for current node of segment tree,
        // then there are some pending updates. So we need to
        // make sure that the pending updates are done before
        // processing the sub sum query
        if (lazy[si] != 0) {
            // Make pending updates to this node. Note that this
            // node represents sum of elements in arr[ss..se] and
            // all these elements must be increased by lazy[si]
            tree[si] += (se - ss + 1) * lazy[si];

            // checking if it is not leaf node because if
            // it is leaf node then we cannot go further
            if (ss != se) {
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
    int getSum(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    /* A recursive function that constructs Segment Tree for
      array[ss..se]. si is index of current node in segment
      tree st. */
    void constructSTUtil(int arr[], int ss, int se, int si) {
        // out of range as ss can never be greater than se
        if (ss > se)
            return;

        /* If there is one element in array, store it in
         current node of segment tree and return */
        if (ss == se) {
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
    void constructST(int arr[], int n) {
        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
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


class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
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