using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;


namespace ConsoleApp23
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string s = Console.ReadLine();
            int[] l = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<int> o = new List<int>();
            for (int i = 0; i < n-1; i++)
            {
                if (s[i]=='R'&&s[i+1]=='L')
                {
                    o.Add((l[i + 1] - l[i])/2);
                }
            }
            if (o.Count==0|| o.Min() == 0)
            {
                Console.WriteLine(-1);
            }
            else
            Console.WriteLine(o.Min());
        }

       
    }
}