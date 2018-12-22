using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp40
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            //int i = s[0] -65;
            int n = s.Length;
            int start = 0;
            int end = 0;
            bool check = false;
            for (int i = 0; i < n-25; i++)
            {
                int[] alph = new int[26];
                int q = 0;
                int a = 0;
                for (int j = i; j < i+26; j++)
                {
                    if (s[j]=='?')
                    {
                        q++;
                    }
                    else
                    {
                        if (alph[s[j] - 65]==0)
                        {
                            alph[s[j] - 65]++;
                            a++;
                        }
                    }
                    
                }
                if (a+q==26)
                {
                    start = i;
                    end = i + 26;
                    check = true;
                    break;
                }
            }
            if (!check)
            {
                Console.WriteLine(-1);
            }
            else
            {
                char[] c = new char[26];
                List<char> l = new List<char>();
                List<int> ques = new List<int>();
                for (int i = start; i < end; i++)
                {
                    c[i - start] = s[i];
                }
                char[] alphaa = "QWERTYUIOPASDFGHJKLZXCVBNM".ToCharArray();
                for (int i = 0; i < 26; i++)
                {
                    if (c[i]=='?')
                    {
                        ques.Add(i);
                    }
                    if (!c.Contains(alphaa[i]))
                    {
                        l.Add(alphaa[i]);
                    }
                }
                int h = ques.Count;
                for (int i = 0; i < h; i++)
                {
                    c[ques[i]] = l[0];
                    l.RemoveAt(0);
                }
                for (int i = 0; i < start; i++)
                {
                    if (s[i]=='?')
                    {
                        Console.Write("A");
                    }
                    else
                    {
                        Console.Write(s[i]);
                    }
                }
                for (int i = start; i < end; i++)
                {
                    Console.Write(c[i-start]);
                }
                for (int i = end; i < n; i++)
                {
                    if (s[i] == '?')
                    {
                        Console.Write("A");
                    }
                    else
                    {
                        Console.Write(s[i]);
                    }
                }

            }
            
            
        }
    }
}