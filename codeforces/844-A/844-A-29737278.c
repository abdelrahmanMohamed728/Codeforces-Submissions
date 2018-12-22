using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp62
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] s = Console.ReadLine().ToCharArray();
            int n = int.Parse(Console.ReadLine());
            if (n>s.Length)
            {
                Console.WriteLine("impossible");
            }
            else
            {
                int[] alph = new int[26];
                for (int i = 0; i < s.Length; i++)
                {
                    alph[s[i] - 97]++;
                }
                int u = 0;
                for (int i = 0; i < 26; i++)
                {
                    if (alph[i]>0)
                    {
                        u++;
                    }
                }
                if (u>=n)
                {
                    Console.WriteLine(0);
                }
                else
                {
                    Console.WriteLine(n-u);
                }
            }

            
        }
    }
}