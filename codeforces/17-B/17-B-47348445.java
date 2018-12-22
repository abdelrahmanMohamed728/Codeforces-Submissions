import java.util.*;
import java.io.*;


public class Main {
    static int[] parent;
 static int[]ranks;
    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        parent = new int[n];
        ranks = new int[n];
        for (int i =0;i<n;i++)
        {
            in.nextInt();
            parent[i]=i;
        }
        int m = in.nextInt();
        int[]l = new int[m];
        int[]r = new int[m];
        int[]c = new int[m];
        for (int i =0;i<m;i++)
        {
            l[i]=in.nextInt()-1;
            r[i]=in.nextInt()-1;
            c[i]=in.nextInt();
        }
        MergeSort(c,l,r,0,m-1);
        int cntr=0;
        long sum=0;
        boolean[]visited = new boolean[n];
        for (int i=0;i<m;i++)
        {
            if (cntr==n-1)
                break;
            int p0=getParent(l[i]);
            int p1 = getParent(r[i]);
            if (p0!=p1&&!visited[r[i]])
            {
                parent[p1]=p0;
                cntr++;
                sum+=(long)c[i];
                visited[r[i]]=true;
            }
        }
        if (cntr<n-1)
        {
            out.printLine(-1);
        }
        else
            out.printLine(sum);
        out.flush();
    }
    static void MergeSort(int[] a, int[] b,int[]c,  int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a, b, c, p, q);
            MergeSort(a, b, c, q + 1, r);
            Merge(a, b, c, p,q, r);
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
                 c[i]=L2[j];
                j++;
            }
            else
            {
                a[i] = R[k];
                b[i] = R1[k];
                c[i]=R2[k];
                k++;
            }

        }
    }
 static int getParent(int i)
 {
     while (i!=parent[i])
         i=parent[i];
     return i;
 }
}
class MyScanner {

    StringTokenizer st;
    BufferedReader br;

    public MyScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public MyScanner (FileReader f) {
        br = new BufferedReader(f);
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public double nextDouble() throws IOException {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if (x.charAt(0) == '-') {
            neg = true;
            start++;
        }
        for (int i = start; i < x.length(); i++)
            if (x.charAt(i) == '.') {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            } else {
                sb.append(x.charAt(i));
                if (dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg ? -1 : 1);
    }

    public boolean ready() throws IOException {
        return br.ready();
    }

    public boolean nextEmpty() throws IOException {
        String s = nextLine();
        st = new StringTokenizer(s);
        return s.isEmpty();
    }
}


class pair  implements Comparable
{
    int key;
    int value;
    int index;
    public pair(Object key, Object value,Object index) {

        this.key = (int)key;
        this.value=(int)value;
        this.index = (int)index;
    }
    @Override
    public int compareTo(Object o) {
        pair temp =(pair)o;
        return  value-temp.value;
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