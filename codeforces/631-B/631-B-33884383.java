import java.util.*;
import java.io.*;

public class Main {
    static  Graph g;

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
       int n = in.readInt();
       int m = in.readInt();
       int k = in.readInt();
      int[] rows = new int[n];
      int[] cols = new int[m];
       Hashtable<Integer,Integer> row = new Hashtable<>();
       Hashtable<Integer,Integer> col = new Hashtable<>();

       for (int i=0;i<k;i++)
       {
           int r = in.readInt();
           int a = in.readInt();
           int c = in.readInt();
           if (r==1)
           {


                   row.put(a-1,i);

               rows[a-1]= c;
           }
           else
           {

                   col.put(a-1,i);

               cols[a-1] = c;
           }



       }
       for (int i =0;i<n;i++)
       {
           for (int j =0;j<m;j++)
           {

               if (!row.containsKey(i)&&!col.containsKey(j))
                   out.print(0+" ");
              else if (row.containsKey(i)&&(!col.containsKey(j)||row.get(i)>col.get(j)))
                   out.print(rows[i]+" ");
               else
                   out.print(cols[j]+" ");
           }
           out.printLine();

       }
       out.flush();
    }



    static void addEdgeUni(int i,int j)
    {
        g.adjList[i].addFirst(j);
        g.adjList[j].addFirst(i);

    }
    static void addEdgeDir(int i,int j)
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