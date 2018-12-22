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
            string m = Console.ReadLine();
            string s = Console.ReadLine();
            char[] a = "qwertyuiop".ToCharArray();
            char[] b = "asdfghjkl;'".ToCharArray();
            char[] c = "zxcvbnm,./".ToCharArray();
            char[] res = new char[s.Length];
            for (int i = 0; i < s.Length; i++)
            {
                for (int z = 0; z < 12 ; z++)
                {
                    if (s[i]==a[z])
                    {
                        if (m=="L")
                        {
                            res[i] = a[z + 1];
                        }
                        if (m=="R")
                        {
                            res[i] = a[z - 1];
                        }
                        break;
                    }
                    if (z < 12)
                    {
                        if (s[i] == b[z])
                        {
                            if (m == "L")
                            {
                                res[i] = b[z + 1];
                            }
                            if (m == "R")
                            {
                                res[i] = b[z - 1];
                            }
                            break;
                        }
                    }
                    if (z < 11)
                    {
                        if (s[i] == c[z])
                        {
                            if (m == "L")
                            {
                                res[i] = c[z + 1];
                            }
                            if (m == "R")
                            {
                                res[i] = c[z - 1];
                            }
                            break;
                        }
                    }
                }
            }
            foreach (char item in res)
            {
                Console.Write(item);
            }
        }
    }
    

     
}