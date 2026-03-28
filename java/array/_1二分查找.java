package array;

import java.util.Scanner;
public class _1二分查找{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] numsStr = sc.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for(int i = 0;i<numsStr.length;i++){
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        int target = sc.nextInt();
        Solution solution = new Solution();
        int res = solution.search(nums, target);
        System.out.println(res);
        sc.close();
        
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}