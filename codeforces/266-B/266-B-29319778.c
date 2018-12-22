using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp57
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int t = inp0[1];
            char[] c = Console.ReadLine().ToCharArray();
            for (int i = 0; i < t; i++)
            {
                for (int j = 0; j < n-1; j++)
                {
                    if (c[j]=='B'&&c[j+1]=='G')
                    {
                        c[j] = 'G';
                        c[j + 1] = 'B';
                        j++;
                    }
                }
            }
            foreach (char item in c)
            {
                Console.Write(item);
            }

        }
       
        
    }
}