package array;

import java.util.Scanner;
import java.util.Arrays;

public class _5螺旋矩阵Ⅱ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        generateMatrixSolution solution = new generateMatrixSolution();
        arr = solution.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=n-1){
                    System.out.print(arr[i][j]+",");
                }else{
                    System.out.print(arr[i][j]);
                }
                
            }
            System.out.println();
        }
        sc.close();
    }
}
//写得太慢了！！！！！！呜呜呜呜呜
class generateMatrixSolution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int row = n-1; //用于记录每一行有多少个元素
        int col = n-1;
        int num = 1; //用于填充数组
        for(int i=0;i<n/2;i++){
            //行首j
            for(int j=i;j<=row-i;j++){
                arr[i][j] = num;  
                num++;  
            }
            //列尾
            for(int j=i+1;j<=col-1-i;j++){
                arr[j][n-1-i] = num;
                num++;
            }
            //行尾
            for(int j=row-i;j>=i;j--){
                arr[row-i][j] = num;
                num++;
            }
            //列首
            for(int j=row-1-i;j>=i+1;j--){
                arr[j][i] = num;
                num++;
            }
        }
        if(n%2==1){
            arr[n/2][n/2] = num;
        }
        return arr;
    }
}






