import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
       String[]s1 = new String[n];
       String[]t1 = new String[n];
       int[]index = new int[n];
       for (int i =0;i<n;i++)
       {
           s1[i]=in.readString();
           t1[i]=in.readString();

       }
       for (int i =0;i<n;i++)
           index[i]=in.nextInt()-1;
       String[]s =new String[n];
       String[]t = new String[n];
       for (int i =0;i<n;i++)
       {
           s[i]=s1[index[i]];
           t[i]=t1[index[i]];
       }
       int[]chosen = new int[n];
       chosen[0]=check(s[0],t[0]);
       boolean check= true;
       for (int i =1;i<n;i++)
       {
           int c1=0;
           int c2=0;
           if (chosen[i-1]==0) {
               c1 = check(s[i - 1],s[i]);
               c2 = check(s[i-1],t[i]);
           }
           else
           {
               c1 = check(t[i - 1],s[i]);
               c2 = check(t[i-1],t[i]);
           }
           if (c1!=c2)
           {
               if (c1==0)
               {
                   chosen[i]=0;

               }
               else
                   chosen[i]=1;
           }
           else
           {
               if (c1==1)
               {
                   check=false;
                   break;
               }
               else
               {
                   int y = check(s[i],t[i]);
                   chosen[i]=y;
               }
           }
       }
       out.printLine(check?"YES":"NO");
        out.flush();
    }
    static int check(String a,String b)
    {
        int min = Math.min(a.length(),b.length());
        for (int i =0;i<min;i++)
        {
            if (a.charAt(i)>b.charAt(i))
                return 1;
            if (a.charAt(i)<b.charAt(i))
                return 0;
        }
        if (a.length()>b.length())
            return 1;
        else
            return 0;
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
    ArrayList<pair>[] adjList;

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