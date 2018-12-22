import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
         int n = in.nextInt();
         int[]c =new int[n];
         int[]p = new int[n];
         int[]index1 = new int[n];

         for (int i=0;i<n;i++)
         {
             c[i]  = in.nextInt();
             p[i]= in.nextInt();
             index1[i]=i+1;

         }
         int k = in.nextInt();
         int[]s = new int[k];
         int[]index2=  new int[k];
         boolean[]check1= new boolean[n];
         boolean[]check2 = new boolean[k];
         for (int i =0;i<k;i++)
         {
             s[i]= in.nextInt();
             index2[i] = i;

         }
         List<Integer> l1 = new ArrayList<>();
         List<Integer>l2= new ArrayList<>();
         long sum=0;
         MergeSort(p,c,index1,0,n-1);
         MergeSort1(s,index2,0,k-1);
         for (int i=n-1;i>=0;i--)
         {
             for (int j=c[i];j<=1000;j++)
             {
                 for (int u=k-1;u>=0;u--)
                 {
                     if (s[u]==j&&!check2[u])
                     {
                         check2[u]=true;
                         sum+=(long)p[i];
                         check1[i]=true;
                         l1.add(index1[i]);
                         l2.add(index2[u]+1);
                         break;
                     }
                 }
                 if (check1[i])
                     break;
             }
         }
         out.printLine(l1.size()+" "+sum);
         for (int i =0;i<l1.size();i++)
         {
             out.printLine(l1.get(i)+" "+l2.get(i));
         }
        out.flush();
    }
    static void MergeSort1(int[] a, int[] b, int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort1(a, b,  p, q);
            MergeSort1(a, b,  q + 1, r);
            Merge1(a, b,  p, q, r);
        }
    }
    static void Merge1(int[] a, int[] b, int p, int q, int r)
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
    static void MergeSort(int[] a, int[] b, int[] c, int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b, c, p, q);
            MergeSort(a, b, c, q + 1, r);
            Merge(a, b, c, p, q, r);
        }
    }
    static void Merge(int[] a, int[] b, int[] c, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];
        int[] R1 = new int[n1+1];
        int[] L1 = new int[n2+1];

        int[] R2 = new int[n1];
        int[] L2 = new int[n2];
        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];
            R1[i] = b[p + i];
            R2[i] = c[p + i];
        }
        R[n1] = Integer.MAX_VALUE;
        R1[n1]=Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];
            L1[i] = b[q + i + 1];
            L2[i] = c[q + i + 1];
        }
        L[n2] =Integer.MAX_VALUE;
        L1[n2]=Integer.MAX_VALUE;
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
            else if (L[j]>R[k])
            {
                a[i] = R[k];
                b[i] = R1[k];
                c[i] = R2[k];
                k++;
            }
            else
            {
                if (L1[j] < R1[k])
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