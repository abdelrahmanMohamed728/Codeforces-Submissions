using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp10
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] l = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int u = 0;
            int y = 0;
         
            
            for (int i = 0; i < n - 1; i++)
            {
                if (u==0&&l[i]>l[i+1]&&l[i+1]<=l[0])
                {
                    u = 1;
                    y++;
                   
                    continue;
                }
                if (u==1&&l[i]<=l[i+1]&&l[i]<=l[0])
                {
                    y++;
                    continue;
                }
                if (u == 1 &&( l[i] > l[i + 1] || l[i] > l[0]))
                {
                    y = -1;
                    break;
                }
                if (u == 0 && l[i] > l[i + 1] && l[i + 1] > l[0])
                {
                    y = -1;
                    break;
                }
            }
            if (l[n-1]>l[0]&&u==1)
            {
                y = -1;
            }
            Console.WriteLine(y);
        
          

        }


    }
}