using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp57
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int k = inp0[1];
            long[] a = Console.ReadLine().Split().Select(long.Parse).ToArray();
            
            long temp = 0;
            int u = 0;
            long candies = 0;
            if (n * 8 < k)
            {
                Console.WriteLine(-1);
            }
            else
            {
                for (int i = 0; i < n; i++)
                {
                    u++;
                    a[i] += temp;
                   
                    if (a[i] > 8)
                    {
                        temp = a[i] - 8;
                        candies += 8;
                    }
                    else
                    {
                        temp = 0;
                        candies += a[i];
                    }
                    if (candies>=k)
                    {
                        break;
                    }


                }
                if (candies < k)
                {
                    Console.WriteLine(-1);
                }
                else
                {
                    Console.WriteLine(u);
                }
            }
        }
    }
}