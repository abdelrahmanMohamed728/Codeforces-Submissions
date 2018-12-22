using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp9
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp[0];
            int d = inp[1];
            int[] t = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int s = 0;
            int y = 0;
            for (int i = 0; i < n-1; i++)
            {
                s += t[i] + 10;
                y += 2;
            }
            if (s+t[n-1]>d)
            {
                Console.WriteLine(-1);
            }
            else
            {
                s += t[n - 1];
                y += (d - s) / 5;
                Console.WriteLine(y);
            }
            
        
            
            
        }
    }
}