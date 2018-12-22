using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp56
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            int u = 0;
            int max = 0;
            for (int i = 0; i < s.Length; i++)
            {
                u = 0;
                char[] c = s[i].ToCharArray();
                for (int j = 0; j < c.Length; j++)
                {
                    int g =(int) c[j];
                    if (g<=90)
                    {
                        u++;
                    }
                    
                }
                if (u>max)
                {
                    max = u;
                }
            }
            Console.WriteLine(max);
        }
    }
}