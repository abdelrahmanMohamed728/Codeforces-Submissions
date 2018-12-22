using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp61
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(a);
            bool check = true;
            if (a[n]==a[n-1])
            {
                check = false;
            }
            Console.WriteLine(check?"YES":"NO");
        }
    }
}