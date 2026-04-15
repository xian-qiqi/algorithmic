package hashTable;

import java.util.Scanner;
import java.util.*;
public class _5fourSumCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums1=null, nums2=null, nums3=null, nums4=null; //必须被初始化为 null，否则编译器会报错
        for(int i=0;i<4;i++){
            String[] str = sc.nextLine().split(","); // 直接在一行中读取并分割输入的数组元素
            int[] nums = new int[str.length];
            for(int j = 0; j < str.length; j++){
                nums[j] = Integer.parseInt(str[j]);
            }
            // 根据 i 的值将数组赋值给对应的变量
            if (i == 0) {
                nums1 = nums;
            } else if (i == 1) {
                nums2 = nums;
            } else if (i == 2) {
                nums3 = nums;
            } else {
                nums4 = nums;
            }
        }
        
        fourSumCountSolution solution = new fourSumCountSolution();
        int result = solution.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(result);
        sc.close();
    }
}
class fourSumCountSolution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0; //用于记录满足条件的四元组数量
        //map的键有唯一性，值没有唯一性，使用键来存储数组的和，值存储出现的次数
        //但是我怎样计算数组和呢？暴力法时间复杂度太高
        
        //那是不是也可以使用set来，每当出现一次0，将res++
        Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<len;i++){
        //     //如果map中不存在nums1[i]，则默认值为0
        //     map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        // }
        // //map不适合在里面进行计算，因为难以遍历map中的元素，所以只能在外面进行计算
        // for(int i=0;i<len;i++){
        //     //如果map中不存在nums2[i]，则默认值为0
        //     map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        // }

        for(int i : nums1){
            for(int j : nums2){
                map.put(i+j, map.getOrDefault(i+j, 0) + 1);
            }

        }
        for(int i : nums3){
            for(int j : nums4){
                // int sum = (i + j);
                // if(map.containsKey(-sum)){
                //     res += map.get(-sum);
                // }
                res+=map.getOrDefault(0-i-j,0);
            }

        }
        return res;
    }
}