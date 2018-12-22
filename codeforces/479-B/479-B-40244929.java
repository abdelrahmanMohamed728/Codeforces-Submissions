import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
       InputReader in = new InputReader(System.in);
       OutputWriter out = new OutputWriter(System.out);
      int n = in.nextInt();
      int k = in.nextInt();
      int[]a = new int[n];
      int[]index = new int[n];
      for (int i =0;i<n;i++)
      {
          a[i] = in.nextInt();
          index[i]=i+1;


      }
      MergeSort(a,index,0,n-1);
      int diff=a[n-1]-a[0];
      List<Integer>s = new ArrayList<>();
      List<Integer>e = new ArrayList<>();
      int cntr=0;
      while (cntr<k)
      {

          MergeSort(a,index,0,n-1);
          a[n-1]--;
          a[0]++;
          int max= getMax(a,n);
          int min = getMin(a,n);
          if (index[n-1]==index[0])
              break;
          if (max-min<=diff)
          {
              diff=max-min;
              s.add(index[n-1]);
              e.add(index[0]);
          }
          else
              break;
          cntr++;
      }
      out.printLine(diff+" "+s.size());
      for (int i =0;i<s.size();i++)
          out.printLine(s.get(i)+" "+e.get(i));
       out.flush();
    }
    static int getMax(int[]a,int n)
    {
        int max=0;
        for (int i =0;i<n;i++)
            max=Math.max(a[i],max);
        return max;
    }
    static int getMin(int[]a,int n)
    {
        int min = Integer.MAX_VALUE;
        for (int i =0;i<n;i++)
            min=Math.min(min,a[i]);
        return min;
    }
    static void MergeSort(int[] a, int[] b,  int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b,  p, q);
            MergeSort(a, b,  q + 1, r);
            Merge(a, b,  p, q, r);
        }
    }
    static void Merge(int[] a, int[] b,  int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];
        int[] R1 = new int[n1];
        int[] L1 = new int[n2];



        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];
            R1[i] = b[p + i];
        }
        R[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];
            L1[i] = b[q + i + 1];

        }
        L[n2] =Integer.MAX_VALUE;
        int n = a.length;
        int j = 0;
        int k = 0;
        for (int i = p; i <= r; i++)
        {
            if (L[j] < R[k])
            {
                a[i] = L[j];
                b[i] = L1[j];

                j++;
            }
            else
            {
                a[i] = R[k];
                b[i] = R1[k];

                k++;
            }
        }
    }
}

class pair  implements Comparable
{

    int key;
    int value;
    public pair(Object key, Object value) {

        this.key = (int)key;
        this.value=(int)value;
    }

    @Override
    public int compareTo(Object o) {
        pair temp =(pair)o;
        return  key-temp.key;
    }
}
class Graph {


    int n;
    ArrayList<Integer>[] adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
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