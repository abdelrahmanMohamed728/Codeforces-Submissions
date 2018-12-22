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
            int m = inp0[1];
            int[] h = new int[n];
            int[] v = new int[m];
            int[,] t = new int[n, m];
            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                
                for (int j = 0; j < m; j++)
                {
                    if (s[j] == '*')
                    {
                        h[i]++;
                        v[j]++;
                        t[i, j] = 1;
                    }
                }
            }
            int y = 0;
            bool f = true;
            bool br = false;
            int c = h.Sum();
            for (int i = 0; i <n ; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    y = h[i] + v[j];
                    if (t[i,j]==1)
                    {
                        y -= 1;
                    }
                    if (y==c)
                    {
                        f = false;
                        Console.WriteLine("YES");
                        Console.WriteLine(i+1+" "+(j+1));
                        br = true;
                        break;
                    }
                }
                if (br)
                {
                    break; 
                }
            }
            if (f)
            {
                Console.WriteLine("NO");
            }
        }

       
    }
}