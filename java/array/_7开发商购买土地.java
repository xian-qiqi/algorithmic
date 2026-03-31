package array;

import java.util.Scanner;
public class _7开发商购买土地 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] land = new int[n][m];
        //时间复杂度O(n*m)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                land[i][j] = sc.nextInt();
            }
        }
        buyLandSolutin solution = new buyLandSolutin();
        int minGap = solution.buyLand(land);
        System.out.println(minGap);
    }
}

//代码随想录没有使用前缀和，而是使用了sum统计土地总大小，来计算最小差值----跟我代码差不多
class buyLandSolutin{
    public int buyLand(int[][] land){
        int n = land.length;
        int m = land[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        int minGap = Integer.MAX_VALUE; //用于记录最小差值
        //得到每一行和每一列的前缀和--时间复杂度O(n*m)
        for(int i=0;i<n;i++){
            int temp = 0;
            for(int j=0;j<m;j++){
                temp += land[i][j];
            }
            if(i==0){
                row[i] = temp;
            }else{
                row[i] = temp + row[i-1];
            }   
        }
        for(int i=0;i<m;i++){
            int temp = 0;
            for(int j=0;j<n;j++){
                temp += land[j][i];
            }
            if(i==0){
                col[i] = temp;
            }else{
                col[i] = temp + col[i-1];
            }   
        }
        //计算最小差值
        for(int i=0;i<n;i++){
            int rowGap = Math.abs((row[n-1]-row[i]) - row[i]);
            minGap = Math.min(minGap, rowGap);
        }
        for(int i=0;i<m;i++){
            int colGap = Math.abs((col[m-1]-col[i]) - col[i]);
            minGap = Math.min(minGap, colGap);
        }
        return minGap;
    }
}