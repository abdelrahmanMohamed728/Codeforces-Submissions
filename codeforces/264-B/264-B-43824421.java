import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        int[]a = new int[n];
        int[]nums = new int[100001];
        for (int i =0;i<n;i++)
            a[i] =in.nextInt();

        for (int i =0;i<n;i++)
        {

            int max=nums[a[i]];
            for (int j=2;j<=Math.sqrt(a[i]);j++)
            {
                if (a[i]%j==0) {
                    max = Math.max(nums[j],max);
                    max=Math.max(max,nums[a[i]/j]);
                }

            }
            for (int j=2;j<=Math.sqrt(a[i]);j++)
            {
                if (a[i]%j==0) {
                    nums[j]=Math.max(max+1,nums[j]);
                    nums[a[i]/j]=Math.max(max+1,nums[a[i]/j]);
                }

            }
            nums[a[i]]=Math.max(max+1,nums[a[i]]);
        }
        int max=0;
        for (int i =0;i<100001;i++)
            max=Math.max(nums[i],max);
        out.printLine(max);
        out.flush();

    }
    static void MergeSort(int[] a, int[] b,int[]c,  int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b,c,  p, q);
            MergeSort(a, b,  c,q + 1, r);
            Merge(a, b, c,p, q, r);
        }
    }
    static void Merge(int[] a, int[] b,int[]c,int p, int q, int r)
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
                if (L1[j] > R1[k])
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