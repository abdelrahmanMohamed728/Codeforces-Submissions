using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication13
{
   
    class Program
    {
        static void Main(string[] args)
        {
            string[] Start = Console.ReadLine().Split();
            int n = int.Parse(Start[0]);
            int c = int.Parse(Start[1]);
            
            int count = 0;
            string[] Periods = Console.ReadLine().Split();
            int[] PeriodsInt = new int[n];
            for (int i = 0; i < n; i++)
            {
               PeriodsInt[i] = int.Parse(Periods[i]);
                if(i==0)
                {
                    count++;
                }
                else if (((PeriodsInt[i]-PeriodsInt[i-1])<=c)&&(i!=0))
                {
                    count++;
                }
                else if (((PeriodsInt[i] - PeriodsInt[i - 1]) > c) && (i != 0))
                {
                    count = 0;
                    count++;
                }

            }
            Console.WriteLine(count);
        }
    }
}