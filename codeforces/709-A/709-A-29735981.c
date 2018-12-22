using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp62
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int b = inp0[1];
            int d = inp0[2];
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int size = 0;
            int counter = 0;
            for (int i = 0; i < n; i++)
            {
                if (a[i]<=b)
                {
                    size += a[i];
                    if (size>d)
                    {
                        counter++;
                        size = 0;
                    }
                }
                
            }
            Console.WriteLine(counter);
        }
    }
}