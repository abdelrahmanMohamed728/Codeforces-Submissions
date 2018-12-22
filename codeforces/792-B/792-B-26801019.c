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
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int k = inp0[1];
            int[] p = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int h = 0;
            int j = 0;
            List<int> l = new List<int>();
            for (int i = 0; i < n; i++)
            {
                l.Add(i);
            }
            for (int i = 0; i < k; i++)
            {
                j += p[i];
                j = j % l.Count;
                Console.Write(l[j]+1+" ");
                l.Remove(l[j]);
                if (j == l.Count)
                {
                    j = 0;
                }
                h = 0;
            }
        }
    }
}