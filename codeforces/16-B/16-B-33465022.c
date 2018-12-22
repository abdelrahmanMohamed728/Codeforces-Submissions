using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp105
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int m = inp0[1];
            int[] x = new int[m];
            int[] y = new int[m];
            for (int i = 0; i < m; i++)
            {
                int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
                x[i] = a[0];
                y[i] = a[1];

            }
            MergeSort(y, x, 0, m - 1);
            long ans = 0;
            int j = m - 1;
            while (n>=0&&j>=0)
            {
                x[j] = Math.Min(x[j], n);
                n -= x[j];
                ans += y[j] * x[j];
                j--;
            }
            Console.WriteLine(ans);
        }
        static void MergeSort(int[] a, int[] b, int p, int r)
        {
            if (p < r)
            {
                int q = (r + p) / 2;
                MergeSort(a, b, p, q);
                MergeSort(a, b, q + 1, r);
                Merge(a, b, p, q, r);
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