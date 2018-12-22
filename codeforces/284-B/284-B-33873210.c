using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp73
{
    class Program
    {
        static List<int> l;
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string s = Console.ReadLine();
            int[] cntr = new int[3];
            for (int i = 0; i < n; i++)
            {
                if (s[i] == 'A')
                {
                    cntr[0]++;
                }
                else if (s[i] == 'I')
                {
                    cntr[1]++;
                }
                else
                    cntr[2]++;

            }
            if (cntr[1]==0)
            {
                Console.WriteLine(cntr[0]);
            }
            else if (cntr[1]==1)
            {
                Console.WriteLine(1);
            }
            else
                Console.WriteLine(0);
        }
        
    }
}