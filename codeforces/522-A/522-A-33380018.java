import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
         Hashtable<String,Integer> h = new Hashtable<>();
         int n = in.readInt();
         int q =0;
         Graph g = new Graph(n*2);
         for (int i=0;i<n;i++)
         {
             String s1 = in.readString().toLowerCase();
             String s2 = in.readString();
             String s3 = in.readString().toLowerCase();
             if (!h.containsKey(s1))
             {
                 h.put(s1,q);
                 q++;
             }
             if (!h.containsKey(s3))
             {
                 h.put(s3,q);
                 q++;
             }
             addEdgeDir(g,h.get(s3),h.get(s1));
         }
         int max = 0;
         for (int i=0;i<n*2;i++)
         {
             max= Math.max(max,DFS(g,i));
         }

        out.printLine(max);
        out.flush();
    }
static  long getMax(int[]a,int n)
{
    int value =0;


    for (int i =0;i<n;i++)
    {
        if (a[i]>value)
        {
            value = a[i];

        }
    }
    return  value;
}
static int DFS(Graph g,int v)
{
    boolean[] visited = new boolean[g.n];
    int[] Memo = new int[g.n];
    for (int i =0;i<g.n;i++)
        Memo[i]=-1;
    return DFSUtil(g,visited,v,Memo);
}
static  int DFSUtil(Graph g,boolean[] visited,int v,int[] Memo)
{
    if (Memo[v]>-1)
        return Memo[v];
    visited[v] = true;
    int max= 0;
   int i=0;
    while (i<g.adjList[v].size())
    {

     if (!visited[g.adjList[v].get(i)])
       max=Math.max(max, DFSUtil(g,visited,g.adjList[v].get(i),Memo));
     i++;

    }
    return Memo[v]= max+1;
}
  static int BFS(Graph g,int n,int start)
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