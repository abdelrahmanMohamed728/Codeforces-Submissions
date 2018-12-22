import java.util.*;
import java.io.*;


public class Main {
   static int n;
   static int k;
   static int[] ans1;
   static int[]ans2;
   static int mat [][];
    static int mat1 [][];
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        n = in.nextInt();
        k = in.nextInt();
        ans1 = new int[n];
        ans2= new int[n];
        mat = new int[n+1][901];
        mat1 = new int[n+1][901];
       if (dp(1,k)!=1||dp1(1,k)!=1)
           out.printLine(-1+" "+-1);
       else
       {
           for (int i=0;i<n;i++)
               out.print(ans1[i]);
           out.print(" ");
           for (int i=0;i<n;i++)
               out.print(ans2[i]);
       }

        out.flush();
    }
     static int dp(int index,int rem)
     {
         if (rem>=0&&mat[index][rem]!=0)
             return mat[index][rem];
         if (rem<0)
             return -1;
         if (index>1||n==1) {
             for (int j = 0; j < 10; j++) {
                 if (index < n) {
                     if (dp(index + 1, rem - j) == 1) {
                         ans1[index - 1] = j;
                         return 1;
                     }
                 } else {
                     if (rem - j == 0) {
                         ans1[index - 1] = j;
                         return mat[index][rem]=1;
                     }

                 }
             }
         }
         else
         {
             for (int j = 1; j < 10; j++) {
                 if (index < n) {
                     if (dp(index + 1, rem - j) == 1) {
                         ans1[index - 1] = j;
                         return mat[index][rem]=1;
                     }
                 } else {
                     if (rem - j == 0) {
                         ans1[index - 1] = j;
                         return mat[index][rem]=1;
                     }

                 }
             }
         }
         return mat[index][rem]=-1;
     }
    static int dp1(int index,int rem)
    {
        if (rem>=0&&mat1[index][rem]!=0)
            return mat1[index][rem];
        if (rem<0)
            return -1;
        if (index>1||n==1) {
            for (int j = 9; j >=0; j--) {
                if (index < n) {
                    if (dp1(index + 1, rem - j) == 1) {
                        ans2[index - 1] = j;
                        return mat1[index][rem]=1;
                    }
                } else {
                    if (rem - j == 0) {
                        ans2[index - 1] = j;
                        return mat1[index][rem]=1;
                    }

                }
            }
        }
        else
        {
            for (int j = 9; j >0; j--)  {
                if (index < n) {
                    if (dp1(index + 1, rem - j) == 1) {
                        ans2[index - 1] = j;
                        return mat1[index][rem]=1;
                    }
                } else {
                    if (rem - j == 0) {
                        ans2[index - 1] = j;
                        return mat1[index][rem]=1;
                    }

                }
            }
        }
        return mat1[index][rem]=-1;
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