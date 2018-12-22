using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication14
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] Myarray = new string[n];
            for (int i = 0; i <n ; i++)
            {
                string h = Console.ReadLine();
                if (h.Length>10)

                {
                    int o = h.Length-2;
                    string o1 = o.ToString(); 
                   h = h.Remove(1, h.Length - 2);
                    h = h.Insert(1, o1);
                    Myarray[i] = h;
                    
                }
                else
                {
                    Myarray[i] = h;
                }
            }
            foreach (string item in Myarray)
            {
                Console.WriteLine(item);
            }
        }
    }
}