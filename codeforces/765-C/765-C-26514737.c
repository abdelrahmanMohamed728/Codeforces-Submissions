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
            int[] inp = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int k = inp[0];
            int a = inp[1];
            int b = inp[2];
            int u = a / k + b / k;
            if ((a>=k&&b>=k)||(a%k==0&&a!=0)||(b%k==0&&b!=0))
            {
                Console.WriteLine(u);
            }
            else
            {
                Console.WriteLine(-1);
            }


        }

    }
}