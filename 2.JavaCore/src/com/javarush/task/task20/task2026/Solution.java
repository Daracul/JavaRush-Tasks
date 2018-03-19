package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int countX=0;

        for (int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if (a[i][j]==1) {
                    countX++;
                }
                int i1=i;
                int j1=j;
              for (;i1<a.length;){
                  if (a[i1][j]==1){
                      i1++;
                  }
                  else break;
              }
                for (;j1<a.length;){
                    if (a[i][j1]==1){
                        j1++;
                    }
                    else break;
                }
              for(int k=i;k<i1;k++){
                  for (int p=j;p<j1;p++){
                      a[k][p]=0;
                  }
              }

            }
        }

        return countX;
    }
}
