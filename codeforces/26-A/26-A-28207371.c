using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp37
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
          
            int c = 0;
            if (n < 4)
            {
                Console.WriteLine(0);
            }
            else
            {

                List<int> primes = new List<int>();
                for (int i = 2; i < n; i++)
                {
                    int sqrt = Convert.ToInt32(Math.Sqrt(i));
                    bool check = true;
                    for (int j = 2; j <= sqrt; j++)
                    {
                        if (i%j==0)
                        {
                            check = false;
                            break;
                        }
                    }
                    if (check)
                    {
                        primes.Add(i);
                    }

                }
                for (int i = 4; i <= n; i++)
                {
                    int u = 0;
                    int sqrt = Convert.ToInt32(Math.Sqrt(i));
                    for (int j = 0; j < primes.Count ; j++)
                    {
                        if (i%primes[j]==0)
                        {
                            u++;
                        }
                    }
                    if (u==2)
                    {
                        c++;
                    }
                }
                Console.WriteLine(c);
            }
        }
    }
}