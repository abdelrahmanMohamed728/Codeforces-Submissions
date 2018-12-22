import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int[]nums = new int[26];
        String s = in.readString();
        int n = s.length();
        for (int i =0;i<n;i++)
            nums[s.charAt(i)-'a']++;
        int last=0;
        int[]ans = new int[n/2];
        int cntr=0;
        for (int i =0;i<26;i++)
        {
            if (cntr==n/2)
                break;
            if (nums[i]%2==0)
            {
                for (int j=0;j<nums[i]/2;j++) {
                    ans[cntr]=(i);
                    cntr++;
                }
                nums[i]=0;
            }
            else
            {
                boolean check=false;
                for (int j=25;j>i;j--)
                {
                    if (nums[j]%2==1)
                    {
                        last=j;
                        check=true;
                        nums[j]--;
                        break;
                    }
                }
                if (check) {
                    ans[cntr] = i;
                    cntr++;

                    for (int j = 0; j < nums[i] / 2; j++) {
                        ans[cntr] = (i);
                        cntr++;
                    }
                    nums[i] = 0;

                }
                else
                {
                    for (int j = 0; j < nums[i] / 2; j++) {
                        ans[cntr] = (i);
                        cntr++;
                    }
                    nums[i]=1;
                }
            }
        }
        Arrays.sort(ans);
        int[]b = new int[n/2];
        cntr=n/2-1;
        for (int i =0;i<n/2;i++)
        {
            b[cntr]=ans[i];
            cntr--;
        }
        for (int item:ans
             ) {
            out.print((char)(item+'a'));
        }
        if (s.length()%2==1)
        {
            for (int i =0;i<26;i++)
                if (nums[i]%2==1)
                {
                    out.print((char)(i+'a'));
                    break;
                }
        }
        for (int item:b
                ) {
            out.print((char)(item+'a'));
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