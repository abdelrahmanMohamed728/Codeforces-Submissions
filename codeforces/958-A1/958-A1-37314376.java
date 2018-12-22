import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
          int n = in.nextInt();
         int[][]mat1 = new int[n][n];
         int[][]mat2 = new int[n][n];
         for (int i=0;i<n;i++) {
             String s = in.readString();

             for (int j = 0; j < n; j++)
                 mat1[i][j]=s.charAt(j);
         }
        for (int i=0;i<n;i++) {
            String s = in.readString();

            for (int j = 0; j < n; j++)
                mat2[i][j]=s.charAt(j);
        }
        boolean check = false;
        for (int i =0;i<4;i++)
        {
            if (isSameMatrix(n,mat1,mat2))
            {
                check=true;
                break;
            }
           mat2= rotateMatrix(n,mat2);


        }
       mat2= rotateVer(n,mat2);
        for (int i =0;i<5;i++)
        {
            if (isSameMatrix(n,mat1,mat2))
            {
                check=true;
                break;
            }
            mat2= rotateMatrix(n,mat2);


        }
       mat2= rotateHor(n,mat2);
        for (int i =0;i<5;i++)
        {
            if (isSameMatrix(n,mat1,mat2))
            {
                check=true;
                break;
            }
            mat2= rotateMatrix(n,mat2);


        }
        out.printLine(check?"Yes":"No");
        out.flush();

    }
    static boolean isSameMatrix(int n,int[][]mat1,int[][]mat2)
    {
        for (int i =0;i<n;i++)
            for (int j=0;j<n;j++)
                if (mat1[i][j]!=mat2[i][j])
                    return false;
        return true;
    }


    static int[][] rotateMatrix(int N, int mat[][])
    {
        for (int x = 0; x < N / 2; x++)
        {
            for (int y = x; y < N-x-1; y++)
            {
                int temp = mat[x][y];

                mat[x][y] = mat[y][N-1-x];

                mat[y][N-1-x] = mat[N-1-x][N-1-y];

                mat[N-1-x][N-1-y] = mat[N-1-y][x];

                mat[N-1-y][x] = temp;
            }
        }
        return mat;
    }
    static int[][]rotateVer(int n,int[][]mat)
    {
        int[][]mat3 = new int[n][n];
        for (int i =0;i<n;i++)
        {
            for (int j=0;j<n;j++)
                mat3[n-i-1][j]=mat[i][j];
        }
        return mat3;
    }
    static int[][]rotateHor(int n,int[][]mat)
    {
        int[][]mat3 = new int[n][n];
        for (int i =0;i<n;i++)
        {
            for (int j=0;j<n;j++)
                mat3[i][n-j-1]=mat[i][j];
        }
        return mat3;
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