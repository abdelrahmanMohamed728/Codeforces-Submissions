using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp62
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inp0 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = inp0[0];
            int m = inp0[1];
            int[,] matrix = new int[n,m];
            for (int i = 0; i < n; i++)
            {
                int[] inp1 = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int j = 0; j < m; j++)
                {
                    matrix[i, j] = inp1[j];
                }
            }
            Console.WriteLine(MaxCol(matrix,n,m)+MaxRow(matrix,n,m)-(ulong)(n*m));
            
        }
        static ulong MaxRow(int[,]matrix,int n,int m)
        {
            int black = 0;
            int white = 0;
            ulong max = 0;
            
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (matrix[i,j]==1)
                    {
                        black++;

                    }
                    else
                    {
                        white++;
                    }
                }
                max += (ulong)Math.Pow(2, black) - 1;
                max += (ulong)Math.Pow(2, white) - 1;
                white = 0;
                black = 0;
            }
            return max;
        }
        static ulong  MaxCol(int[,] matrix, int n, int m)
        {
            int black = 0;
            int white = 0;
            ulong max = 0;
            
            for (int j = 0; j < m; j++)
            {
                for (int i = 0; i < n ; i++)
                {

                    if (matrix[i, j] == 1)
                    {
                        black++;

                    }
                    else
                    {
                        white++;
                    }
                }


                max +=(ulong) Math.Pow(2, black) - 1;
                max += (ulong)Math.Pow(2, white) - 1;



                white = 0;
                black = 0;
                
            }
            return max;
        }
        
        
    }
     
}