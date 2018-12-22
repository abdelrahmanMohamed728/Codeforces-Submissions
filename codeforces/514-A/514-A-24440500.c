using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp9
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] s = Console.ReadLine().ToCharArray();
            int[] p = new int[s.Length];
            for (int i = 0; i < s.Length; i++)
            {
                p[i] = Convert.ToInt32(s[i]);
                p[i] = p[i] - 48;
                if ( (i==0)&&(p[i]==9))
                {
                    
                    continue;
                }
                if (p[i]>4)
                {
                    p[i] = 9 - p[i];
                }
               
            }
            foreach (int item in p)
            {
                Console.Write(item);
            }
            
        }
    }
}