import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
       char[]c = in.readString().toCharArray();
       int[]a = computeArray(c);
       int n = c.length;
       int[]nums = new int[n+1];
       for (int i =0;i<n;i++)
           if (a[i]!=0)
               nums[a[i]]++;
       nums[n]=1;

      boolean[]check = new boolean[n];
       if (a[n-1]>0)
       {

           for (int i =n;i>0;i--)
           {

               if (nums[i]!=0)
               {
                   nums[a[i-1]]+=nums[i];

               }

           }
       }
       int ans=1;
       int cntr= n;
       PriorityQueue<pair> p = new PriorityQueue<>();
        while (cntr>0)
        {
            p.add(new pair((cntr),nums[cntr]));
            cntr = a[cntr-1];
        }

        int size = p.size();
        out.printLine(size);
        for (int i =0;i<size;i++)
        {
            pair temp= p.poll();
            out.printLine(temp.key+" "+temp.value);
        }
        out.flush();
    }
    static boolean KMP(char[]c,char[]p)
    {
        int[]arr = computeArray(p);
        int n = c.length;
        int m = p.length;
        int p0=0;
        int p1=0;
        while (p0<n&&p1<m)
        {
            if (c[p0]==p[p1])
            {
                p0++;
                p1++;
            }
            else
            {
                if (p1==0)
                    p0++;
                else
                    p1=arr[p1-1];
            }
        }
        if (p1==m)
            return true;
        return false;
    }
    static int[]computeArray(char[]c)
    {
        int n = c.length;
        int[]a = new int[n];
        int p0=0;
        int p1=1;
        while (p1<n&&p0<p1)
        {
            if (c[p0]==c[p1])
            {
                a[p1]=p0+1;
                p1++;
                p0++;
            }
            else
            {
                if (p0==0)
                {
                    p1++;
                }
                else
                {
                    p0=a[p0-1];
                }
            }

        }
        return a;
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