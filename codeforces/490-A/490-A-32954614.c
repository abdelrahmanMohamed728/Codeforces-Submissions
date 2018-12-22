using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp96
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] t = new int[3];
            for (int i = 0; i < n; i++)
            {
                t[a[i] - 1]++;

            }
            int cntr = t.Min();
            Console.WriteLine(cntr);
            int[] c = new int[3 * cntr];
            int[] count = new int[3];
            int[,] l = new int[3, cntr];
            for (int i = 0; i < n; i++)
            {
                if (count[a[i]-1]<cntr)
                {

                    l[a[i] - 1, count[a[i] - 1]] = i + 1;
                    count[a[i] - 1]++;
                }
            }
            for (int i = 0; i < cntr; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Console.Write(l[j, i]+" ");
                }
                Console.WriteLine();
            }
            
        }
        static void MergeSort(int[] a,  int p, int r)
        {
            if (p < r)
            {
                int q = (r + p) / 2;
                MergeSort(a,  p, q);
                MergeSort(a,  q + 1, r);
                Merge(a,  p, q, r);
            }
        }
        static void Merge(int[] a,  int p, int q, int r)
        {
            int n1 = q - p + 1;
            int n2 = r - q;
            int[] R = new int[n1 + 1];
            int[] L = new int[n2 + 1];
           
            for (int i = 0; i < n1; i++)
            {
                R[i] = a[p + i];
                
            }
            R[n1] = int.MaxValue;
            for (int i = 0; i < n2; i++)
            {
                L[i] = a[q + i + 1];
                
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
                    
                    j++;
                }
                else 
                {
                    a[i] = R[k];
                    
                    k++;
                }
              
            }
        }
    }
}