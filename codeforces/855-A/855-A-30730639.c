using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp79
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<string> l = new List<string>();
            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                    
                    int u = 0;
                for (int j = 0; j < l.Count; j++)
                {
                    if (l[j].Equals(s))
                    {
                        u++;
                        break;
                    }
                }
                if (u>0)
                {
                    Console.WriteLine("YES");
                }
                else
                {
                    Console.WriteLine("NO");
                }
                l.Add(s);
            }
        }
     
    }
}