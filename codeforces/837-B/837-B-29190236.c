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
            char[,] mat = new char[n, m];
            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                for (int j = 0; j < m; j++)
                {
                    mat[i, j] = s[j];
                }
            }
            bool t1 = false;
            bool t2 = false;
            if (n%3==0)
            {
                int[] ans = new int[3];
                for (int i = 0; i < n/3; i++)
                {
                    for (int j = 0; j < m; j++)
                    {
                        if (mat[i,j]=='B')
                        {
                            ans[0]++;
                        }
                        else if (mat[i,j]=='R')
                        {
                            ans[1]++;
                        }
                        else
                        {
                            ans[2]++;
                        }
                    }
                }
                int u = 0;
                for (int i = 0; i < 3; i++)
                {
                    if (ans[i]>0)
                    {
                    u++;
                    }
                }
                if (u > 1)
                {
                    t1 = false;
                }
                else
                {
                    for (int i = n / 3; i < (n / 3) * 2; i++)
                    {
                        for (int j = 0; j < m; j++)
                        {
                            if (mat[i, j] == 'B')
                            {
                                ans[0]++;
                            }
                            else if (mat[i, j] == 'R')
                            {
                                ans[1]++;
                            }
                            else
                            {
                                ans[2]++;
                            }
                        }
                    }
                    u = 0;
                    for (int i = 0; i < 3; i++)
                    {
                        if (ans[i] > 0)
                        {
                            u++;
                        }
                    }
                    if (u > 2 || u == 1 || (ans[0] != ans[1] && ans[0] != ans[2] && ans[1] != ans[2]))
                    {
                        t1 = false;
                    }
                    else
                    {
                        for (int i = n / 3 * 2; i < n; i++)
                        {
                            for (int j = 0; j < m; j++)
                            {
                                if (mat[i, j] == 'B')
                                {
                                    ans[0]++;
                                }
                                else if (mat[i, j] == 'R')
                                {
                                    ans[1]++;
                                }
                                else
                                {
                                    ans[2]++;
                                }
                            }
                        }
                    }
                    u = 0;
                    for (int i = 0; i < 3; i++)
                    {
                        if (ans[i] > 0)
                        {
                            u++;
                        }
                    }
                    if (u != 3||(ans[0] != ans[1] || ans[0] != ans[2] || ans[1] != ans[2]))
                    {
                        t1 = false;
                    }
                    else
                    {
                        t1 = true;
                        Console.WriteLine("YES");
                    }
                }
            }
             if (m%3==0&&!t1)
            {
                int[] ans = new int[3];
               
                for (int i = 0; i < m / 3; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        if (mat[j, i] == 'B')
                        {
                            ans[0]++;
                        }
                        else if (mat[j, i] == 'R')
                        {
                            ans[1]++;
                        }
                        else
                        {
                            ans[2]++;
                        }
                    }
                }
                int u = 0;
                for (int i = 0; i < 3; i++)
                {
                    if (ans[i] > 0)
                    {
                        u++;
                    }
                }
                if (u > 1)
                {
                    t1 = false;
                }
                else
                {
                    for (int i = m/3; i < m/3*2; i++)
                    {
                        for (int j = 0; j < n; j++)
                        {
                            if (mat[j, i] == 'B')
                            {
                                ans[0]++;
                            }
                            else if (mat[j, i] == 'R')
                            {
                                ans[1]++;
                            }
                            else
                            {
                                ans[2]++;
                            }
                        }
                    }
                    u = 0;
                    for (int i = 0; i < 3; i++)
                    {
                        if (ans[i] > 0)
                        {
                            u++;
                        }
                    }
                    if (u !=2|| (ans[0] != ans[1] && ans[0] != ans[2] && ans[1] != ans[2]))
                    {
                        t1 = false;
                    }
                    else
                    {
                        for (int i = m / 3*2; i < m; i++)
                        {
                            for (int j = 0; j < n; j++)
                            {
                                if (mat[j, i] == 'B')
                                {
                                    ans[0]++;
                                }
                                else if (mat[j, i] == 'R')
                                {
                                    ans[1]++;
                                }
                                else
                                {
                                    ans[2]++;
                                }
                            }
                        }
                        u = 0;
                        for (int i = 0; i < 3; i++)
                        {
                            if (ans[i] > 0)
                            {
                                u++;
                            }
                        }
                        if (u != 3||(ans[0] != ans[1] || ans[0] != ans[2] || ans[1] != ans[2]))
                        {
                            t1 = false;
                        }
                        else
                        {
                            t2 = true;
                            Console.WriteLine("YES");
                        }
                    }
                }
            }
            if (!t1&&!t2)
            {
                Console.WriteLine("NO");
            }
        }
    }
}