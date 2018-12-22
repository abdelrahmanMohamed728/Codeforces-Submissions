using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace fakenews
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            string p = "heidi";
            int n = s.Length;
            int index = 0;
            int count = 0;
            for (int i = 0; i < 5; i++)
            {
                
                for (int j = index; j < n; j++)
                {
                    if (p[i]==s[j])
                    {
                        count++;
                        index = j;
                        break;
                    }
                }
            }
            if (count==5)
            {
                Console.WriteLine("YES");
            }
            else
            {
                Console.WriteLine("NO");
            }



        }
    }
}