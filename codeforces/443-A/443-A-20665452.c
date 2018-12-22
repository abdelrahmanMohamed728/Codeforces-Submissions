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
            string s = Console.ReadLine();
            string y1 = s.Replace("{", " ");
            string y2 = y1.Replace("}", " ");
            string y3 = y2.Replace(",", " ");
            char[] p = y3.ToCharArray();
            int flag = 0;
            int y = 0;
            for (int i = 0; i < p.Length; i++)
            {
                flag = 0;
                for (int x = 0; x < i; x++)
                {
                    
                    if((p[i]==p[x])&&(x!=i))
                    {
                        break;
                    }
                    if(p[i]==' ')
                    {
                        break;
                    }
                    else
                    {
                        flag++;
                    }
                }
                if((flag==i)&&(flag!=0))
                {
                    y++;
                }
            }
            Console.WriteLine(y);
        }
    }
}