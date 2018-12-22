using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp48
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] s = Console.ReadLine().ToCharArray();
            char[] t = Console.ReadLine().ToCharArray();
            List<int> l = new List<int>();
            List<int> k = new List<int>();
            int n = s.Length;
            char[] p = new char[n];
            for (int i = 0; i < n; i++)
            {
                if (s[i]!=t[i])
                {
                    l.Add(i);
                }
                else
                {
                    k.Add(i);
                }
            }
            if (l.Count % 2 == 1)
            {
                Console.WriteLine("impossible");
            }
            else
            {
                for (int i = 0; i < l.Count; i++)
                {
                    if (i%2==0)
                    {
                        p[l[i]] = s[l[i]];
                    }
                    else
                    {
                        p[l[i]] = t[l[i]];
                    }
                }
                for (int i = 0; i < k.Count; i++)
                {
                    p[k[i]] = s[k[i]];
                }
                foreach (char item in p)
                {
                    Console.Write(item);
                }
            }
        }
    }
}