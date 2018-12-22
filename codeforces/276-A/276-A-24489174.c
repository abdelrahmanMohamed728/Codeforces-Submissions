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
            int[] q = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = q[0];
            int k = q[1];
            int[] y = new int[n];
            for (int i = 0; i < n; i++)
            {
                int[]t = Console.ReadLine().Split().Select(int.Parse).ToArray();
                if (t[1]>k)
                {
                    y[i] = t[0] - (t[1] - k);
                }
                else 
                {
                    y[i] = t[0];
                }
            }
            Console.WriteLine(y.Max());

        }
    }
}