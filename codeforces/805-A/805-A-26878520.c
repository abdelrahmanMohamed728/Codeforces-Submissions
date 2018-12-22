using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;


namespace ConsoleApp23
{
    class Program
    {
        static void Main(string[] args)
        {
            
            int[] l = Console.ReadLine().Split().Select(int.Parse).ToArray();
            if (l[0]==l[1])
            {
                Console.WriteLine(l[0]);
            }
            else
            Console.WriteLine(2);
        }
           
    }
}