using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp73
{
    class Program
    {
       
        static void Main(string[] args)
        {
            string[] inp0 = Console.ReadLine().Split();
            string s = inp0[0];
            int n = int.Parse(inp0[1]);
            if (s.Length<=n)
            {
                Console.WriteLine(s.Length-1);
            }
            else
            {
                int zero = 0;
                int i = s.Length-1;
                int ans = 0;
                while (zero<n&&i>=0)
                {
                    if (s[i] == '0')
                    {
                        zero++;
                    }
                    else
                        ans++;
                    i--;
                }
                Console.WriteLine((zero==n)?ans:s.Length-1);
            }
            

        }
        
    }
}