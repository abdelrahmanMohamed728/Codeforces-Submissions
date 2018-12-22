using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace ConsoleApp37
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            char[] s = Console.ReadLine().ToCharArray();

            if (n%2==0)
            {
                for (int i = 0; i < n-2; i+=2)
                {
                    Console.Write(s[i]);
                    Console.Write(s[i + 1]);
                    Console.Write('-');
                }
                Console.Write(s[n - 2]);
                Console.Write(s[n - 1]);
            }
            else
            {
                for (int i = 0; i < n - 3; i += 2)
                {
                    Console.Write(s[i]);
                    Console.Write(s[i + 1]);
                    Console.Write('-');
                }
                Console.Write(s[n - 3]);
                Console.Write(s[n - 2]);
                Console.Write(s[n - 1]);
            }
            
        }
        

    }
}