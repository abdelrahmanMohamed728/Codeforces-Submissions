using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int y = 0;
            for (int m = 0; m < 1000; m++)
            {
                for (int z = 2; z < (n*m)+1; z++)
                {
                    if (((n*m)+1)%z==0)
                    {
                        y = m;
                        break;
                    }
                }
                if (y>0)
                {
                    Console.WriteLine(y);
                    break;
                }
            }
            
        }
    }
}