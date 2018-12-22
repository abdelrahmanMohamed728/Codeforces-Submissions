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
            int x = int.Parse(Console.ReadLine());
            int y = 0;
            int i = 0;
            for ( i = 0; i < x; i+=5)
            {
                y++;
            }
            if(i<x)
            {
                y++;
            }
            Console.WriteLine(y);
        }
    }
}