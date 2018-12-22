import java.util.*;
import java.io.*;


public class Main {
  static int n1;
  static int n2;
  static int k1;
  static int k2;
  static long[][][]dp;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        n1 = in.nextInt();
        n2 = in.nextInt();
        k1 =in.nextInt();
        k2 = in.nextInt();
        dp = new long[n1+1][n2+1][2];
        for (int i =0;i<n1+1;i++)
            for (int j =0;j<n2+1;j++)
                for (int k=0;k<2;k++)
                    dp[i][j][k]=-1;
        out.printLine((solve(n1,n2,0)+solve(n1,n2,1))%100000000);
        out.flush();
    }
   static long solve(int u1,int u2,int res)
   {
       if (dp[u1][u2][res]>-1)
           return dp[u1][u2][res];
       else
           dp[u1][u2][res]=Math.max(dp[u1][u2][res],0);
       if (u1==u2&&u1==0)
           return dp[u1][u2][res]=1;
  long temp=0;
       if (res==1)
       {
           if (u2==0)
               return dp[u1][u2][res]=0;
           for (int i =1;i<=Math.min(u2,k2);i++)
           {
               temp+=solve(u1,u2-i,1-res)%100000000;
           }
       }

       if (res==0)
       {
           if (u1==0)
           {
               return dp[u1][u2][res]=0;
           }
           for (int i =1;i<=Math.min(u1,k1);i++)
           {
               temp+=solve(u1-i,u2,1-res)%100000000;
           }
       }
       return dp[u1][u2][res]=temp%100000000;
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