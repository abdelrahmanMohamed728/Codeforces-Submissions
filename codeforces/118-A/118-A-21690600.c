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
            string s = Console.ReadLine();
            s = s.ToLower();
            char[] vowels = "auioey".ToCharArray();
           
            for (int i = 0; i < vowels.Length; i++)
            {
                region1:
                if (s.Contains(vowels[i]))
                {
                    s = s.Remove(s.IndexOfAny(vowels), 1);
                    goto region1; 
                   
                }
            }
            for (int i = 0; i < s.Length; i+=2)
            {
                s = s.Insert(i, ".");
            }
            Console.WriteLine(s);

            
        }
    }
}