using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    class test
    {
       
    }
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split('+');
            int[] sint = new int[s.Length];
            for (int i = 0; i < s.Length; i++)
            {
                sint[i] = int.Parse(s[i]);
            }
            Array.Sort(sint);
            for (int i = 0; i < sint.Length; i++)
            {
                if (i==sint.Length-1)
                {
                    Console.Write(sint[i]);
                }
                else
                {
                    Console.Write(sint[i] + "+");
                }
            }
        }
    }
}