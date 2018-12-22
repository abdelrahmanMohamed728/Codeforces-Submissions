using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp56
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int m = inp0[1];
            int[,] mat = new int[n, m];
            for (int i = 0; i < n; i++)
            {
                int[] temp = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int j = 0; j < m; j++)
                {
                    mat[i, j] = temp[j];
                }
            }
            List<int> primes = new List<int>();
            for (int i = 2; i <= 200000; i++)
            {
                double sqrt = Math.Sqrt(i);
                bool prime = true;
                for (int j = 2; j <= sqrt; j++)
                {
                    if (i%j==0)
                    {
                        prime = false;
                    }
                }
                if (prime)
                {
                    primes.Add(i);
                }
            }
            int[] arr = new int[n + m];
            int count = 0;
            for (int i = 0; i < n; i++)
            {
                int u = 0;
                for (int j = 0; j < m; j++)
                {
                    u += BinarySearch(primes, mat[i, j]);
                }
                arr[count] = u;
                count++;
            }
            for (int i = 0; i < m; i++)
            {
                int u = 0;
                for (int j = 0; j < n; j++)
                {
                    u += BinarySearch(primes, mat[j, i]);
                }
                arr[count] = u;
                count++;
            }
            Console.WriteLine(arr.Min());
        }
        static int BinarySearch(List<int> arr,int n)
        {
            int start = 0;
            int end =arr.Count-1;
            int mid = 0;
            int diff = 0;
            while (start<=end)
            {
                
                mid = (end + start) / 2;
                if (n<arr[mid])
                {
                    end = mid-1;
                    diff = Math.Abs(n - arr[mid]);
                }
                else if (n>arr[mid])
                {
                    start = mid+1;

                }
                else if(arr[mid]==n)
                {
                    return 0;
                }
                
            }
            return diff;
        }
    }
}