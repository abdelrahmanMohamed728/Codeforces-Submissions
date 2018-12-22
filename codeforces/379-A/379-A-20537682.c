using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication12
{
    class Program
    {
        static void Main(string[] args)
        {
            
            string[] mystring = Console.ReadLine().Split();
            double a = double.Parse(mystring[0]);
            double b = double.Parse(mystring[1]);
            double y = 0;
            double o = a;
            for (int i = 0; a > 1; i++)
            {
                y = a / b;
                a = y;
                o += a;
            }
            int k = Convert.ToInt32(o);
            if (k>o)
            {
                k = k - 1;
            }
            Console.WriteLine(k);
        }
    }
}