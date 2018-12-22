using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp110
{
    class Program
    {
        static void Main(string[] args)
        {
            ulong[] inp0 = Console.ReadLine().Split().Select(ulong.Parse).ToArray();
            ulong n = inp0[0];
            ulong r = inp0[1];
            ulong avg = inp0[2];
            avg *= n;
            ulong sum = 0;
            int[] a = new int[n];
            int[] b = new int[n];
            for (uint i = 0; i < n; i++)
            {
                int[] inp1 = Console.ReadLine().Split().Select(int.Parse).ToArray();
                a[i] = inp1[0];
                b[i] = inp1[1];
                sum +=(ulong) a[i];
            }
            if (sum>=avg)
            {
                Console.WriteLine(0);
            }
            else
            {
                MergeSort(b, a, 0,(int) n - 1);
                ulong ans = 0;
                for (uint i = 0; i < n; i++)
                {
                    ulong max = (ulong)(r - (ulong)a[i]);
                    if (sum+max>=avg)
                    {
                        ans += (ulong)((avg-sum) * (ulong)b[i]);
                        break;
                    }
                    else
                    {
                        ans +=(ulong)( (max) * (ulong)b[i]);
                        sum += max;
                    }
                }
                Console.WriteLine(ans);

            }
            
        }
        
        static void MergeSort(int[] a, int[] b,  int p, int r)
        {
            if (p < r)
            {
                int q = (r + p) / 2;
                MergeSort(a, b,  p, q);
                MergeSort(a, b,  q + 1, r);
                Merge(a, b,  p, q, r);
            }
        }
        static void Merge(int[] a, int[] b, int p, int q, int r)
        {
            int n1 = q - p + 1;
            int n2 = r - q;
            int[] R = new int[n1 + 1];
            int[] L = new int[n2 + 1];
            int[] R1 = new int[n1];
            int[] L1 = new int[n2];
            
            for (int i = 0; i < n1; i++)
            {
                R[i] = a[p + i];
                R1[i] = b[p + i];
            
            }
            R[n1] = int.MaxValue;
            for (int i = 0; i < n2; i++)
            {
                L[i] = a[q + i + 1];
                L1[i] = b[q + i + 1];
               
            }
            L[n2] = int.MaxValue;
            int n = a.Length;
            int j = 0;
            int k = 0;
            for (int i = p; i <= r; i++)
            {
                if (L[j] < R[k])
                {
                    a[i] = L[j];
                    b[i] = L1[j];
              
                    j++;
                }
                else
                {
                    a[i] = R[k];
                    b[i] = R1[k];
               
                    k++;
                }

            }
        }
    }
}