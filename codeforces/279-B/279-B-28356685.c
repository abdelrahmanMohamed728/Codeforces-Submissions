using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp39
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int k = inp0[1];
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int start = 0;
            int sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++)
            {
                sum += a[i];
                if (sum<=k)
                {
                    if (i-start+1>max)
                    {
                        max = i - start + 1;
                    }
                }
                else
                {
                    sum -= a[start];
                    start++;
                }
            }
            Console.WriteLine(max);
        }

    }
}