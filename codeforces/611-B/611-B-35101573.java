import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        long a = in.nextLong();
        long b = in.nextLong();
        long n = DecimalToBinary(a).length();
        boolean check = false;
        long ans=0;
        while(true) {
            for (long i = 1; i <n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        s += '0';
                    else
                        s += '1';
                }
                long h = BinaryToDecimal(s);
                if (h>=a&&h<=b)
                    ans++;
                if (h>b)
                {
                    check = true;
                    break;
                }


            }
            if (check)
            {
                out.printLine(ans);
                break;
            }
            n++;
        }

        out.flush();
    }
    static String DecimalToBinary(long a)
    {
        String s="";
        while(a>0)
        {
            if (a%2==0)
                s+='0';
            else
                s+='1';
            a/=2;

        }
        return s;
    }
    static long BinaryToDecimal(String a)
    {
        int n = a.length();
        long b =0;
        for (int i=0;i<n;i++)
        {
            b+=(a.charAt(i)-48)*Pow(2,n-i-1);
        }
        return b;
    }
    static long Pow(long a,long b)
    {
        long ans=1;
        for (int i=0;i<b;i++)
        {
            ans*=a;
        }
        return  ans;
    }
    static void MergeSort(int[] a,int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a,  p, q);
            MergeSort(a, q + 1, r);
            Merge(a,  p, q, r);
        }
    }
    static void Merge(int[] a,  int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];

        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];

        }
        R[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];

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

                j++;
            }
            else
            {
                a[i] = R[k];

                k++;
            }

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