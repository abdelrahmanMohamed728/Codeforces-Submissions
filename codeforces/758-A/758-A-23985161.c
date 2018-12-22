using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            int[] p = new int[s.Length];
            for (int i = 0; i <= n-1; i++)
            {
                p[i] = int.Parse(s[i]);
            }
            Array.Sort(p);
            int y = 0;
            for (int i = 0; i <=n-2; i++)
            {
                y += (p[n-1] - p[i]);
            }
            Console.WriteLine(y);
        }
    }
}