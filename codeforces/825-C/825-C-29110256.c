using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp55
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int k = inp0[1];
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();


            int limit = 2 * k;

            Array.Sort(a);
            int u = 0;
            for (int i = 0; i < a.Length; i++)
            {
                if (limit<a[i])
                {
                    while (limit<a[i])
                    {
                        limit *= 2;
                        u++;
                    }
                }
                
                    if (a[i]*2>limit)
                    {
                        limit = a[i] * 2;
                    }
                
               
            }
            Console.WriteLine(u);
        }
    }
}