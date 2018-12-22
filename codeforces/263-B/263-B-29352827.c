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
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(a);
            if (k > n)
            {
                Console.WriteLine(-1);
            }
            else
            {
                int u = a[n - k]; 
                Console.WriteLine(u+" "+u);
            }
        }
    }
}