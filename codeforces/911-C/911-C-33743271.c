using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ConsoleApp106
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(a);
            if ((a[0]==a[1]&&a[1]==a[2]&&a[0]==3)||a[0]==1||a[1]==1||a[2]==1||(a[0]==a[1]&&a[0]==2)||(a[1]==a[2]&&a[2]==4&&a[0]==2))
            {
                Console.WriteLine("YES");
            }
            else
                Console.WriteLine("NO");
        }
    }
}