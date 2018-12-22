import java.util.*;
import java.io.*;

public class Main {
    static Graph g;
    static int[] nodes;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.readInt();
         g = new Graph(n+1);
        for (int i =0;i<n-1;i++)
        {
            int r = in.readInt();

            addEdgeUni(g, r, (i + 2));

        }


       nodes = new int[n+1];
        for (int i =0;i<n;i++)
            nodes[i+1] = in.readInt();

        out.printLine(BFS(n+1,1)+1);
        out.flush();
    }





    static int BFS(int n,int start)
    {
        boolean[]visited = new boolean[n];
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
                    if (nodes[g.adjList[index].get(i)]!=nodes[index])
                    counter++;
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
    static  void delEdgeUni(Graph g,int i ,int j)
    {
        g.adjList[i].remove(new Integer(j));
        g.adjList[j].remove(new Integer(i));

    }
    static void addEdgeDir(Graph g ,int i,int j)
    {
        g.adjList[i].addFirst(j);
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