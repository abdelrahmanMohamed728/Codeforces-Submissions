using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp64
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int m = inp0[1];
            int[] a = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] l = new int[m];
            Array.Reverse(a);
            for (int i = 0; i < m; i++)
            {
                l[i] = int.Parse(Console.ReadLine());
                l[i] = n - l[i]+1;
            }
          
            int[] ans = DP(a, l, n, m);
            for (int i = 0; i < m; i++)
            {
                Console.WriteLine(ans[l[i]-1]);
            }
        }
        static int[] DP(int[]a,int[]l,int n,int m)
        {
            int[] ans = new int[100001];
            int[] arr = new int[100001];
        
            for (int i = 0; i < 100001; i++)
            {
                ans[i] = -1;
                arr[i] = 0;
           
            }
           
            ans[0] = 1;
            arr[a[0]]++;
          
            for (int i = 0; i < m; i++)
            {
                ans[l[i]-1]= DPaux(a, l, l[i]-1, arr, ans);
            }
            return ans;
        }
        static int DPaux(int[]a,int[] l,int n, int[]arr, int[]ans)
        {

            if (ans[n] > -1)
            {
                return ans[n];
            }

            else
            {

                ans[n] = DPaux(a, l, n - 1, arr, ans);
                if (arr[a[n]] == 0)
                {
                    ans[n] ++;
                   
                }
                
                arr[a[n]]++;
                
                return ans[n] ;
            }
        }
    }
}