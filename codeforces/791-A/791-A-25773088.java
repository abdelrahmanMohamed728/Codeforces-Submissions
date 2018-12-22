import java.util.Scanner;

public class Codeforces 
{

    
    public static void main(String[] args)
    {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int m = sc.nextInt();
     int[] u = new int[2];
     int y =0;
     u[0]= n;
     u[1]=m;
        for (int i =1; i < 100000; i++) {
            u[0]*=3;
            u[1]*=2;
            if (u[0]>u[1]) {
                y=i;
                System.out.println(y);
                break;
            }
        }

   
    }
    
}