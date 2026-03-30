package array;

//时间复杂度O(n)
//空间复杂度O(n)
// import java.util.Scanner;
// public class _6区间和 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i] = sc.nextInt();
//         }
//         //当不输入区间下标时，停止输入，开始计算和,不确定要输入多少个区间
//         // int [][] range = new int[n][2];
//         // int m = 0; //用于记录写了多少个区间
//         //代码要不能使用输入结束标志 
//         //就不应该写class类，直接在main类里面些就好了
//         // while(true){
//         //     int a = sc.nextInt();
//         //     int b = sc.nextInt();
//         //     // 用 -1 -1 作为结束标识
//         //     if(a == -1 && b == -1){
//         //         break;
//         //     }
//         //     range[m][0] = a;
//         //     range[m][1] = b;
//         //     m++;
//         // }
//         // //输出
//         // rangeSumSolution solution = new rangeSumSolution();
//         // int[] res = solution.rangeSum(arr, range, m);
//         // for(int i=0;i<m;i++){
//         //     System.out.print(res[i]);
//         //     System.out.println();
//         // }

//         while(sc.hasNextInt()){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int sum = 0;
//             for(int i=a;i<=b;i++){
//                 sum += arr[i];
//             }
//             System.out.println(sum);
//         }
//         sc.close();
//     }
// }

// class rangeSumSolution {
//     public int[] rangeSum (int[] arr, int[][] range, int m) {
//         int[] sum = new int[m];
//         for(int i=0;i<m;i++){
//             for(int j=range[i][0];j<=range[i][1];j++){
//                 sum[i] += arr[j];
//             }
//         }
//         return sum;
//     }
// }


//前缀和-----时间复杂度O(1)，空间复杂度O(n)
import java.util.Scanner;
public class _6区间和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] p = new int[n];  //用于存储前缀和
        
        int presum = 0; //用于当前存储前缀和
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            presum += arr[i];
            p[i] = presum;
        }

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int sum;
            if (a == 0) {
                sum = p[b];
            } else {
                sum = p[b] - p[a - 1];
            }
            System.out.println(sum);
        }

        sc.close();
    }
}


