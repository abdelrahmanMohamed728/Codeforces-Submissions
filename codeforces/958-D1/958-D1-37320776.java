import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        double[]ans = new double[n];
        HashMap<Integer,Integer> h = new HashMap<>();
        int[] index = new int[n];
        for (int i =0;i<n;i++)
        {
            String s = in.readString();
            String[] a =new String[3];
            int cntr=0;
            for (int j=0;j<3;j++)
                a[j]="";


            for (int j=0;j<s.length();j++)
            {
                if (s.charAt(j)=='+'||s.charAt(j)==')')
                    cntr++;
                else if (s.charAt(j)>=48&&s.charAt(j)<=48+9)
                    a[cntr]+=s.charAt(j)-48;
            }
            double k1 = Double.parseDouble(a[0]);
            double k2 = Double.parseDouble(a[1]);
            double k3 = Double.parseDouble(a[2]);
              ans[i]=(k1+k2)/k3;
              index[i]= i;
        }
        MergeSort(ans,index,0,n-1);
        int cntr=0;
        int[] connection = new int[n];
        connection[index[0]]=0;
        h.put(cntr,1);
        for (int i =0;i<n-1;i++)
        {
            if (ans[i]==ans[i+1])
            {

                connection[index[i+1]]=cntr;
                if (!h.containsKey(cntr))
                {
                    h.put(cntr,2);
                }
                else
                {
                    int y = h.get(cntr);
                    h.replace(cntr,y+1);
                }

            }
            else
            {
                cntr++;
                connection[index[i+1]]=cntr;
                h.put(cntr,1);
            }
        }

        MergeSort(index,ans,0,n-1);
        for (int i =0;i<n;i++)
            out.print(h.get(connection[i])+" ");

        out.flush();

    }
    static void MergeSort(int[] a, double[] b, int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b,  p, q);
            MergeSort(a, b,  q + 1, r);
            Merge(a, b,  p, q, r);
        }
    }
    static void Merge(int[] a, double[] b,  int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];
        double[] R1 = new double[n1];
        double[] L1 = new double[n2];

        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];
            R1[i] = b[p + i];
        }
        R[n1] =Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];
            L1[i] = b[q + i + 1];
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
    static void MergeSort(double[] a, int[] b,  int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b,  p, q);
            MergeSort(a, b,  q + 1, r);
            Merge(a, b,  p, q, r);
        }
    }
    static void Merge(double[] a, int[] b,  int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        double[] R = new double[n1 + 1];
        double[] L = new double[n2 + 1];
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