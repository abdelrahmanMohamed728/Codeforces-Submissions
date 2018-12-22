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
            ulong[] s = Console.ReadLine().Split().Select(ulong.Parse).ToArray();
            int[] r = new int[n];
            int p = 0;
            for (int i = 0; i < n; i++)
            {
                if (i==0)
                {
                    r[p]++;
                    continue;
                }
                else if(s[i]>=s[i-1])
                {
                    r[p]++;
                }
                else
                {
                    p++;
                    r[p]++;
                }
            }
            Console.WriteLine(r.Max());
            

         
            
        }
    }
}