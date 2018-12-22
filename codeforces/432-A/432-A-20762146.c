using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication13
{
   
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int n = int.Parse(s[0]);
            int k = int.Parse(s[1]);
            int y = 0;
            int[] People = new int[n];
            string[] o = Console.ReadLine().Split();
            for (int i = 0; i < n; i++)
            {
                
                People[i] = int.Parse(o[i]);
                if((5-People[i]>=k))
                {
                    y++;
                }
            }
            Console.WriteLine(y / 3);
        }
    }
}