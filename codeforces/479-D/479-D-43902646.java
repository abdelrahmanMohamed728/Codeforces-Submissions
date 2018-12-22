import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
       int l = in.nextInt();
       int x = in.nextInt();
       int y = in.nextInt();
       int[] a= new int[n];
       for (int i =0;i<n;i++)
           a[i]=in.nextInt();
       boolean check1=false;
       boolean check2= false;
       for (int i =0;i<n&&(!check1||!check2);i++)
       {
           if (Arrays.binarySearch(a,a[i]-x)>=0)
           {
               check1=true;
           }
           if (Arrays.binarySearch(a,a[i]-y)>=0)
           {
               check2=true;
           }
       }
       if (check1||check2)
       {
           if (!check1)
           {
               out.printLine(1);
               out.printLine(x);
           }
           else if (!check2)
           {
               out.printLine(1);
               out.printLine(y);
           }
           else
               out.printLine(0);
       }
       else
       {

               for (int i =0;i<n;i++)
               {
                   if (Arrays.binarySearch(a, a[i] - (x + y)) >= 0)
                   {
                       out.printLine(1);
                       out.printLine(a[i]-(x));
                       check1=true;
                       break;

                   }
               }
               if (!check1) {
                   for (int i = 0; i < n; i++) {
                       if (Arrays.binarySearch(a, a[i] - (y - x)) >= 0) {
                           if (a[i] + x <= l) {
                               out.printLine(1);
                               out.printLine(a[i] + x);
                               check1 = true;
                               break;
                           }
                           else if (a[i]-y>=0)
                           {
                               out.printLine(1);
                               out.printLine(a[i] - y);
                               check1 = true;
                               break;
                           }
                       }

                   }

               }
               if(!check1)    {
                   out.printLine(2);
                   out.printLine(x + " " + y);
               }



       }
        out.flush();
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