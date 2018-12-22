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
            
            int[] y = new int[n];
            int max = 0;
            Array.Reverse(l);
            for (int i = 0; i <n; i++)
            {
                if (l[i]>max)
                {
                    max = l[i];
                    y[i] = 0;
                    continue;
                }
                else
                {
                    y[i] = max - l[i] + 1;
                    continue;
                }
            }
            Array.Reverse(y);
            foreach (int item in y)
            {
                Console.Write(item + " ");
            }
        }
     

    }
}