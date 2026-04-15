package hashTable;

import java.util.Scanner;
import java.util.*;
public class _4twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(","); // 直接在一行中读取并分割输入的数组元素
        int[] nums = new int[str.length];
        for(int i = 0; i < str.length; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        int target = sc.nextInt();
        twoSumSolution solution = new twoSumSolution();
        int[] result = solution.twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        sc.close();
    }
}
//哈希表解法---直接查看前面数中是否有补数---六六六
class twoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int gap = target - nums[i];
            if(map.containsKey(gap)){ // 如果哈希表中存在补数，返回对应的索引
                return new int[]{map.get(gap), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}

