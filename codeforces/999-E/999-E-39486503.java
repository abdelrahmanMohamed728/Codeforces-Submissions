import java.util.*;
import java.io.*;

public class Main {
    static Graph g;
    static int n;
    static boolean[]visited;
    static int cntr;
    public static void main(String[] args)
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        n = in.nextInt();
        g= new Graph(n+1);
        visited = new boolean[n+1];
        int m = in.nextInt();
        int s = in.nextInt();
        for (int i =0;i<m;i++)
        {
            g.adjList[in.nextInt()].add(in.nextInt());

        }
        BFS(s);
        cntr=0;
        for (int i =1;i<=n;i++)
        {
            if (!visited[i]&&i!=s)
                cntr++;
        }
        PriorityQueue<pair> p =new PriorityQueue<>();
        for (int i =1;i<n+1;i++)
            if (!visited[i]&&i!=s)
                p.add(new pair(-BFS2(i),i));
        while (!p.isEmpty())
        {
            pair temp = p.poll();
            if (!visited[temp.y])
                BFS3(temp.y);
        }
        out.printLine(cntr);
        out.flush();
    }
    static int BFS3(int start)
    {

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int counter =0;
        while(!q.isEmpty())
        {
            int index = q.poll();

            for (int i=0;i<g.adjList[index].size();i++ )
            {

                if (!visited[g.adjList[index].get(i)]) {
                    visited[g.adjList[index].get(i)] = true;
                    q.add(g.adjList[index].get(i));
                    cntr--;
                }
            }

        }
        return  counter;
    }
    static int BFS2(int start)
    {
        boolean[]v =new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        v[start] = true;
        q.add(start);
        int counter =0;
        while(!q.isEmpty())
        {
            int index = q.poll();

            for (int i=0;i<g.adjList[index].size();i++ )
            {

                if (!visited[g.adjList[index].get(i)]&&!v[g.adjList[index].get(i)]) {

                    q.add(g.adjList[index].get( i));
                    v[g.adjList[index].get(i)]=true;
                    counter++;
                }
            }

        }
        return  counter;
    }
    static int BFS(int start)
    {

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int counter =0;
        while(!q.isEmpty())
        {
            int index = q.poll();

            for (int i=0;i<g.adjList[index].size();i++ )
            {

                if (!visited[g.adjList[index].get(i)]) {
                    visited[g.adjList[index].get(i)] = true;
                    q.add(g.adjList[index].get(i));
                    counter++;
                }
            }

        }
        return  counter;
    }

}

class pair  implements Comparable
{

    int x;
    int y;
    public pair(Object key, Object value) {

        this.x = (int)key;
        this.y=(int)value;
    }

    @Override
    public int compareTo(Object o) {
        pair temp =(pair)o;
        return  x-temp.x;
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