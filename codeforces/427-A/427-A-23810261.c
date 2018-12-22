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
            int n = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            int o =0;
            int u = 0;
            int res = 0;
            for (int i = 0; i < n; i++)
            {
                u = int.Parse(s[i]);
                if (u>0)
                {
                    o += u;
                }
                else if(u<0)
                {
                    if (o>0)
                    {
                        o--;
                    }
                    else
                    {
                        res++;
                    }
                }
                
                
            }
            Console.WriteLine(res);
        }
    }
    

     
}