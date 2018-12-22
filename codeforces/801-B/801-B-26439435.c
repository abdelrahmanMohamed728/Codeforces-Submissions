using System;

namespace ConsoleApp16
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] s1 = Console.ReadLine().ToCharArray();
            char[] s2 = Console.ReadLine().ToCharArray();
            int[] r1 = new int[s1.Length];
            int[] r2 = new int[s2.Length];
            int o = s1.Length;
            
            bool check = true;
            char[] f = new char[o];
            for (int i = 0; i <o ; i++)
            {
                r1[i] = s1[i] - 97;
                r2[i] = s2[i] - 97;
            }
            for (int i = 0; i < o; i++)
            {
                if (r2[i]>r1[i])
                {
                    Console.WriteLine(-1);
                    check = false;
                    break;
                }
                else
                {
                    f[i] = s2[i];
                }
            }
            if (check)
            {
                foreach (char item in f)
                {
                    Console.Write(item);
                }
            }
            
        }
    }
}