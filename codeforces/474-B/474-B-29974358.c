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
            int n = int.Parse(Console.ReadLine());
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int m = int.Parse(Console.ReadLine());
            int[] b = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int sum = a.Sum();
            int counter = 0;
            int s = a[0];
            int i = 0;
            int[] nums = new int[1000001];
            while (counter<sum)
            {
                if (counter==s)
                {
                    i++;
                    s += a[i];
                }
                nums[counter+1] += i+1;
                counter++;
            }
            for (int j = 0; j < m; j++)
            {
                Console.WriteLine(nums[b[j]]);
            }
        }
    }
}