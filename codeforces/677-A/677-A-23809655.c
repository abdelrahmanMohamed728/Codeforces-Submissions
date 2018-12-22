using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp4
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int n = int.Parse(s[0]);
            int h = int.Parse(s[1]);
            string[] d = Console.ReadLine().Split();
            int u = 0;
            int y = n;
            for (int i = 0; i < n; i++)
            {
                u = int.Parse(d[i]);
                if (u>h)
                {
                    y++;
                }
            }
            Console.WriteLine(y);
           
        }
    }
    

     
}