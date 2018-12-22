import java.util.*;
import java.io.*;


public class Main {
     static Graph g;
     static boolean[] visited;
     static int[]parent;
    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        g = new Graph(n+1);
        parent = new int[n+1];
        for (int i =1;i<=n;i++)
              parent[i]=i;
        List<Integer>r1 =new ArrayList<>();
        List<Integer>r2 = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        for (int i =0;i<n-1;i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            int p1 = getParent(x);
            int p2 = getParent(y);
            if (p1==p2)
            {
                r1.add(x);
                r2.add(y);
            }
            parent[p1]=p2;
        }
        for (int i =1;i<n;i++)
        {
            int p1 = getParent(i);
            int p2 = getParent(i+1);
            if (p1!=p2)
            {
                parent[p2]=p1;
                a1.add(i);
                a2.add(i+1);
            }
        }
        out.printLine(a1.size());
        for (int i =0;i<a1.size();i++)
        {
            out.printLine(r1.get(i)+" "+r2.get(i)+" "+a1.get(i)+" "+a2.get(i));
        }
        out.flush();
    }
    static int getParent(int i )
    {
        while (i!=parent[i])
            i=parent[i];
        return i;
    }
    static void DFS(int v)
    {
        boolean[] visited = new boolean[g.n];
        DFSUtil(v);
    }
    static  void DFSUtil(int v)
    {
        visited[v] = true;

        int i=0;
        int size = g.adjList[v].size();

        while (i<size)
        {
            int index = g.adjList[v].get(i);
            if (!visited[index])
                DFSUtil(index);
            i++;

        }
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