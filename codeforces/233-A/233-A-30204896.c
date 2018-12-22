using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp74
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            if (n%2==1)
            {
                Console.WriteLine(-1);
            }
            else
            {
                List<int> l = Solve(n);
                foreach (int item in l)
                {
                    Console.Write(item + " ");
                }
            }
        }
        static List<int> Solve(int n)
        {
            List<int> l = new List<int>();
            int counter = 1;
            while (counter+1<=n)
            {
                l.Add(counter + 1);
                l.Add(counter);
                counter += 2;
            }
            return l;
        }
        
        
    }

}