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
            int[] s = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(s);
            int y = 0;
            int c = 0;
            for (int i = 0; i < n; i++)
            {
                if (y <= s[i])
                {
                    c++;
                    y += s[i];
                }

            }
            Console.WriteLine(c);

        }
    }
}