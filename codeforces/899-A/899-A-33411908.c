using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp105
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int ones = 0;
            int twos = 0;
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            for (int i = 0; i < n; i++)
            {
                if (a[i] == 1)
                {
                    ones++;
                }
                else
                    twos++;
            }
            int u = Math.Min(ones, twos);
            if (ones>twos)
            {
                ones = ones - twos;
                u += ones / 3;
            }
            Console.WriteLine(u);
        }
    }
}