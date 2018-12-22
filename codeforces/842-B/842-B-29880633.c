using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp66
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int r = inp0[0];
            int d = inp0[1];
            int radius =r - d;
            int n = int.Parse(Console.ReadLine());
            int u = 0;
            for (int i = 0; i < n; i++)
            {
                int[] inp1 = Console.ReadLine().Split().Select(int.Parse).ToArray();
                int x = inp1[0];
                int y = inp1[1];
                int r1 = inp1[2];
                double dist = Math.Sqrt((x * x) + (y * y));
                if (dist>=(r1+radius)&&dist+r1<=r)
                {
                    u++;
                }
            }
            Console.WriteLine(u);
        }
    }
}