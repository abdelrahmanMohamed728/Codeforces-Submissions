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
            int n = int.Parse(Console.ReadLine());
            char[] s1 = Console.ReadLine().ToCharArray();
            int[] i1 = new int[s1.Length];
            int e1 = 0;
            int e2 = 0;
            for (int i = 0; i < (n/2); i++)
            {
                i1[i] = Convert.ToInt32(s1[i]) - 48;
                e1 += i1[i];
            }
            for (int i = (n/2); i < n; i++)
            {
                i1[i] = Convert.ToInt32(s1[i]) - 48;
                e2 += i1[i];
            }
            for (int i = 0; i <= 9; i++)
            {
                if ((i==4)||(i==7))
                {
                    continue;
                }
                if (i1.Contains(i))
                {
                    e1 = -1;
                    break;
                }

            }
            if (e1==e2)
            {
                Console.WriteLine("YES");
            }
            else
            {
                Console.WriteLine("NO");
            }
         
            
        }
    }
}