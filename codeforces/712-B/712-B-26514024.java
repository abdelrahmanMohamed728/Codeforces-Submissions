import java.util.Scanner;

public class Codeforces 
{

    
    public static void main(String[] args)
    {
     Scanner sc = new Scanner(System.in);
     char[] s = sc.next().toCharArray();
     int x=0;
        int y=0;
        if (s.length%2!=0) {
            System.out.println(-1);
        }
        
        else        
        {
            for (int i = 0; i < s.length; i++) {
                switch (s[i])
                {
                    case 'U':
                        y++;
                        break;
                    case 'D':
                    y--;
                    break;
                    case 'R':
                        x++;
                    break;
                    case 'L':
                        x--;
                        break;
                }
                
            }
            if (x%2==0&&y%2==0) {
                System.out.println(Math.abs(x/2)+Math.abs(y/2));
            }
            
            else        
            {
                int r= Math.abs(x)+Math.abs(y);
                System.out.println(r/2);
            }
        }

   
    }
    
}