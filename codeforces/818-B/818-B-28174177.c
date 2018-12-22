using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp35
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int m = inp0[1];
            int[] s = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<int> l = new List<int>();
            int[] a = new int[n];
            bool check = true;
            int[] numbers = new int[n + 1];
            for (int i = 0; i < m - 1; i++)
            {

                if (s[i + 1] > s[i])
                {
                    if (a[s[i] - 1] > 0)
                    {
                        int e = (s[i + 1] - s[i]) % n;
                        if (e == 0)
                        {
                            e = n;
                        }
                        if (e != a[s[i] - 1])
                        {
                            check = false;
                            break;
                        }
                    }
                    else
                    {
                        a[s[i] - 1] = (s[i + 1] - s[i]) % n;
                        if (a[s[i] - 1]==0)
                        {
                            a[s[i] - 1] = n;
                        }
                        numbers[a[s[i] - 1]]++;
                    }

                }
                else
                {
                    if (a[s[i] - 1] > 0)
                    {
                        int e = n - s[i];
                        e += s[i + 1];
                        e = e % n;
                        if (e==0)
                        {
                            e = n;
                        }
                        if (e != a[s[i] - 1])
                        {
                            check = false;
                            break;
                        }
                    }
                    a[s[i] - 1] = n - s[i];
                    a[s[i] - 1] += s[i + 1];
                    a[s[i] - 1] = a[s[i] - 1] % n;
                    if (a[s[i] - 1] == 0)
                    {
                        a[s[i] - 1] = n;
                    }
                    numbers[a[s[i] - 1]]++;
                }
            }
            if ( !check)
            {
                Console.WriteLine(-1);
            }

            else
            {
                List<int> li = new List<int>();
                for (int i = 1; i < n+1; i++)
                {
                    if (numbers[i]==0)
                    {
                        li.Add(i);
                    }
                }
                int count = 0; 
                for (int i = 0; i < n; i++)
                {
                    if (a[i]==0)
                    {
                        a[i] = li[count];
                        count++;
                    }

                }
                if (a.Distinct().Count() != n)
                {
                    Console.WriteLine(-1);
                }
                else
                {
                    for (int i = 0; i < n; i++)
                    {
                        Console.Write(a[i] + " ");
                    }
                }
            }
        }



    }
}