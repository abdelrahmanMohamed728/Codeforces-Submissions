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
            int r = int.Parse(s[0]);
            int b = int.Parse(s[1]);
            int e1 = 0;
            int e2 = 0;
            if (r>b)
            {
                e1 = b;
                e2 = (r - b) / 2;
            }
            else
            {
                e1 = r;
                e2 = (b - r) / 2;
            }
            Console.WriteLine("{0} {1}", e1, e2);
            


        }
    }
    

     
}